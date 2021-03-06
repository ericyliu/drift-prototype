package com.originate.drift_prototype.game.models.event;

import com.originate.drift_prototype.R;
import com.originate.drift_prototype.app.models.User;
import com.originate.drift_prototype.game.models.character.Attribute;
import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.game.models.character.Stats;

import java.util.ArrayList;

public class Battle extends Event {

    public int  NUM_TEAMS = 2;

    public      ArrayList<ArrayList<Character>> teams = new ArrayList<>();
    public      ArrayList<User> users = new ArrayList<>();
    public      Character currentCharacter = null;

    public Battle(String name, String description) {
        this.name = name;
        this.description = description;
        for (int i=0; i < NUM_TEAMS; i++) {
            teams.add(new ArrayList<Character>());
            users.add(null);
        }
    }

    public void start () {
        for (ArrayList<Character> team : teams) {
            for (Character character : team) {
                character.applyEnchantments();
                if (character.alive) setMaxDelay(character);
            }
        }
    }

    public void nextTurn () {
        Character nextCharacter = null;
        while (nextCharacter == null) {
            nextCharacter = tick();
        }
        currentCharacter = nextCharacter;
    }

    public void end (User winner) {
        for (ArrayList<Character> team : teams) {
            for (Character character : team) {
                character.reset();
            }
        }
        winner.inventory.addAll(prize);
    }

    public int checkWinner () {
        int winningTeam = -1;
        for (int team = 0; team < teams.size(); team++) {
            if (checkTeamAlive(team)) {
                if (winningTeam != -1) return -1;
                else winningTeam = team;
            }
        }
        return winningTeam;
    }

    public void addUser (User user, int team) {
        users.set(team, user);
    }

    public void addCharacter (Character character, int team) {
        teams.get(team).add(character);
    }

    public void removeCharacter (Character character, int team) {
        teams.get(team).remove(character);
    }

    public Character getCharacter (int index, int team) {
        return teams.get(team).get(index);
    }

    public Character getCharacter (Character character, int team) {
        return getCharacter(teams.get(team).indexOf(character), team);
    }

    private void setMaxDelay (Character character) {
        Attribute agility = character.stats.get(Stats.Agility);
        agility.custom = R.integer.base_turn_delay/Math.sqrt(agility.current);
    }

    private boolean checkTeamAlive (int team) {
        for (Character character : teams.get(team)) {
            if (!character.alive) return false;
        }
        return true;
    }

    private Character tick () {
        Character nextCharacter = null;
        for (ArrayList<Character> team: teams) {
            for (Character character : team) {
                if (character.alive) character.stats.get(Stats.Agility).custom -= R.integer.tick_add;
            }
        }
        for (ArrayList<Character> team: teams) {
            for (Character character : team) {
                Attribute agility = character.stats.get(Stats.Agility);
                if (character.alive && agility.custom <= 0) {
                    if (nextCharacter == null ||
                            agility.custom < nextCharacter.stats.get(Stats.Agility).custom) {
                        nextCharacter = character;
                    }
                }
            }
        }
        setMaxDelay(nextCharacter);
        return nextCharacter;
    }
}

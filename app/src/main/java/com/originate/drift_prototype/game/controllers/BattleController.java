package com.originate.drift_prototype.game.controllers;

import com.originate.drift_prototype.app.models.User;
import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.game.models.ability.Ability;
import com.originate.drift_prototype.game.models.event.Battle;

public class BattleController {

    static Battle battle;

    public static void AssignBattle(Battle battle) {
        BattleController.battle = battle;
    }

    public static void InitBattle (String name, String desc) {
        battle = new Battle(name, desc);
    }

    public static void AddUser (User user, int team) {
        battle.addUser(user, team);
    }

    public static void AddCharacter (Character character, User owner) {
        int index = battle.users.indexOf(owner);
        if (index == -1) System.out.print("User is not in the battle.");
        battle.teams.get(index).add(character);
    }

    public static void PerformAttack (Character source, Character target, Ability ability) {
        source.useAbility(ability,target);
        int index = battle.checkWinner();
        if (index == -1) battle.nextTurn();
        else battle.end(battle.users.get(index));
    }

}

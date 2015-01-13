package com.originate.drift_prototype.app.models;

import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.game.models.character.Race;
import com.originate.drift_prototype.game.models.event.Event;
import com.originate.drift_prototype.game.models.item.Item;

import java.util.ArrayList;

public class User {

    public String           username;
    public Character character;
    public ArrayList<Item>  inventory;

    public ArrayList<Event>  events;

    public User (String user_name) {
        username = user_name;
        inventory = new ArrayList<>();
    }

    public void createNewCharacter (int id, String name) {
        character = new Character(id, name, Race.Human);
    }

}

package com.originate.drift_prototype.app.models;

import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.game.models.character.Race;
import com.originate.drift_prototype.game.models.event.Event;
import com.originate.drift_prototype.game.models.item.Item;

import java.util.ArrayList;

public class User {

    public int              id;
    public String           name;

    public int              money;
    public Character        character;
    public ArrayList<Item>  inventory;

    public ArrayList<Event>  events;

    public User (int user_id, String user_name) {
        id = user_id;
        name = user_name;
        inventory = new ArrayList<>();
    }

    public void createNewCharacter (int id, String name) {
        character = new Character(id, name, Race.Human);
    }

    @Override
    public int hashCode() {
        return (41 * (41 + id) + name.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User))
            return false;
        if (obj == this)
            return true;

        User user = (User) obj;
        return (id == user.id && name == user.name);
    }

}

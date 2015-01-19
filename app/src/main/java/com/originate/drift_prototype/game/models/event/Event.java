package com.originate.drift_prototype.game.models.event;

import com.originate.drift_prototype.game.models.item.Item;

import java.util.ArrayList;

public class Event {

    public String name;
    public String description;

    public ArrayList<Item> prize = new ArrayList<>();

    public void addPrize (Item item) {
        prize.add(item);
    }

}

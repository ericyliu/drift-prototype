package com.originate.drift_prototype.game.models.character;

import com.originate.drift_prototype.R;
import com.originate.drift_prototype.game.models.ability.Ability;
import com.originate.drift_prototype.game.models.item.Armor;
import com.originate.drift_prototype.game.models.item.Item;
import com.originate.drift_prototype.game.models.item.Ring;
import com.originate.drift_prototype.game.models.item.Weapon;
import com.originate.drift_prototype.utilities.ResLoader;

import java.util.ArrayList;
import java.util.HashMap;

public class Character {
    final static double    max_armor       = ResLoader.getInt(R.integer.max_armor_possible);
    final static double    max_reduction   = ResLoader.getInt(R.integer.max_damage_reduction);

    public int id;
    public String name;
    public Race race;

    public HashMap<Slots,Item> equipment;
    public HashMap<Stats,Attribute> stats;

    public ArrayList<Ability> attacks;
    public ArrayList<Ability> spells;

    public boolean alive = true;

    public double damageJustTaken;

    public Character (int id, String character_name, Race character_race) {
        name = character_name;
        race = character_race;
        attacks = new ArrayList<>();
        spells = new ArrayList<>();
        loadEquipment();
        loadStats();
    }

    public double getArmorRating () {
        double armorTotal = 0;
        for (Item item : equipment.values()) {
            if (item != null) armorTotal += getArmorRating(item);
        }
        double armorRating = armorTotal/max_armor;
        return 100 * Math.min(armorRating, max_reduction/100);
    }

    public double getDamageRating () {
        double damageTotal = 0;
        for (Item item : equipment.values()) {
            if (item != null) damageTotal += getDamageRating(item);
        }
        return damageTotal;
    }

    public void takeDamage (double damage) {
        Attribute health = stats.get(Stats.Health);
        double preHealth = health.current;
        health.setCurrent(health.current - damage);
        if (health.current == 0) alive = false;
        damageJustTaken = preHealth - health.current;
    }

    public void receiveHealth (double amount) {
        Attribute health = stats.get(Stats.Health);
        health.setCurrent(health.current + amount);
    }

    public void applyEnchantments () {
        for (Item item : equipment.values()) {
            item.applyStatusEffect(this, this);
        }
    }

    public Item equip (Item item) {
        Item unequippedItem = null;
        if (item instanceof Armor) {
            Armor armor = (Armor) item;
            unequippedItem = unequip(armor.type.slot);
            equipment.put(armor.type.slot, armor);
        }
        else if (item instanceof Weapon) {
            if (equipment.get(Slots.RightWeapon) == null) {
                equipment.put(Slots.RightWeapon, item);
            }
            else {
                unequippedItem = unequip(Slots.LeftWeapon);
                equipment.put(Slots.LeftWeapon, item);
            }
        }
        else if (item instanceof Ring) {
            if (equipment.get(Slots.Ring1) == null) {
                equipment.put(Slots.Ring1, item);
            }
            else {
                unequippedItem = unequip(Slots.Ring2);
                equipment.put(Slots.Ring2, item);
            }
        }
        return unequippedItem;
    }

    public Item unequip (Slots slot) {
        Item item = equipment.get(slot);
        equipment.put(slot, null);
        return item;
    }

    private void loadStats () {
        stats = new HashMap<>();
        for (Stats stat : Stats.values()) {
            stats.put(stat, new Attribute(race.stats.get(stat)));
        }
    }

    private void loadEquipment () {
        equipment = new HashMap<>();
        for (Slots slot : Slots.values()) {
            equipment.put(slot, null);
        }
    }

    private double getArmorRating(Item item) {
        if (item != null) return item.armor;
        return 0;
    }

    private double getDamageRating(Item item) {
        if (item != null) return item.damage;
        return 0;
    }

}

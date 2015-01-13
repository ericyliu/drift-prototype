package com.originate.drift_prototype.game.models.item;

import com.originate.drift_prototype.game.models.ability.Enchantment;
import com.originate.drift_prototype.game.models.character.Character;

import java.util.ArrayList;

public abstract class Item {

    public int      id;
    public String   name;
    public String   description;
    public String   icon;

    public Material material;

    public double   armor;
    public double   damage;

    public ArrayList<Enchantment> enchantments = new ArrayList<>();

    public void applyStatusEffect (Character source, Character target) {
        for (Enchantment enchant : enchantments) enchant.applyStatusEffect(source, target);
    }
    public void applyOnHitEffect (Character source, Character target) {
        for (Enchantment enchant : enchantments) enchant.applyOnHitEffect(source, target);
    }

}

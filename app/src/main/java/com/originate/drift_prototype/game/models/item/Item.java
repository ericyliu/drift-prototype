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

    public void applyStatusEffect (Character source) {
        for (Enchantment enchant : enchantments) enchant.applyStatusEffect(source);
    }
    public String applyOnHitEffect (Character source, Character target) {
        String text = "";
        for (Enchantment enchant : enchantments) text += enchant.applyOnHitEffect(source, target);
        return text;
    }
    public String applyOnPassiveEffect (Character source, Character target) {
        String text = "";
        for (Enchantment enchant : enchantments) text += enchant.applyOnPassiveEffect(source, target);
        return text;
    }

}

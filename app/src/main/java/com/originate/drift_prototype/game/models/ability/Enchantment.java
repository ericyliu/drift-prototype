package com.originate.drift_prototype.game.models.ability;

import com.originate.drift_prototype.game.models.character.Character;

public class Enchantment {

    public String name;
    public String description;

    public void applyStatusEffect (Character source) {};
    public String applyOnHitEffect (Character source, Character target) { return ""; };
    public String applyOnPassiveEffect(Character source, Character target) { return ""; };

}

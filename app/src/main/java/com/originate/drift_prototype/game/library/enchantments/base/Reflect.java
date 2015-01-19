package com.originate.drift_prototype.game.library.enchantments.base;

import com.originate.drift_prototype.game.models.ability.Enchantment;
import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.utilities.MoreMath;

public abstract class Reflect extends Enchantment {

    public double ratio;

    @Override
    public String applyOnPassiveEffect(Character source, Character target) {
        String output = "";
        double reflected = source.damageJustTaken * ratio;
        target.takeDamage(reflected);
        output += String.format("[Reflect] %s reflected %d damage to %s. ",
                                source.name, MoreMath.doubleToInt(reflected), target.name);
        return output;
    }

}

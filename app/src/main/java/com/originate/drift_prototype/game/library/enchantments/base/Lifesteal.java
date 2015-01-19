package com.originate.drift_prototype.game.library.enchantments.base;

import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.game.models.ability.Enchantment;
import com.originate.drift_prototype.utilities.MoreMath;

public abstract class Lifesteal extends Enchantment {

    public double ratio;

    @Override
    public String applyOnHitEffect (Character source, Character target) {
        double healthReceived = target.damageJustTaken * ratio;
        source.receiveHealth(healthReceived);
        return String.format("[Lifesteal] %s took %d life from %s. ", source.name,
                             MoreMath.doubleToInt(healthReceived), target.name);
    }

}

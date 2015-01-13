package com.originate.drift_prototype.game.library.enchantments.base;

import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.game.models.ability.Enchantment;

public abstract class Lifesteal extends Enchantment {

    public double ratio;

    @Override
    public void applyOnHitEffect (Character source, Character target) {
        source.receiveHealth(target.damageJustTaken * ratio);
    }

}

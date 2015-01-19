package com.originate.drift_prototype.game.library.enchantments.base;

import com.originate.drift_prototype.game.models.ability.Enchantment;
import com.originate.drift_prototype.game.models.character.Attribute;
import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.game.models.character.Stats;

public class Knowledge extends Enchantment {

    public double bonus;

    @Override
    public void applyStatusEffect (Character source) {
        Attribute intelligence = source.stats.get(Stats.Intelligence);
        intelligence.setMax(intelligence.max + bonus);
    }

}

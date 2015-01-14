package com.originate.drift_prototype.game.library.abilities;

import com.originate.drift_prototype.R;
import com.originate.drift_prototype.game.models.ability.Ability;
import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.game.models.character.Stats;
import com.originate.drift_prototype.utilities.ResLoader;
import com.originate.drift_prototype.utilities.MoreMath;

public class Heal extends Ability {

    public double baseAmount    = ResLoader.resources.getInteger(R.integer.heal_amt);

    public Heal () {
        name = ResLoader.getStr(R.string.heal_name);
        description = ResLoader.getStr(R.string.heal_desc);
    }

    @Override
    public String invoke(Character source, Character target) {
        double amount = baseAmount;

        amount += source.stats.get(Stats.Intelligence).current * .50;
        target.receiveHealth(amount);

        if (source.id == target.id) {
            return String.format("%s has healed themselves for %d.",
                                 source.name, MoreMath.doubleToInt(amount));
        }
        else {
            return String.format("%s has healed %s for %d.",
                                 source.name, target.name,
                                 MoreMath.doubleToInt(amount));
        }
    }
}

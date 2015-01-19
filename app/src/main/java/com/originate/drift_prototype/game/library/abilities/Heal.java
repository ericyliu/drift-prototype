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
        onHit = false;
        onPassive = false;
    }

    @Override
    public String invoke(Character source, Character target) {
        String output = "";
        double amount = baseAmount;

        amount += source.stats.get(Stats.Intelligence).current * .50;
        target.receiveHealth(amount);

        if (source.id == target.id) {
            output +=  String.format("[Spell] %s has healed themselves for %d. ",
                                     source.name, MoreMath.doubleToInt(amount));
        }
        else {
            output +=  String.format("[Spell] %s has healed %s for %d. ",
                                     source.name, target.name,
                                     MoreMath.doubleToInt(amount));
        }
        output += super.invoke(source, target);
        return output;
    }
}

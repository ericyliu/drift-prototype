package com.originate.drift_prototype.game.library.abilities;


import com.originate.drift_prototype.R;
import com.originate.drift_prototype.game.models.ability.Ability;
import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.game.models.character.Stats;
import com.originate.drift_prototype.game.models.item.Item;
import com.originate.drift_prototype.utilities.ResLoader;
import com.originate.drift_prototype.utilities.MoreMath;

public class Slash extends Ability {

    public double baseDamage    = ResLoader.resources.getInteger(R.integer.slash_dmg);

    public Slash () {
        name = ResLoader.getStr(R.string.slash_name);
        description = ResLoader.getStr(R.string.slash_desc);
    }

    @Override
    public String invoke (Character source, Character target) {
        String output = "";
        //Calculate damage
        double damage = baseDamage;
        damage += (source.stats.get(Stats.Strength).current * .50) +
                  (source.stats.get(Stats.Agility).current * .10) +
                  source.getDamageRating();
        damage *= 1-(target.getArmorRating()/100);
        //Deal damage and on hit
        target.takeDamage(damage);
        //Set output string
        output = String.format("[Attack] %s used %s on %s for %d damage. ",
                                        source.name, name, target.name,
                                        MoreMath.doubleToInt(damage));
        output += super.invoke(source, target);
        return output;
    }
}

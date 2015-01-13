package com.originate.drift_prototype.game.library.abilities;


import com.originate.drift_prototype.R;
import com.originate.drift_prototype.game.models.ability.Ability;
import com.originate.drift_prototype.game.models.character.Character;
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
        //Calculate damage
        double damage = baseDamage;
        damage += (source.stats.get("strength").current * .50) +
                  (source.stats.get("agility").current * .10) +
                  source.getDamageRating();
        damage *= 1-(target.getArmorRating()/100);
        //Deal damage and on hit
        target.takeDamage(damage);
        for (Item item : source.equipment.values()) {
            item.applyOnHitEffect(source, target);
        }
        //Return console string
        return String.format("%s used %s on %s. It did %d damage.",
                             source.name, name, target.name,
                             MoreMath.doubleToInt(damage));
    }
}

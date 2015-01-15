package com.originate.drift_prototype.game.models.ability;

import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.game.models.item.Item;

public abstract class Ability {

    public String   name;
    public String   description;
    public Boolean  onHit = true;
    public Boolean  onPassive = true;

    public String invoke (Character source, Character target) {
        String output = "";
        if (onHit) {
            for (Item item : source.equipment.values()) {
                if (item != null) {
                    output += item.applyOnHitEffect(source, target);
                }
            }
        }
        if (onPassive) {
            for (Item item : target.equipment.values()) {
                if (item != null) {
                    output += item.applyOnPassiveEffect(target, source);
                }
            }
        }
        return output;
    }

}

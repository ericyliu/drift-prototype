package com.originate.drift_prototype.game.library.items;

import com.originate.drift_prototype.R;
import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.game.models.item.Consumable;
import com.originate.drift_prototype.utilities.ResLoader;

public class HealthPotion extends Consumable {

    public double amount = ResLoader.getInt(R.integer.health_potion_amount);

    public HealthPotion () {
        name        = ResLoader.getStr(R.string.health_potion_name);
        description = ResLoader.getStr(R.string.health_potion_desc);
    }

    @Override
    public void use(Character source, Character target) {
        source.receiveHealth(amount);
    }
}

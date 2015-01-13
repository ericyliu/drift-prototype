package com.originate.drift_prototype.game.models.item;

import com.originate.drift_prototype.game.models.character.Character;

public abstract class Consumable extends Item {

    public abstract void use(Character source, Character target);

}


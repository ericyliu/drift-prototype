package com.originate.drift_prototype.game.models.ability;

import com.originate.drift_prototype.game.models.character.Character;

public abstract class Ability {

    public String name;
    public String description;

    public abstract String invoke (Character source, Character target);

}

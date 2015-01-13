package com.originate.drift_prototype.game.models.item;

import com.originate.drift_prototype.game.models.character.Slots;

public enum ArmorType {
    Helmet      (Slots.Head),
    Hat         (Slots.Head),
    Shirt       (Slots.Chest),
    Platemail   (Slots.Chest),
    Chainmail   (Slots.Chest),
    Cuirass     (Slots.Chest),
    Gauntlet    (Slots.Hands),
    Gloves      (Slots.Hands),
    Bracers     (Slots.Hands),
    Boots       (Slots.Feet),
    Pants       (Slots.Legs),
    Greaves     (Slots.Legs);

    public final Slots slot;

    ArmorType (Slots slot) {
        this.slot = slot;
    }
}

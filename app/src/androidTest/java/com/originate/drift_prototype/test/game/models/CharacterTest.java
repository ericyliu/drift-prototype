package com.originate.drift_prototype.test.game.models;

import android.test.ActivityInstrumentationTestCase2;

import com.originate.drift_prototype.MainActivity;
import com.originate.drift_prototype.game.library.items.BronzeHelmet;
import com.originate.drift_prototype.game.library.items.BronzeSword;
import com.originate.drift_prototype.game.models.character.Attribute;
import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.game.models.character.Race;
import com.originate.drift_prototype.game.models.character.Slots;
import com.originate.drift_prototype.game.models.character.Stats;
import com.originate.drift_prototype.game.models.item.Armor;

public class CharacterTest extends ActivityInstrumentationTestCase2<MainActivity> {

    Character character;

    public CharacterTest () {
        super(MainActivity.class);
    }

    @Override
    protected void setUp () throws Exception {
        super.setUp();
        System.out.print(getActivity());
        character = new Character(0, "Test_Name", Race.Human);
    }

    public void testPreconditions () {
        assertNotNull("character is null", character);
    }

    public void testCharacterValues () {
        assertEquals("character id is not 0", character.id, 0);
        assertEquals("character name is not Test_Name", character.name,"Test_Name");
        assertEquals("character race is not human", character.race,Race.Human);
    }

    public void testStats () {
        assertEquals("character health is not 20", character.stats.get(Stats.Health).base, 20.0d);
        assertEquals("character mana is not 10", character.stats.get(Stats.Mana).base, 10.0d);
        assertEquals("character agility is not 5", character.stats.get(Stats.Agility).base, 5.0d);
        assertEquals("character intelligence is not 5", character.stats.get(Stats.Intelligence).base, 5.0d);
        assertEquals("character strength is not 6", character.stats.get(Stats.Strength).base, 6.0d);
    }

    public void testEquip () {
        character.equip(new BronzeHelmet());
        assertNotNull("character does not have bronze helmet",
                character.equipment.get(Slots.Head));
        character.equip(new BronzeSword());
        assertNotNull("character is not holding sword in right hand",
                      character.equipment.get(Slots.RightWeapon));
        character.unequip(Slots.Head);
        character.unequip(Slots.RightWeapon);
    }

    public void testArmorRating () {
        assertEquals("armor rating is not 0 with no items",
                     character.getArmorRating(), 0.0d);
        Armor helmet = new BronzeHelmet();
        character.equip(helmet);
        assertEquals("armor rating is not 1.5 with only bronze helmet",
                     character.getArmorRating(), 1.5d);
        character.unequip(Slots.Head);
    }

    public void testDamageRating () {
        assertEquals("damage rating is not 0 with no items",
                     character.getDamageRating(), 0.0d);
        character.equip(new BronzeSword());
        assertEquals("damage rating is not 5 with bronze sword",
                     character.getDamageRating(), 5.0d);
        character.unequip(Slots.RightWeapon);
    }

    public void testTakeDamage () {
        Attribute health = character.stats.get(Stats.Health);
        assertEquals("health is not full", health.current, health.max);
        character.takeDamage(5d);
        assertEquals("health is not lowered by 5", health.current, health.max - 5);
        character.takeDamage(health.current + 1);
        assertEquals("health went below 0", health.current, 0d);
        assertEquals("character is not dead", character.alive, false);
    }

    public void testReceiveHealth () {
        Attribute health = character.stats.get(Stats.Health);
        assertEquals("health is not full", health.current, health.max);
        character.receiveHealth(5);
        assertEquals("health is not full", health.current, health.max);
    }
}

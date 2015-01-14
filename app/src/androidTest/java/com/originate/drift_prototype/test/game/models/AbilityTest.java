package com.originate.drift_prototype.test.game.models;

import android.test.ActivityInstrumentationTestCase2;

import com.originate.drift_prototype.MainActivity;
import com.originate.drift_prototype.game.library.abilities.Heal;
import com.originate.drift_prototype.game.library.abilities.Slash;
import com.originate.drift_prototype.game.models.ability.Ability;
import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.game.models.character.Race;
import com.originate.drift_prototype.game.models.character.Stats;

public class AbilityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    Character character;
    Character target;

    public AbilityTest () { super(MainActivity.class); }

    @Override
    protected void setUp () throws Exception {
        super.setUp();
        getActivity();
        character = new Character(0, "Char1", Race.Human);
        target = new Character(1, "Char2", Race.Human);
    }

    public void testPreconditions () {
        assertNotNull("character is null", character);
        assertNotNull("target is null", target);
    }

    public void testHeal () {
        Ability heal = new Heal();
        character.spells.add(heal);
        target.takeDamage(10);
        String output = character.useAbility(heal, target);
        assertEquals("String output does not match", output, "Char1 has healed Char2 for 4.");
        assertEquals("Target health is not 14", target.stats.get(Stats.Health).current, 13.5d);
        output = character.useAbility(heal, character);
        assertEquals("String output does not match", output, "Char1 has healed themselves for 4.");
    }

    public void testSlash () {
        Ability slash = new Slash();
        character.attacks.add(slash);
        String output = character.useAbility(slash, target);
        assertEquals("String output does not match", output, "Char1 used Slash on Char2. It did 5 damage.");
        assertEquals("Target health is not", target.stats.get(Stats.Health).current, 15.5d);
    }


}

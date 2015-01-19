package com.originate.drift_prototype.test.game.models;

import android.test.ActivityInstrumentationTestCase2;

import com.originate.drift_prototype.MainActivity;
import com.originate.drift_prototype.game.library.abilities.Slash;
import com.originate.drift_prototype.game.library.enchantments.AncientKnowledge;
import com.originate.drift_prototype.game.library.enchantments.Bloodsuck;
import com.originate.drift_prototype.game.library.enchantments.Thorns;
import com.originate.drift_prototype.game.library.items.BronzeSword;
import com.originate.drift_prototype.game.models.ability.Ability;
import com.originate.drift_prototype.game.models.ability.Enchantment;
import com.originate.drift_prototype.game.models.character.Attribute;
import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.game.models.character.Race;
import com.originate.drift_prototype.game.models.character.Stats;
import com.originate.drift_prototype.game.models.item.Item;

public class EnchantmentTest extends ActivityInstrumentationTestCase2<MainActivity>{

    Character character;
    Character target;

    public EnchantmentTest () { super(MainActivity.class); }

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

    public void testApplyStatus () {
        Enchantment ak = new AncientKnowledge();
        Item sword = new BronzeSword();
        sword.enchantments.add(ak);
        character.equip(sword);
        character.applyEnchantments();
        Attribute intel = character.stats.get(Stats.Intelligence);
        assertEquals("Stat does not match", intel.max, 10d);
        assertEquals("Description does not match", ak.description, "Increases your intelligence by 5.");
    }

    public void testOnHit () {
        Enchantment bloodsuck = new Bloodsuck();
        Ability slash = new Slash();
        Item sword = new BronzeSword();
        sword.enchantments.add(bloodsuck);
        character.equip(sword);
        character.takeDamage(5d);
        String output = character.useAbility(slash, target);
        assertEquals("Output does not match", output,
                    "[Attack] Char1 used Slash on Char2 for 10 damage. [Lifesteal] Char1 took 3 life from Char2. ");
        assertEquals("Health is not correct", character.stats.get(Stats.Health).current, 17.85d);
    }

    public void testOnPassive () {
        Enchantment thorns = new Thorns();
        Ability slash = new Slash();
        Item sword = new BronzeSword();
        sword.enchantments.add(thorns);
        target.equip(sword);
        String output = character.useAbility(slash, target);
        assertEquals("Output does not match", output,
                     "[Attack] Char1 used Slash on Char2 for 5 damage. [Reflect] Char2 reflected 1 damage to Char1. ");
        assertEquals("Health is not correct", character.stats.get(Stats.Health).current, 18.65d);
    }


}

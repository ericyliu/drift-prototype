package com.originate.drift_prototype.test.game.models;

import android.test.ActivityInstrumentationTestCase2;

import com.originate.drift_prototype.MainActivity;
import com.originate.drift_prototype.app.models.User;
import com.originate.drift_prototype.game.library.items.BronzeSword;
import com.originate.drift_prototype.game.models.character.Attribute;
import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.game.models.character.Race;
import com.originate.drift_prototype.game.models.character.Stats;
import com.originate.drift_prototype.game.models.event.Battle;

public class BattleTest extends ActivityInstrumentationTestCase2<MainActivity> {

    Character   char1;
    Character   char2;

    User        user;

    Battle      battle;

    public BattleTest () { super(MainActivity.class); }

    @Override
    protected void setUp () throws Exception {
        super.setUp();
        getActivity();
        char1 = new Character(0, "Char1", Race.Human);
        char2 = new Character(1, "Char2", Race.Human);
        battle = new Battle("Test Battle","This is a test battle.");
        battle.addPrize(new BronzeSword());
        battle.addCharacter(char1, 0);
        battle.addCharacter(char2, 1);
        user = new User(0,"User");
        battle.addUser(user, 0);
    }

    public void testPreconditions () {
        assertNotNull("char1 is null", char1);
        assertNotNull("char2 is null", char2);
        assertNotNull("battle is null", battle);
    }

    public void testOnAdd () {
        assertEquals("char1 not on team 0",char1,battle.getCharacter(0,0));
        assertEquals("char2 not on team 1",char2,battle.getCharacter(0,1));
        assertEquals("user is not first user",user,battle.users.get(0));
    }

    public void testStart () {
        Attribute char1Agi = char1.stats.get(Stats.Agility);
        Attribute char2Agi = char2.stats.get(Stats.Agility);
        char1Agi.setMax(20);
        battle.start();
        assertTrue("char1 is not faster than char2",char1Agi.custom < char2Agi.custom);
    }

    public void testTurnChange () {
        char1.stats.get(Stats.Agility).setMax(20);
        battle.start();
        battle.nextTurn();
        assertEquals("current character not char1", char1, battle.currentCharacter);
    }

    public void testWinner () {
        battle.start();
        battle.end(user);
        assertEquals("prize not in winner inventory", "Bronze Sword", user.inventory.get(0).name);
    }

}

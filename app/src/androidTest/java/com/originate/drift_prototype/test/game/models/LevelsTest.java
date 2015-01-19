package com.originate.drift_prototype.test.game.models;

import android.test.ActivityInstrumentationTestCase2;

import com.originate.drift_prototype.MainActivity;
import com.originate.drift_prototype.game.models.character.Character;
import com.originate.drift_prototype.game.models.character.Levels;
import com.originate.drift_prototype.game.models.character.Race;

public class LevelsTest extends ActivityInstrumentationTestCase2<MainActivity> {

    Character character;

    public LevelsTest () { super(MainActivity.class); }

    @Override
    protected void setUp () throws Exception {
        super.setUp();
        getActivity();
        character = new Character(0, "Char1", Race.Human);
    }

    public void testPreConditions() { assertNotNull("character is null", character); }

    public void testLevelChart () {
        int[] chart = Levels.experienceForLevel;
        assertEquals("does not take 10 xp for level 1", chart[1], 10);
        assertEquals("does not take 1000000 xp for level 100", chart[100], 1000000);
    }

    public void testExperienceGain () {
        character.gainExperience(5);
        assertEquals("character is not level 1", character.level, 1);
        character.gainExperience(5);
        assertEquals("character is not level 2", character.level, 2);
        character.gainExperience(30);
        assertEquals("character is not level 4", character.level, 4);
    }

}

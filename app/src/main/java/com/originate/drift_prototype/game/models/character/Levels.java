package com.originate.drift_prototype.game.models.character;

import com.originate.drift_prototype.R;
import com.originate.drift_prototype.utilities.ResLoader;

public class Levels {

    public static int[] experienceForLevel;
    public static int maxLevel = ResLoader.getInt(R.integer.max_level);
    public static int minXP = ResLoader.getInt(R.integer.exp_min_level);
    public static int maxXP = ResLoader.getInt(R.integer.exp_max_level);

    static {
        experienceForLevel = calculateExperience();
    }

    private static int[] calculateExperience () {
        double B = Math.log((double)maxXP/minXP) / (maxLevel -1);
        double A = (double) minXP / (Math.exp(B) - 1.0);

        int[] xpChart = new int[maxLevel+1];
        xpChart[0] = 0;
        for (int i = 1; i < maxLevel+1; i++) {
            Long longOldXP = Math.round(A * Math.exp(B * (i-1)));
            int oldXP = longOldXP.intValue();
            Long longNewXP = Math.round(A * Math.exp(B * i));
            int newXP = longNewXP.intValue();
            xpChart[i] = newXP - oldXP;
        }
        return xpChart;
    }

}

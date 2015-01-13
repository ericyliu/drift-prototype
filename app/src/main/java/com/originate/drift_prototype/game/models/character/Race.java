package com.originate.drift_prototype.game.models.character;

import com.originate.drift_prototype.utilities.ResLoader;

import java.util.HashMap;

public enum Race {

    Human   ("Human");

    public final String toString;
    public final HashMap<Stats,Double> stats;

    Race (String name) {
        toString = name;
        stats = new HashMap<>();
        for (Stats stat : Stats.values()) {
            String resName = name + "_" + stat.name();
            int resID = ResLoader.context.getResources().getIdentifier(resName, "string", "com.originate.drift_prototype");
            stats.put(stat, ResLoader.getDbl(resID));
        }
    }

}

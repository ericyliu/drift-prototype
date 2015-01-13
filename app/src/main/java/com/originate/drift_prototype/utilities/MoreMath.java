package com.originate.drift_prototype.utilities;

public class MoreMath {

    public static int doubleToInt (double n) {
        Long longNum = Math.round(n);
        return longNum.intValue();
    }

}

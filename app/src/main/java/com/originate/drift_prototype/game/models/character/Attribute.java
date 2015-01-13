package com.originate.drift_prototype.game.models.character;

public class Attribute {

    public double base = 1;
    public double max = 1;
    public double current = 1;

    public double custom;

    public Attribute (double baseAttr) {
        base = baseAttr;
        max = baseAttr;
        current = baseAttr;
    }

    public void resetMax () {
        max = base;
        if (current > max) current = max;
    }

    public void resetCurrent () { current = max; }

    public void setBase (double value) {
        base = value;
        resetMax();
    }

    public void setMax (double value) {
        double ratio = 0;
        if (max > 0) ratio = current/max;
        max = value;
        current = ratio * max;
    }

    public void setCurrent (double value) {
        current = value;
        if (current > max) current = max;
        if (current < 0) current = 0;
    }

}

package com.originate.drift_prototype.game.library.enchantments;

import com.originate.drift_prototype.R;
import com.originate.drift_prototype.game.library.enchantments.base.Reflect;
import com.originate.drift_prototype.utilities.ResLoader;

public class Thorns extends Reflect {

    public Thorns () {
        name = ResLoader.getStr(R.string.thorns_name);
        ratio = ResLoader.getDbl(R.string.thorns_ratio);
    }

}

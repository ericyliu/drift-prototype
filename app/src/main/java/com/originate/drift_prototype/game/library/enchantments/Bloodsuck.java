package com.originate.drift_prototype.game.library.enchantments;


import com.originate.drift_prototype.R;
import com.originate.drift_prototype.game.library.enchantments.base.Lifesteal;
import com.originate.drift_prototype.utilities.ResLoader;

public class Bloodsuck extends Lifesteal {

    public Bloodsuck () {
        name = ResLoader.getStr(R.string.bloodsuck_name);
        ratio = ResLoader.getDbl(R.string.bloodsuck_ratio);
    }

}

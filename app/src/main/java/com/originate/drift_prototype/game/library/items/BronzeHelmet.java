package com.originate.drift_prototype.game.library.items;

import com.originate.drift_prototype.R;
import com.originate.drift_prototype.game.models.item.Armor;
import com.originate.drift_prototype.game.models.item.ArmorType;
import com.originate.drift_prototype.game.models.item.Material;
import com.originate.drift_prototype.utilities.ResLoader;

public class BronzeHelmet extends Armor {

    public BronzeHelmet () {
        name        = ResLoader.getStr(R.string.bronze_helmet_name);
        description = ResLoader.getStr(R.string.bronze_helmet_desc);
        type        = ArmorType.Helmet;
        material    = Material.Bronze;
        armor       = ResLoader.getInt(R.integer.bronze_helmet_armor);
    }

}

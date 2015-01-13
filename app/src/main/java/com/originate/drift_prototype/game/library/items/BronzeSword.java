package com.originate.drift_prototype.game.library.items;

import com.originate.drift_prototype.R;
import com.originate.drift_prototype.game.models.item.Material;
import com.originate.drift_prototype.game.models.item.Weapon;
import com.originate.drift_prototype.game.models.item.WeaponType;
import com.originate.drift_prototype.utilities.ResLoader;

public class BronzeSword extends Weapon {

    public BronzeSword () {
        name        = ResLoader.getStr(R.string.bronze_sword_name);
        description = ResLoader.getStr(R.string.bronze_sword_desc);
        type        = WeaponType.Sword;
        material    = Material.Bronze;
        damage      = ResLoader.getInt(R.integer.bronze_sword_damage);
    }

}

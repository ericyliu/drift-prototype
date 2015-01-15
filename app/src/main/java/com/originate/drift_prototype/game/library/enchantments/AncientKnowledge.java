package com.originate.drift_prototype.game.library.enchantments;

import com.originate.drift_prototype.R;
import com.originate.drift_prototype.game.library.enchantments.base.Knowledge;
import com.originate.drift_prototype.utilities.MoreMath;
import com.originate.drift_prototype.utilities.ResLoader;

public class AncientKnowledge extends Knowledge {

    public AncientKnowledge () {
        name = ResLoader.getStr(R.string.ancient_knowledge_name);
        bonus = ResLoader.getDbl(R.string.ancient_knowledge_bonus);
        description = String.format("Increases your intelligence by %d.", MoreMath.doubleToInt(bonus));
    }

}

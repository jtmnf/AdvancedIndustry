package com.jtmnf.advancedindustry.items;

import com.jtmnf.advancedindustry.AdvancedIndustry;
import net.minecraft.item.ItemSword;

public class BasicSword extends ItemSword {
    public BasicSword(String unlocalizedName, ToolMaterial toolMaterial) {
        super(toolMaterial);

        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(AdvancedIndustry.tab);
    }
}

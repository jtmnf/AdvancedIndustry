package com.jtmnf.advancedindustry.items;

import com.jtmnf.advancedindustry.AdvancedIndustry;
import net.minecraft.item.ItemHoe;

public class BasicHoe extends ItemHoe {
    public BasicHoe(String unlocalizedName, ToolMaterial toolMaterial) {
        super(toolMaterial);

        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(AdvancedIndustry.tab);
    }
}

package com.jtmnf.advancedindustry.items;

import com.jtmnf.advancedindustry.AdvancedIndustry;
import net.minecraft.item.ItemAxe;

public class BasicAxe extends ItemAxe {
    public BasicAxe(String unlocalizedName, ToolMaterial toolMaterial) {
        super(toolMaterial);

        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(AdvancedIndustry.tab);
    }
}

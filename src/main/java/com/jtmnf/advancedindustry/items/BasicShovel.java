package com.jtmnf.advancedindustry.items;

import com.jtmnf.advancedindustry.AdvancedIndustry;
import net.minecraft.item.ItemSpade;

public class BasicShovel extends ItemSpade {
    public BasicShovel(String unlocalizedName, ToolMaterial toolMaterial) {
        super(toolMaterial);

        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(AdvancedIndustry.tab);
    }
}

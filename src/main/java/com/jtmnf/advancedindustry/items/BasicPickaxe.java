package com.jtmnf.advancedindustry.items;

import com.jtmnf.advancedindustry.AdvancedIndustry;
import net.minecraft.item.ItemPickaxe;

public class BasicPickaxe extends ItemPickaxe {
    public BasicPickaxe(String unlocalizedName, ToolMaterial toolMaterial) {
        super(toolMaterial);

        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(AdvancedIndustry.tab);
    }
}

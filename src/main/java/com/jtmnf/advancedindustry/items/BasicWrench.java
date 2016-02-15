package com.jtmnf.advancedindustry.items;

import com.jtmnf.advancedindustry.AdvancedIndustry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemTool;

import java.util.HashSet;

public class BasicWrench extends ItemTool {

    private int MAX_DAMAGE_WRENCH = 128;

    public BasicWrench(String unlocalizedName) {
        super(1F, ToolMaterial.IRON, new HashSet<Block>());

        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(AdvancedIndustry.tab);

        this.setMaxDamage(MAX_DAMAGE_WRENCH);
    }
}

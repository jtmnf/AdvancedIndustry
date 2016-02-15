package com.jtmnf.advancedindustry.renderer;

import com.jtmnf.advancedindustry.AdvancedIndustry;
import com.jtmnf.advancedindustry.init.AdvancedIndustryBlock;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class BlockRenderRegister {
    public static void registerBlockRenderer() {
        register(AdvancedIndustryBlock.blockCopper);
        register(AdvancedIndustryBlock.blockTin);
        register(AdvancedIndustryBlock.oreCopper);
        register(AdvancedIndustryBlock.oreTin);
        register(AdvancedIndustryBlock.simpleGenerator);
        register(AdvancedIndustryBlock.storageCell);
    }

    private static void register(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(AdvancedIndustry.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
    }
}

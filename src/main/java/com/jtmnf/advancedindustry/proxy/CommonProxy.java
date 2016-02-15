package com.jtmnf.advancedindustry.proxy;

import com.jtmnf.advancedindustry.init.AdvancedIndustryBlock;
import com.jtmnf.advancedindustry.init.AdvancedIndustryItems;
import com.jtmnf.advancedindustry.init.AdvancedIndustryRecipes;
import com.jtmnf.advancedindustry.init.AdvancedIndustryTileEntities;
import com.jtmnf.advancedindustry.worldgen.WorldGen;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        AdvancedIndustryItems.createItems();
        AdvancedIndustryBlock.createBlocks();
        AdvancedIndustryTileEntities.init();
        AdvancedIndustryRecipes.initCrafting();

        GameRegistry.registerWorldGenerator(new WorldGen(), 0);
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
package com.jtmnf.advancedindustry.init;

import com.jtmnf.advancedindustry.blocks.BasicBlock;
import com.jtmnf.advancedindustry.blocks.SimpleGenerator;
import com.jtmnf.advancedindustry.blocks.StorageCell;
import com.jtmnf.advancedindustry.wires.WireCable;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AdvancedIndustryBlock {


    public static Block oreCopper = new BasicBlock("oreCopper");
    public static Block oreTin = new BasicBlock("oreTin");
    public static Block blockCopper = new BasicBlock("blockCopper");
    public static Block blockTin = new BasicBlock("blockTin");
    public static Block simpleGenerator = new SimpleGenerator("simpleGenerator");
    public static Block wireCable = new WireCable("wireCable");
    public static Block storageCell = new StorageCell("storageCell");

    public static void createBlocks(){
        GameRegistry.registerBlock(oreCopper, "oreCopper");
        GameRegistry.registerBlock(oreTin, "oreTin");
        GameRegistry.registerBlock(blockCopper, "blockCopper");
        GameRegistry.registerBlock(blockTin, "blockTin");
        GameRegistry.registerBlock(simpleGenerator, "simpleGenerator");
        GameRegistry.registerBlock(wireCable, "wireCable");
        GameRegistry.registerBlock(storageCell, "storageCell");
    }
}

package com.jtmnf.advancedindustry.init;

import com.jtmnf.advancedindustry.tileentities.SimpleGeneratorTile;
import com.jtmnf.advancedindustry.tileentities.StorageCellTile;
import com.jtmnf.advancedindustry.tileentities.WireCableTile;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AdvancedIndustryTileEntities {
    public static void init() {
        GameRegistry.registerTileEntity(SimpleGeneratorTile.class, "simpleGenerator");
        GameRegistry.registerTileEntity(WireCableTile.class, "wireCable");
        GameRegistry.registerTileEntity(StorageCellTile.class, "storageCell");
    }
}

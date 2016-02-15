package com.jtmnf.advancedindustry;

import com.jtmnf.advancedindustry.creativetab.CreativeTabMod;
import com.jtmnf.advancedindustry.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AdvancedIndustry.MODID, name = AdvancedIndustry.MODNAME, version = AdvancedIndustry.VERSION)
public class AdvancedIndustry {
    public static final String MODID = "advancedindustry";
    public static final String MODNAME = "AdvancedIndustry";
    public static final String VERSION = "1.0.0";

    @Mod.Instance
    public static AdvancedIndustry instance = new AdvancedIndustry();

    public static final CreativeTabMod tab = new CreativeTabMod("advancedIndustryTab");

    @SidedProxy(clientSide = "com.jtmnf.advancedindustry.proxy.ClientProxy", serverSide = "com.jtmnf.advancedindustry.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        this.proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        this.proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        this.proxy.postInit(e);
    }
}

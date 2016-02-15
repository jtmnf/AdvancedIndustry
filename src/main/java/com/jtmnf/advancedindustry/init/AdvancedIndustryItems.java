package com.jtmnf.advancedindustry.init;

import com.jtmnf.advancedindustry.items.*;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class AdvancedIndustryItems {

    //ToolMaterials
    public static Item.ToolMaterial COPPER = EnumHelper.addToolMaterial("COPPER", 2, 950, 8.0F, 3.0F, 20);
    public static Item.ToolMaterial TIN = EnumHelper.addToolMaterial("TIN", 2, 950, 8.0F, 3.0F, 20);

    //Ingots
    public static Item ingotTin = new BasicItem("ingotTin");
    public static Item ingotCopper = new BasicItem("ingotCopper");

    //Dust
    public static Item dustCopper = new BasicItem("dustCopper");
    public static Item dustTin = new BasicItem("dustTin");
    public static Item dustGold = new BasicItem("dustGold");
    public static Item dustIron = new BasicItem("dustIron");
    public static Item dustCoal = new BasicItem("dustCoal");
    public static Item dustDiamond = new BasicItem("dustDiamond");

    //Tools
    public static Item pickaxeCopper = new BasicPickaxe("pickaxeCopper", COPPER);
    public static Item pickaxeTin = new BasicPickaxe("pickaxeTin", TIN);
    public static Item axeCopper = new BasicAxe("axeCopper", COPPER);
    public static Item axeTin = new BasicAxe("axeTin", TIN);
    public static Item shovelCopper = new BasicShovel("shovelCopper", COPPER);
    public static Item shovelTin = new BasicShovel("shovelTin", TIN);
    public static Item swordCopper = new BasicSword("swordCopper", COPPER);
    public static Item swordTin = new BasicSword("swordTin", TIN);
    public static Item hoeCopper = new BasicHoe("hoeCopper", COPPER);
    public static Item hoeTin = new BasicHoe("hoeTin", TIN);

    public static Item wrench = new BasicWrench("wrench");



    public static void createItems() {
        GameRegistry.registerItem(ingotCopper, "ingotCopper");
        GameRegistry.registerItem(ingotTin, "ingotTin");

        GameRegistry.registerItem(dustCopper, "dustCopper");
        GameRegistry.registerItem(dustTin, "dustTin");
        GameRegistry.registerItem(dustGold, "dustGold");
        GameRegistry.registerItem(dustIron, "dustIron");
        GameRegistry.registerItem(dustCoal, "dustCoal");
        GameRegistry.registerItem(dustDiamond, "dustDiamond");

        GameRegistry.registerItem(pickaxeCopper, "pickaxeCopper");
        GameRegistry.registerItem(pickaxeTin, "pickaxeTin");
        GameRegistry.registerItem(axeCopper, "axeCopper");
        GameRegistry.registerItem(axeTin, "axeTin");
        GameRegistry.registerItem(shovelCopper, "shovelCopper");
        GameRegistry.registerItem(shovelTin, "shovelTin");
        GameRegistry.registerItem(swordCopper, "swordCopper");
        GameRegistry.registerItem(swordTin, "swordTin");
        GameRegistry.registerItem(hoeCopper, "hoeCopper");
        GameRegistry.registerItem(hoeTin, "hoeTin");

        GameRegistry.registerItem(wrench, "wrench");
    }
}

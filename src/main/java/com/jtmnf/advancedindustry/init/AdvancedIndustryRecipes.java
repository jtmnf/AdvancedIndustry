package com.jtmnf.advancedindustry.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AdvancedIndustryRecipes {
    public static void initCrafting() {
        smelting();
        shaped();
        shapeless();
    }

    private static void smelting() {
        GameRegistry.addSmelting(new ItemStack(AdvancedIndustryBlock.oreCopper), new ItemStack(AdvancedIndustryItems.ingotCopper), 2F);
        GameRegistry.addSmelting(new ItemStack(AdvancedIndustryBlock.oreTin), new ItemStack(AdvancedIndustryItems.ingotTin), 2F);
    }

    private static void shaped() {
        GameRegistry.addShapedRecipe(new ItemStack(AdvancedIndustryBlock.blockCopper), new Object[]{"###", "###", "###", '#', AdvancedIndustryItems.ingotCopper});
        GameRegistry.addShapedRecipe(new ItemStack(AdvancedIndustryBlock.blockTin), new Object[]{"###", "###", "###", '#', AdvancedIndustryItems.ingotTin});

        GameRegistry.addShapedRecipe(new ItemStack(AdvancedIndustryItems.axeCopper), new Object[]{"## ", "#S ", " S ", '#', AdvancedIndustryItems.ingotCopper, 'S', Items.stick});
        GameRegistry.addShapedRecipe(new ItemStack(AdvancedIndustryItems.axeTin), new Object[]{"## ", "#S ", " S ", '#', AdvancedIndustryItems.ingotTin, 'S', Items.stick});
        GameRegistry.addShapedRecipe(new ItemStack(AdvancedIndustryItems.shovelCopper), new Object[]{" # ", " S ", " S ", '#', AdvancedIndustryItems.ingotCopper, 'S', Items.stick});
        GameRegistry.addShapedRecipe(new ItemStack(AdvancedIndustryItems.shovelTin), new Object[]{" # ", " S ", " S ", '#', AdvancedIndustryItems.ingotTin, 'S', Items.stick});
        GameRegistry.addShapedRecipe(new ItemStack(AdvancedIndustryItems.hoeCopper), new Object[]{"## ", " S ", " S ", '#', AdvancedIndustryItems.ingotCopper, 'S', Items.stick});
        GameRegistry.addShapedRecipe(new ItemStack(AdvancedIndustryItems.hoeTin), new Object[]{"## ", " S ", " S ", '#', AdvancedIndustryItems.ingotTin, 'S', Items.stick});
        GameRegistry.addShapedRecipe(new ItemStack(AdvancedIndustryItems.swordCopper), new Object[]{" # ", " # ", " S ", '#', AdvancedIndustryItems.ingotCopper, 'S', Items.stick});
        GameRegistry.addShapedRecipe(new ItemStack(AdvancedIndustryItems.swordTin), new Object[]{" # ", " # ", " S ", '#', AdvancedIndustryItems.ingotTin, 'S', Items.stick});
        GameRegistry.addShapedRecipe(new ItemStack(AdvancedIndustryItems.pickaxeCopper), new Object[]{"###", " S ", " S ", '#', AdvancedIndustryItems.ingotCopper, 'S', Items.stick});
        GameRegistry.addShapedRecipe(new ItemStack(AdvancedIndustryItems.pickaxeTin), new Object[]{"###", " S ", " S ", '#', AdvancedIndustryItems.ingotTin, 'S', Items.stick});

        GameRegistry.addShapedRecipe(new ItemStack(AdvancedIndustryItems.wrench), new Object[]{"  T", " C ", "S  ", 'T', AdvancedIndustryItems.ingotTin, 'C', AdvancedIndustryItems.ingotCopper, 'S', Items.stick});
    }

    private static void shapeless() {

    }
}

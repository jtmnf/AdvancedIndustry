package com.jtmnf.advancedindustry.renderer;

import com.jtmnf.advancedindustry.AdvancedIndustry;
import com.jtmnf.advancedindustry.init.AdvancedIndustryItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemRenderRegister {
    public static void registerItemRenderer(){
        register(AdvancedIndustryItems.ingotCopper);
        register(AdvancedIndustryItems.ingotTin);

        register(AdvancedIndustryItems.dustCoal);
        register(AdvancedIndustryItems.dustCopper);
        register(AdvancedIndustryItems.dustDiamond);
        register(AdvancedIndustryItems.dustGold);
        register(AdvancedIndustryItems.dustIron);
        register(AdvancedIndustryItems.dustTin);

        register(AdvancedIndustryItems.pickaxeCopper);
        register(AdvancedIndustryItems.pickaxeTin);
        register(AdvancedIndustryItems.shovelCopper);
        register(AdvancedIndustryItems.shovelTin);
        register(AdvancedIndustryItems.swordCopper);
        register(AdvancedIndustryItems.swordTin);
        register(AdvancedIndustryItems.axeCopper);
        register(AdvancedIndustryItems.axeTin);
        register(AdvancedIndustryItems.hoeCopper);
        register(AdvancedIndustryItems.hoeTin);

        register(AdvancedIndustryItems.wrench);
    }

    public static void register(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(AdvancedIndustry.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));

    }
}

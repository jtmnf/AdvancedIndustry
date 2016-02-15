package com.jtmnf.advancedindustry.creativetab;

import com.jtmnf.advancedindustry.init.AdvancedIndustryItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabMod extends CreativeTabs {
    public CreativeTabMod(String creativeTabName) {
        super(creativeTabName);
    }

    @Override
    public Item getTabIconItem() {
        return AdvancedIndustryItems.wrench;
    }
}

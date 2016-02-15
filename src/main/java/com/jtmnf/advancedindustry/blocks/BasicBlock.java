package com.jtmnf.advancedindustry.blocks;

import com.jtmnf.advancedindustry.AdvancedIndustry;
import com.jtmnf.advancedindustry.items.BasicWrench;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BasicBlock extends Block {
    public BasicBlock(String unlocalizedName) {
        super(Material.rock);
        blockProperties(unlocalizedName);
    }

    public BasicBlock(String unlocalizedName, Material material) {
        super(material);
        blockProperties(unlocalizedName);
    }

    private void blockProperties(String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(AdvancedIndustry.tab);
        this.setHardness(2.0F);
        this.setResistance(10.0F);
    }
}

package com.jtmnf.advancedindustry.wires;

import com.jtmnf.advancedindustry.AdvancedIndustry;
import com.jtmnf.advancedindustry.tileentities.WireCableTile;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class WireCable extends Block implements ITileEntityProvider {
    public WireCable(String unlocalizedName) {
        super(Material.rock);

        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(AdvancedIndustry.tab);
        this.setStepSound(soundTypeCloth);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {

            WireCableTile wireCableTile = (WireCableTile) worldIn.getTileEntity(pos);
            playerIn.addChatComponentMessage(new ChatComponentText("Energy Stored: " + wireCableTile.getEnergyStored() + " E"));

            for (BlockPos blockPos : wireCableTile.getArrayPos()) {
                playerIn.addChatComponentMessage(new ChatComponentText("Connected to: " + blockPos));
            }
        }

        return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new WireCableTile();
    }
}

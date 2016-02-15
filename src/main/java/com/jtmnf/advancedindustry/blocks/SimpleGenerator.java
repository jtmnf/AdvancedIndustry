package com.jtmnf.advancedindustry.blocks;

import com.jtmnf.advancedindustry.AdvancedIndustry;
import com.jtmnf.advancedindustry.items.BasicWrench;
import com.jtmnf.advancedindustry.tileentities.SimpleGeneratorTile;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class SimpleGenerator extends Block implements ITileEntityProvider {
    public SimpleGenerator(String unlocalizedName) {
        super(Material.iron);

        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(AdvancedIndustry.tab);

        this.setHardness(2.0F);
        this.setResistance(10.0F);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            Item itemInHand = playerIn.getCurrentEquippedItem() != null ? playerIn.getCurrentEquippedItem().getItem() : null;

            if (itemInHand instanceof BasicWrench) {
                worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(worldIn.getTileEntity(pos).getBlockType())));
                worldIn.setBlockToAir(pos);

            } else {
                SimpleGeneratorTile simpleGeneratorTile = (SimpleGeneratorTile) worldIn.getTileEntity(pos);
                playerIn.addChatComponentMessage(new ChatComponentText("Energy Stored: " + simpleGeneratorTile.getEnergyStored() + " E"));
                //TODO
                //Open GUI
            }
        }

        return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new SimpleGeneratorTile();
    }
}

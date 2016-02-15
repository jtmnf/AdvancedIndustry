package com.jtmnf.advancedindustry.tileentities;

import com.jtmnf.advancedindustry.energy.IEnergyStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ITickable;

public class SimpleGeneratorTile extends TileEntity implements ITickable, IEnergyStorage, IInventory {

    private int energyStored = 0;
    private BlockPos blockPos;

    @Override
    public void update() {
        if (!worldObj.isRemote) {
            if (energyStored < MAX_ENERGY_IN_SIMPLE_GEN) {
                energyStored += 25;
            }

            if (blockPos != null) {
                WireCableTile wireCableTile = (WireCableTile) worldObj.getTileEntity(blockPos);

                if(wireCableTile == null){
                    blockPos = null;
                }
                else{
                    int toAdd = MAX_ENERGY_IN_CABLE - wireCableTile.getEnergyStored();

                    if(toAdd > 0) {
                        if (toAdd < energyStored) {
                            wireCableTile.setEnergyStored(toAdd, false);
                            this.setEnergyStored(energyStored - toAdd, true);
                        } else {
                            wireCableTile.setEnergyStored(energyStored, false);
                            this.setEnergyStored(0, true);
                        }
                    }
                }
            }
            else {
                boolean flag = false;
                BlockPos tilePos = new BlockPos(this.getPos().getX() - 1, this.getPos().getY(), this.getPos().getZ());

                TileEntity temp = worldObj.getTileEntity(tilePos);
                if (temp instanceof WireCableTile) {
                    blockPos = tilePos;
                    flag = true;
                }

                tilePos = new BlockPos(this.getPos().getX() + 1, this.getPos().getY(), this.getPos().getZ());
                temp = worldObj.getTileEntity(tilePos);
                if (temp instanceof WireCableTile && !flag) {
                    blockPos = tilePos;
                    flag = true;
                }

                tilePos = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + 1);
                temp = worldObj.getTileEntity(tilePos);
                if (temp instanceof WireCableTile && !flag) {
                    blockPos = tilePos;
                    flag = true;
                }

                tilePos = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() - 1);
                temp = worldObj.getTileEntity(tilePos);
                if (temp instanceof WireCableTile && !flag) {
                    blockPos = tilePos;
                }
            }
        }
    }

    @Override
    public int getMaxEnergy() {
        return MAX_ENERGY_IN_SIMPLE_GEN;
    }


    @Override
    public void setEnergyStored(int energyStored, boolean newValue) {
        if(newValue){
            this.energyStored = energyStored;
        }
        else{
            this.energyStored += energyStored;
        }
    }

    @Override
    public int getEnergyStored() {
        return energyStored;
    }

    @Override
    public int getSizeInventory() {
        return 0;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return null;
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return null;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {

    }

    @Override
    public int getInventoryStackLimit() {
        return 0;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return false;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return false;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public IChatComponent getDisplayName() {
        return null;
    }

    //==============================================
    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        compound.setInteger(NBT_ENERGY_TAG, energyStored);

        compound.setInteger("X", blockPos.getX());
        compound.setInteger("Y", blockPos.getY());
        compound.setInteger("Z", blockPos.getZ());
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        energyStored = compound.getInteger(NBT_ENERGY_TAG);

        blockPos = new BlockPos(compound.getInteger("X"), compound.getInteger("Y"), compound.getInteger("Z"));
    }
}

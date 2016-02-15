package com.jtmnf.advancedindustry.tileentities;

import com.jtmnf.advancedindustry.energy.IEnergyStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ITickable;

import java.util.ArrayList;

public class WireCableTile extends TileEntity implements ITickable, IEnergyStorage {

    private int energyStored = 0;
    private int time = 1;
    private ArrayList<BlockPos> arrayPos = new ArrayList<BlockPos>();

    @Override
    public int getMaxEnergy() {
        return MAX_ENERGY_IN_CABLE;
    }

    @Override
    public int getEnergyStored() {
        return energyStored;
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
    public void update() {
        if (!worldObj.isRemote) {
            try {
                updateArray();

                if (arrayPos.size() > 0) {
                    int energyToGive = energyStored / arrayPos.size();

                    for (BlockPos blockPos : arrayPos) {
                        WireCableTile wireCableTile = (WireCableTile) worldObj.getTileEntity(blockPos);

                        if (wireCableTile != null && wireCableTile.getEnergyStored() < MAX_ENERGY_IN_CABLE) {
                            int toAdd = MAX_ENERGY_IN_CABLE - wireCableTile.getEnergyStored();

                            if (toAdd > 0) {
                                if (toAdd < energyToGive) {
                                    wireCableTile.setEnergyStored(toAdd, false);
                                    this.setEnergyStored(-toAdd, false);
                                } else if (toAdd > energyToGive) {
                                    wireCableTile.setEnergyStored(energyToGive, false);

                                    if (energyStored - energyToGive <= 0) {
                                        this.setEnergyStored(-energyStored, false);
                                    } else {
                                        this.setEnergyStored(-energyToGive, false);
                                    }
                                }
                            }
                        } else if (wireCableTile == null) {
                            arrayPos.remove(blockPos);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Why?");
                arrayPos = new ArrayList<BlockPos>();
            }
        }
    }

    public ArrayList<BlockPos> getArrayPos() {
        return arrayPos;
    }

    //==============================================
    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        compound.setInteger(NBT_ENERGY_TAG, energyStored);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        energyStored = compound.getInteger(NBT_ENERGY_TAG);
    }

    //==============================================
    private void updateArray() {
        BlockPos tilePos = new BlockPos(this.getPos().getX() - 1, this.getPos().getY(), this.getPos().getZ());

        TileEntity temp = worldObj.getTileEntity(tilePos);
        if (temp instanceof WireCableTile) {
            if (!arrayPos.contains(tilePos)) {
                System.out.println("NEW 1");
                arrayPos.add(tilePos);
            }
        }

        tilePos = new BlockPos(this.getPos().getX() + 1, this.getPos().getY(), this.getPos().getZ());
        temp = worldObj.getTileEntity(tilePos);
        if (temp instanceof WireCableTile) {
            if (!arrayPos.contains(tilePos)) {
                System.out.println("NEW 2");
                arrayPos.add(tilePos);
            }
        }

        tilePos = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() - 1);
        temp = worldObj.getTileEntity(tilePos);
        if (temp instanceof WireCableTile) {
            if (!arrayPos.contains(tilePos)) {
                System.out.println("NEW 3");
                arrayPos.add(tilePos);
            }
        }

        tilePos = new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + 1);
        temp = worldObj.getTileEntity(tilePos);
        if (temp instanceof WireCableTile) {
            if (!arrayPos.contains(tilePos)) {
                System.out.println("NEW 4");
                arrayPos.add(tilePos);
            }
        }

        tilePos = new BlockPos(this.getPos().getX(), this.getPos().getY() - 1, this.getPos().getZ());
        temp = worldObj.getTileEntity(tilePos);
        if (temp instanceof WireCableTile) {
            if (!arrayPos.contains(tilePos)) {
                System.out.println("NEW 5");
                arrayPos.add(tilePos);
            }
        }

        tilePos = new BlockPos(this.getPos().getX(), this.getPos().getY() + 1, this.getPos().getZ());
        temp = worldObj.getTileEntity(tilePos);
        if (temp instanceof WireCableTile) {
            if (!arrayPos.contains(tilePos)) {
                System.out.println("NEW 6");
                arrayPos.add(tilePos);
            }
        }
    }

    private boolean detectGen() {
        return false;
    }
}

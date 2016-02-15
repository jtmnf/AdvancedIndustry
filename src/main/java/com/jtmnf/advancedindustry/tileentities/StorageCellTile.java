package com.jtmnf.advancedindustry.tileentities;

import com.jtmnf.advancedindustry.energy.IEnergyStorage;
import com.jtmnf.advancedindustry.wires.WireCable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ITickable;

import java.util.ArrayList;

public class StorageCellTile extends TileEntity implements ITickable, IEnergyStorage {

    private int energyStored = 0;

    @Override
    public int getMaxEnergy() {
        return MAX_ENERGY_IN_CELL;
    }

    @Override
    public int getEnergyStored() {
        return energyStored;
    }

    @Override
    public void setEnergyStored(int energy, boolean newValue) {
        if(newValue){
            this.energyStored = energy;
        }
        else{
            this.energyStored += energy;
        }


        if(energyStored > getMaxEnergy()){
            energyStored = getMaxEnergy();
        }
    }

    @Override
    public void update() {
        if(!worldObj.isRemote){
            try{
                ArrayList<BlockPos> wires = getWire();

                for (BlockPos wirePos : wires) {
                    IEnergyStorage storage = (IEnergyStorage) worldObj.getTileEntity(wirePos);

                    this.setEnergyStored(storage.getEnergyStored(), false);
                    storage.setEnergyStored(0, true);
                }
            }
            catch (Exception e){

            }
        }
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
    private ArrayList<BlockPos> getWire(){
        ArrayList<BlockPos> wires = new ArrayList<BlockPos>();

        BlockPos tempPos = new BlockPos(this.pos.getX() + 1, this.pos.getY(), this.pos.getZ());
        TileEntity tempTile = worldObj.getTileEntity(tempPos);
        if(tempTile != null){
            if(tempTile instanceof IEnergyStorage){
                if(!wires.contains(tempPos)){
                    wires.add(tempPos);
                }
            }
        }

        tempPos = new BlockPos(this.pos.getX() - 1, this.pos.getY(), this.pos.getZ());
        tempTile = worldObj.getTileEntity(tempPos);
        if(tempTile != null){
            if(tempTile instanceof IEnergyStorage){
                if(!wires.contains(tempPos)){
                    wires.add(tempPos);
                }
            }
        }

        tempPos = new BlockPos(this.pos.getX(), this.pos.getY() + 1, this.pos.getZ());
        tempTile = worldObj.getTileEntity(tempPos);
        if(tempTile != null){
            if(tempTile instanceof IEnergyStorage){
                if(!wires.contains(tempPos)){
                    wires.add(tempPos);
                }
            }
        }

        tempPos = new BlockPos(this.pos.getX(), this.pos.getY() - 1, this.pos.getZ());
        tempTile = worldObj.getTileEntity(tempPos);
        if(tempTile != null){
            if(tempTile instanceof IEnergyStorage){
                if(!wires.contains(tempPos)){
                    wires.add(tempPos);
                }
            }
        }

        tempPos = new BlockPos(this.pos.getX(), this.pos.getY(), this.pos.getZ() + 1);
        tempTile = worldObj.getTileEntity(tempPos);
        if(tempTile != null){
            if(tempTile instanceof IEnergyStorage){
                if(!wires.contains(tempPos)){
                    wires.add(tempPos);
                }
            }
        }

        tempPos = new BlockPos(this.pos.getX(), this.pos.getY(), this.pos.getZ() - 1);
        tempTile = worldObj.getTileEntity(tempPos);
        if(tempTile != null){
            if(tempTile instanceof IEnergyStorage){
                if(!wires.contains(tempPos)){
                    wires.add(tempPos);
                }
            }
        }

        return wires;
    }
}

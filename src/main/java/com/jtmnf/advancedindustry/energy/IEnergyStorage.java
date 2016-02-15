package com.jtmnf.advancedindustry.energy;

public interface IEnergyStorage {
    int MAX_ENERGY_IN_SIMPLE_GEN = 100000;
    int MAX_ENERGY_IN_ADVANCED_GEN = 1000000;
    int MAX_ENERGY_IN_CABLE = 1000;

    int MAX_ENERGY_IN_MACHINE = 20000;

    int MAX_ENERGY_IN_CELL = 2000000;

    int TRANSFER_RATE = 100;

    String NBT_ENERGY_TAG = "energy";

    int getMaxEnergy();
    int getEnergyStored();

    void setEnergyStored(int energy, boolean newValue);
}

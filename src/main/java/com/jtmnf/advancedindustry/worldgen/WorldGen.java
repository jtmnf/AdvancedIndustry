package com.jtmnf.advancedindustry.worldgen;

import com.jtmnf.advancedindustry.init.AdvancedIndustryBlock;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGen implements IWorldGenerator {

    private WorldGenerator oreCopper;
    private WorldGenerator oreTin;

    public WorldGen(){
        this.oreCopper = new WorldGenMinable(AdvancedIndustryBlock.oreCopper.getDefaultState(), 8);
        this.oreTin = new WorldGenMinable(AdvancedIndustryBlock.oreTin.getDefaultState(), 8);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimensionId()){
            case 0:
                this.runGenerator(this.oreCopper, world, random, chunkX, chunkZ, 20, 40, 65);
                this.runGenerator(this.oreTin, world, random, chunkX, chunkZ, 18, 15, 40);
                break;
        }
    }

    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i ++) {
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + rand.nextInt(16);
            generator.generate(world, rand, new BlockPos(x, y, z));
        }
    }
}

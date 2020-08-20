package com.yukiny.yuruyurumod.generators;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class MyWorldGenerator implements IWorldGenerator {
    private Block generateBlock;
    private int chance;

    public MyWorldGenerator(Block generateBlock, int chance){
        this.generateBlock = generateBlock;
        this.chance = chance;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if(world.provider.getDimension() == 0){
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    private void generateSurface(World world, Random random, int x, int z){
        addOreSpawn(world, random, x, z, 4 + random.nextInt(3), 1, 50);
    }

    private void addOreSpawn(World world, Random random, int x, int z, int max, int minY, int maxY){
        int width = maxY - minY;
        for(int i = 0; i < chance; i++){
            int centerX = x + random.nextInt(16);
            int centerY = minY + random.nextInt(width);
            int centerZ = z + random.nextInt(16);
            BlockPos pos = new BlockPos(centerX, centerY, centerZ);
            new WorldGenMinable(generateBlock.getDefaultState(), max).generate(world, random, pos);
        }
    }
}

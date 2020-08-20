package com.yukiny.yuruyurumod.generators;

import com.google.common.collect.Lists;
import com.yukiny.yuruyurumod.entities.EntityTobisuke;
import com.yukiny.yuruyurumod.entries.YuruBlocks;
import com.yukiny.yuruyurumod.entries.YuruEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.List;
import java.util.Random;

public class IcebergBiome extends Biome {
    private static BiomeProperties properties = new Biome.BiomeProperties("Iceberg")
            .setTemperature(0f)
            .setRainfall(1f)
            .setSnowEnabled()
            .setHeightVariation(0.75f);

    public IcebergBiome(){
        super(properties);
        this.topBlock = Blocks.ICE.getDefaultState();
        this.fillerBlock= Blocks.PACKED_ICE.getDefaultState();
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityTobisuke.class, 100, 4, 22));
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0xffffff;
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        boolean isTop = true;
        int x1 = x & 15;
        int z1 = z & 15;

        for(int y = 255; y >= 0; y--){
            if (y <= rand.nextInt(4)) {
                chunkPrimerIn.setBlockState(x1, y, z1, Blocks.BEDROCK.getDefaultState());
            }else if (y <= 5 + rand.nextInt(20)){
                chunkPrimerIn.setBlockState(x1, y, z1, YuruBlocks.myBlock2.getDefaultState());
            } else {
                IBlockState state = chunkPrimerIn.getBlockState(x1, y, z1);
                if(state.getBlock() != Blocks.AIR){
                    if(isTop){
                        chunkPrimerIn.setBlockState(x1, y, z1, this.topBlock);
                        isTop = false;
                    } else {
                        chunkPrimerIn.setBlockState(x1, y, z1, this.fillerBlock);
                    }
                }
            }
        }
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        new KamakuraGenerator().generate(worldIn, rand, pos);
        super.decorate(worldIn, rand, pos);
    }
}

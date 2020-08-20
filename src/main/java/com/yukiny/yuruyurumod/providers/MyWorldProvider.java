package com.yukiny.yuruyurumod.providers;

import com.yukiny.yuruyurumod.entries.YuruGenerators;
import com.yukiny.yuruyurumod.generators.MyChunkGenerator;
import net.minecraft.init.Biomes;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.common.BiomeManager;

public class MyWorldProvider extends WorldProvider {

    @Override
    public void createBiomeProvider(){
        this.biomeProvider = new BiomeProviderSingle(Biomes.MUTATED_JUNGLE);
        this.hasNoSky = false;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
//        return new ChunkProviderHell(this.worldObj, this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.worldObj.getSeed());
        return new MyChunkGenerator(this.worldObj);
    }

    @Override
    public DimensionType getDimensionType() {
        return YuruGenerators.myDimension;
    }
}

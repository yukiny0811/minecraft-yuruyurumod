package com.yukiny.yuruyurumod.generators;

import com.yukiny.yuruyurumod.entities.EntityTobisuke;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomePlains;

import java.util.List;

public class MyBiome extends BiomePlains {
    private static BiomeProperties properties = new Biome.BiomeProperties("MyBiome")
            .setTemperature(1f)
            .setRainfall(1f)
            .setBaseHeight(-0.25f)
            .setHeightVariation(0.4f);

    public MyBiome(){
        super(false, properties);
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityVillager.class, 30, 5, 5));
        theBiomeDecorator.treesPerChunk = 15;
        theBiomeDecorator.flowersPerChunk = 10;
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityTobisuke.class, 20, 5, 5));
    }
}

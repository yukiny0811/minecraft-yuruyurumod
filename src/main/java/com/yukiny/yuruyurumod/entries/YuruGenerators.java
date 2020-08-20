package com.yukiny.yuruyurumod.entries;

import com.yukiny.yuruyurumod.generators.IcebergBiome;
import com.yukiny.yuruyurumod.generators.MyBiome;
import com.yukiny.yuruyurumod.generators.MyWorldGenerator;
import com.yukiny.yuruyurumod.providers.MyWorldProvider;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class YuruGenerators {

    public static DimensionType myDimension = DimensionType.register("My Dimension", "_my_dimension", DimensionManager.getNextFreeDimId(), MyWorldProvider.class, false);
    public static BiomeManager.BiomeEntry entryOfMyBiome = new BiomeManager.BiomeEntry(new MyBiome(), 30);
    public static BiomeManager.BiomeEntry entryOfIcebergBiome = new BiomeManager.BiomeEntry(new IcebergBiome(), 30);

    public static void register(){
        registerBiomes();
        registerWorldGenerators();
        registerDimensions();
    }

    private static void registerBiomes(){
        BiomeManager.oceanBiomes.clear();
        BiomeProvider.allowedBiomes.clear();

        Biome.registerBiome(40, "my_biome", entryOfMyBiome.biome);
        BiomeManager.addSpawnBiome(entryOfMyBiome.biome);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, entryOfMyBiome);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, entryOfMyBiome);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, entryOfMyBiome);
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, entryOfMyBiome);

        Biome.registerBiome(41, "iceberg_biome", entryOfIcebergBiome.biome);
        BiomeManager.addSpawnBiome(entryOfMyBiome.biome);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, entryOfIcebergBiome);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, entryOfIcebergBiome);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, entryOfIcebergBiome);
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, entryOfIcebergBiome);
    }

    private static void registerWorldGenerators(){
        GameRegistry.registerWorldGenerator(new MyWorldGenerator(YuruBlocks.myBlock, 1000), 1);
    }

    private static void registerDimensions(){
        DimensionManager.registerDimension(myDimension.getId(), myDimension);
    }

}

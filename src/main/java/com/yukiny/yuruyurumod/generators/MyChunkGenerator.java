package com.yukiny.yuruyurumod.generators;

import com.yukiny.yuruyurumod.entries.YuruBlocks;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkGenerator;

import javax.annotation.Nullable;
import java.util.List;

public class MyChunkGenerator implements IChunkGenerator {
    private World world;

    public MyChunkGenerator(World world){
        this.world = world;
    }

    public void genSurface(Chunk chunk){
        for(int y = 0; y < 1; y++){
            for(int x = 0; x < 16; x++){
                for(int z = 0; z < 16; z++){
                    chunk.setBlockState(new BlockPos(x, y, z), Blocks.BEDROCK.getDefaultState());
                }
            }
        }
        for(int y = 1; y < 110; y++){
            for(int x = 0; x < 16; x++){
                for(int z = 0; z < 16; z++){
                    chunk.setBlockState(new BlockPos(x, y, z), YuruBlocks.myBlock2.getDefaultState());
                }
            }
        }
    }

    @Override
    public Chunk provideChunk(int x, int z) {
        ChunkPrimer primer = new ChunkPrimer();

        Chunk chunk = new Chunk(world, primer, x, z);
        genSurface(chunk);

        Biome[] biome = world.getBiomeProvider().getBiomes(null, x * 16, z * 16, 16, 16);
        byte[] bytes = chunk.getBiomeArray();

        for(int i = 0; i < biome.length; i++){
            bytes[i] = (byte)Biome.getIdForBiome(biome[i]);
        }

        chunk.resetRelightChecks();
        return chunk;
    }

    @Override
    public void populate(int x, int z) {

    }

    @Override
    public boolean generateStructures(Chunk chunkIn, int x, int z) {
        return false;
    }

    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        return world.getBiome(pos).getSpawnableList(creatureType);
    }

    @Nullable
    @Override
    public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position) {
        return null;
    }

    @Override
    public void recreateStructures(Chunk chunkIn, int x, int z) {

    }
}

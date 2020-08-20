package com.yukiny.yuruyurumod.generators;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class KamakuraGenerator extends WorldGenerator {
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        if (rand.nextInt(100) >= 10) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = -2; j <= 2; j++) {
                for (int k = -2; k <= 2; k++) {
                    int height = 63 + i;
                    if (i == 3 || j == -2 || j == 2 || k == -2 || (k == 2 && j != 0)) {
                        worldIn.setBlockState(position.add(j, height, k), Blocks.SNOW.getDefaultState());
                    }
                }
            }
        }
        return false;
    }
}

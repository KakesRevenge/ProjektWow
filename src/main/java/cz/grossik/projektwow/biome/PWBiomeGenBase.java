package cz.grossik.projektwow.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/** @Autor Grossik 
 */

public class PWBiomeGenBase extends BiomeGenBase {

    public static BiomeGenBase Dark;

    public PWBiomeGenBase(int biomeId) {
        super(biomeId);
    }

    static {
        Dark = (new BiomeDark(50).setColor(9286496).setTemperatureRainfall(0.8F, 0.4F).setHeight(height_LowPlains).setBiomeName("Darkness Forest"));
    }

    public WorldGenerator getRandomWorldGenForGrass(Random random)
    {
        if (random.nextInt(4) == 0)
            return new WorldGenTallGrass(Blocks.tallgrass, 2);
        else
            return new WorldGenTallGrass(Blocks.tallgrass, 1);
    }

    public static void registerWithBiomeDictionary()
    {
        BiomeDictionary.registerBiomeType(Dark, Type.PLAINS);
        BiomeDictionary.registerAllBiomes();
    }
}
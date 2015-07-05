package cz.grossik.projektwow.biome;

import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

/** @Autor Grossik 
 */

public class BiomeDark extends PWBiomeGenBase {

      public BiomeDark(int int1) 
      {
        super(int1);
        this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.flowersPerChunk = -4;
        this.theBiomeDecorator.grassPerChunk = -10;
        this.waterColorMultiplier = 0x000000;
      }
            
      public int getSkyColorByTemp(float f)
      {
         return 0x000000;
      }
    
      public boolean isSkyColored()
      {
         return true;
      }

}
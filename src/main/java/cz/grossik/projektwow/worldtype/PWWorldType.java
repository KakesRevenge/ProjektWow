package cz.grossik.projektwow.worldtype;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cz.grossik.projektwow.biome.PWBiomeGenBase;

public class PWWorldType extends WorldType {
	
	private boolean hasNotificationData;
	
	public static PWWorldType DimOverWorld;

	public PWWorldType(String name) {
		super(name);
	}

	public static void addCustomWorldTypes() {
		DimOverWorld = new PWWorldType("").setNotificationData();
	}
	
    @SideOnly(Side.CLIENT)
    public String getTranslateName() {
        return "Projekt WOW";
    }
    
    @SideOnly(Side.CLIENT)
    public String func_151359_c() {
        return "Special World Type for Projekt WOW";
    }
    
	@Override
	public WorldChunkManager getChunkManager(World world) {
		BiomeGenBase test = PWBiomeGenBase.Dark;
		return new WorldChunkManagerHell(test, 0.5F);
	}

	@Override
	public IChunkProvider getChunkGenerator(World world, String generatorOptions) {
		return new ChunkProviderGenerate(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled());
	}

	@Override
	public int getMinimumSpawnHeight(World world) {
		return 64;
	} 
	
    private PWWorldType setNotificationData() {
        this.hasNotificationData = true;
        return this;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public boolean showWorldInfoNotice() {
        return this.hasNotificationData;
    }
}
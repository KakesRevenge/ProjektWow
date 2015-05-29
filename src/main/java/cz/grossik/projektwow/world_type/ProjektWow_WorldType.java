package cz.grossik.projektwow.world_type;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ProjektWow_WorldType extends WorldType{
	
	private boolean hasNotificationData;
	
	public static WorldType tutDimOverWorld;

	public ProjektWow_WorldType(String name) {
		super(name);
	}

	public static void addCustomWorldTypes(){
		tutDimOverWorld = new ProjektWow_WorldType("Projekt WOW").setNotificationData();
	}
	
    @SideOnly(Side.CLIENT)
    public String getTranslateName()
    {
        return "Projekt WOW";
    }
    @SideOnly(Side.CLIENT)
    public String func_151359_c()
    {
        return this.getTranslateName() + "vsasavsavsa";
    }
	@Override
	public WorldChunkManager getChunkManager(World world) {
		return new WorldChunkManagerHell(BiomeGenBase.birchForest, 0.5F);
	}

	@Override
	public IChunkProvider getChunkGenerator(World world, String generatorOptions) {
		return new ChunkProviderGenerate(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled());
	}

	@Override
	public int getMinimumSpawnHeight(World world) {
		return 64;
	} 
	
    private WorldType setNotificationData()
    {
        this.hasNotificationData = true;
        return this;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public boolean showWorldInfoNotice()
    {
        return this.hasNotificationData;
    }
}
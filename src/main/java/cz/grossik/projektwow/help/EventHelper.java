package cz.grossik.projektwow.help;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

/**
@Author KakesRevenge
 */

public class EventHelper {
	
	public static enum Type {
		FML,FORGE,BOTH
	}
	
	public static void register(Type type, Object instance) {
		register(type, null, instance);
	}
	
	public static void register(Type type, Side side,Object instance) {
		if(side == null || side == FMLCommonHandler.instance().getEffectiveSide()) {
			if(type == Type.FML || type == Type.BOTH) {
				FMLCommonHandler.instance().bus().register(instance);
			}
			
			if(type == Type.FORGE || type == Type.BOTH) {
				MinecraftForge.EVENT_BUS.register(instance);
			}
		}
	}
}

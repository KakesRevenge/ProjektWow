package cz.grossik.projektwow.proxy;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderFireball;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cz.grossik.projektwow.entity.EntityFire;
import cz.grossik.projektwow.entity.EntityWoodenSpear;
import cz.grossik.projektwow.renders.RenderWoodenSpear;

public class ProxyClient extends ProxyCommon {
	
	@Override
	public void initRenderers() {}
	
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityFire.class, new RenderFireball(1));
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodenSpear.class, new RenderWoodenSpear());
	}
}
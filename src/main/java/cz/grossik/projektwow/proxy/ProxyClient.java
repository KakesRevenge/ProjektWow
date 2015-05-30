package cz.grossik.projektwow.proxy;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderFireball;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cz.grossik.projektwow.warrior.entity.EntityWoodenSpear;
import cz.grossik.projektwow.warrior.render.RenderWoodenSpear;
import cz.grossik.projektwow.wizard.entity.EntityFire;

public class ProxyClient extends ProxyCommon{
	
	@Override
	public void initRenderers() 
	{
	}
	
	@Override
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityFire.class, new RenderFireball(1));
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodenSpear.class, new RenderWoodenSpear());
	}
}
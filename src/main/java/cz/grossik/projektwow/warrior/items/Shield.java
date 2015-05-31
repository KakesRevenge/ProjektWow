package cz.grossik.projektwow.warrior.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import cz.grossik.projektwow.ProjektWow;

/**
@Author KakesRevenge
 */

public class Shield extends ItemSword {
	
	public Shield(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("Shield");
		this.setCreativeTab(ProjektWow.ProjektWowTab);
	}
}

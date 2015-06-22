package cz.grossik.projektwow.items.warrior;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cz.grossik.projektwow.ProjektWow;
import cz.grossik.projektwow.help.Reference;

/**
@Author KakesRevenge
 */

public class Shield extends ItemSword {
	
	private IIcon swordIcon,shieldIcon;
	
	public Shield(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("Shield");
		this.setCreativeTab(ProjektWow.ProjektWowTab);
		this.setTextureName(Reference.MODID + ":" + "testsword");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		swordIcon= iconRegister.registerIcon(Reference.MODID + ":" + "testsword");
		shieldIcon= iconRegister.registerIcon(Reference.MODID + ":" + "testshield");
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		if(player.isUsingItem() == true) {
			return shieldIcon;
		}
        return swordIcon;
    }
}

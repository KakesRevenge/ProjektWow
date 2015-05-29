package cz.grossik.projektwow.thief.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cz.grossik.projektwow.ProjektWow;
import cz.grossik.projektwow.items.Knife;

public class Item_Knife extends Knife  {
	
	public static int defaultCharges = 64;
		
	public Item_Knife() {
		super();
        this.setMaxDamage(defaultCharges + 1);
	}

	@Override
	public int getUseCost() {
		return 1;
	}

	@Override
	public int getBaseRepairCost() {
		return 3;
	}
	
	@Override  public ItemStack onItemRightClick(ItemStack srcItemStack, World world, EntityPlayer playerEntity){
	    if(ProjektWow.player_class.getString() == "Thief")
        {
		if (!playerEntity.capabilities.isCreativeMode)
        {
        	if(isOutOfCharge(srcItemStack)){
        		playSound(noChargeAttackSound,world,playerEntity);
        		return srcItemStack;
        	}
        	srcItemStack.damageItem(getUseCost(), playerEntity);
        }

        playSound("fireworks.launch",world,playerEntity);
        
        if (!world.isRemote)
        {
        	
        }
       }
      return srcItemStack;
	}

	@Override public boolean onItemUse(ItemStack srcItemStack, EntityPlayer playerEntity, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10){
		return super.onItemUse(srcItemStack, playerEntity, world, par4, par5, par6, par7, par8, par9, par10);
	}
	 

	@Override public void onPlayerStoppedUsing (ItemStack srcItemStack, World world, EntityPlayer playerEntity, int timeRemain){
		super.onPlayerStoppedUsing(srcItemStack, world, playerEntity, timeRemain);
	}
}
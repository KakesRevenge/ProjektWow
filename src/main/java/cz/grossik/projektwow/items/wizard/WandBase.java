package cz.grossik.projektwow.items.wizard;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class WandBase extends Item {
	
    public static String noChargeAttackSound = "random.bow";

	public WandBase() {
		super();
        this.maxStackSize = 1;
	}
	
	public abstract int getUseCost();

    @Override public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }
    
    private List<ItemStack> allowedItems = null;


    public boolean isOutOfCharge(ItemStack srcItemStack){
    	return srcItemStack.getItemDamage() >= (srcItemStack.getMaxDamage() - getUseCost());
    }
    
    protected void playSound(String soundID, World world, EntityPlayer playerEntity){
    	 if (!world.isRemote)
         {
    		 world.playSoundAtEntity(playerEntity, soundID, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
         }
    }
    
    public abstract int getBaseRepairCost();
    
}
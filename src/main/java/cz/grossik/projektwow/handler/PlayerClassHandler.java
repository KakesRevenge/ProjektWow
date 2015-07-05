package cz.grossik.projektwow.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import cz.grossik.projektwow.help.Reference;

/**
@Author KakesRevenge
 */

public class PlayerClassHandler implements IExtendedEntityProperties {

	public int CurrentClass;
	private final EntityPlayer player;
	public final static String Name = "PlayerClass";

	public PlayerClassHandler(EntityPlayer player) {
		this.player = player;
		this.CurrentClass = Reference.Unset;
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound playerclass = new NBTTagCompound();
		
		playerclass.setInteger("CurrentPlayerClass", this.CurrentClass);

		compound.setTag(Name, playerclass);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(Name);
		
		CurrentClass = properties.getInteger("CurrentPlayerClass");
	}

	@Override
	public void init(Entity entity, World world) { 
	}
	
	public static final PlayerClassHandler get(EntityPlayer player) {
		return (PlayerClassHandler) player.getExtendedProperties(Name);
	}
	
	public static String getPropertyName() {
		return Name;
	}
	
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(Name, new PlayerClassHandler(player));
	}
}
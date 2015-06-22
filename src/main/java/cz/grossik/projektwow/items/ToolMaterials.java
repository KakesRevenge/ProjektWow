package cz.grossik.projektwow.items;

import cz.grossik.projektwow.ProjektWow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public enum ToolMaterials {
	
    WARRIOR(0, 59, 2.0F, 0, 15),
    WIZARD(1, 131, 4.0F, 1, 5),
    THIEF(2, 250, 6.0F, 2, 14),
    NULL(3, 0, 0.0F, 0, 0);

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiencyOnProperMaterial;
    private final int damageVsEntity;
    private final int enchantability;

    private static final String __OBFID = "CL_00000042";

    @Deprecated public Item customCraftingMaterial = null;
    private ItemStack repairMaterial = null;
    private ToolMaterials(int p_i1874_3_, int p_i1874_4_, float p_i1874_5_, int p_i1874_6_, int p_i1874_7_)
    {
        this.harvestLevel = p_i1874_3_;
        this.maxUses = p_i1874_4_;
        this.efficiencyOnProperMaterial = p_i1874_5_;
        this.damageVsEntity = p_i1874_6_;
        this.enchantability = p_i1874_7_;
    }
    
    public int getMaxUses() {
        return this.maxUses;
    }

    public float getEfficiencyOnProperMaterial() {
        return this.efficiencyOnProperMaterial;
    }

    public float getDamageVsEntity() {
        return this.damageVsEntity;
    }

    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }
    
    @Deprecated
    public Item func_150995_f() {
        switch (this) {
            case WARRIOR:
            case WIZARD:
            case THIEF:    
            default:      
            	return customCraftingMaterial;
        }
    }
    
    public ItemStack getRepairItemStack() {
        if (repairMaterial != null) return repairMaterial;
        Item ret = this.func_150995_f();
        if (ret == null) return null;
        repairMaterial = new ItemStack(ret, 1, net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE);
        return repairMaterial;
    }
}
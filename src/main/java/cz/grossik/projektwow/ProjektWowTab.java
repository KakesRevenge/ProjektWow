package cz.grossik.projektwow;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ProjektWowTab extends CreativeTabs {

    public ProjektWowTab(String tabLabel) {
        super(tabLabel);
    }
    @SideOnly(Side.CLIENT)
    public String getTranslatedTabLabel()
    {
        return "ProjektWow";
    }
    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return Items.book;
    }

}
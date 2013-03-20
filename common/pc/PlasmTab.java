package Plasma.common.pc;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
public class PlasmTab extends CreativeTabs {

	public PlasmTab() {
		super("PlasmatiCraft Mod");
		// TODO Auto-generated constructor stub
	}
	@Override
	public ItemStack getIconItemStack() {
	    return new ItemStack(Plasmaticraft.pIngot);
	}
}

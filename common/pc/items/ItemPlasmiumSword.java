package Plasma.common.pc.items;

import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemPlasmiumSword extends ItemSword {

	public ItemPlasmiumSword(EnumToolMaterial tmat) {
		super(1003, tmat);
	}
	 public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
	 {
	 	itemstack.damageItem(1, entityliving1);
	 	entityliving.setFire(4);
	 	return true;
	 }

}

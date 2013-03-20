package Plasma.common.pc.blocks;

import Plasma.common.pc.Plasmaticraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockEnetManager extends Block{

	public BlockEnetManager() {
		super(1001, 1, Material.iron);
	}
	public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int idk, float what, float these, float are) {
			if(!player.isSneaking() && player.getItemInUse() == new ItemStack(Plasmaticraft.pWrench)) {
				world.setBlock(x, y, z, blockID);
				player.inventory.addItemStackToInventory(new ItemStack(this,1));
			}
				return true;
  
	} 
}

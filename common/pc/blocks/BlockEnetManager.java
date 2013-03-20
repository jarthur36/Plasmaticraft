package Plasma.common.pc.blocks;

import Plasma.common.pc.Plasmaticraft;
import Plasma.common.pc.core.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockEnetManager extends Block{

	public BlockEnetManager() {
		super(1001, 1, Material.iron);
		setCreativeTab(CommonProxy.CTAB);
		setTextureFile(CommonProxy.BLOCK);
	}
	public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int idk, float what, float these, float are) {
			if(player.isSneaking() && player.getItemInUse() == new ItemStack(Plasmaticraft.getpWrench())) {
				world.setBlock(x, y, z, 0);
				player.inventory.addItemStackToInventory(new ItemStack(this,1));
			}
				return true;
  
	} 
	 public int getBlockTextureFromSide(int i) 
     
     {
             if(i == 1) 
             {
                     return 2;
             }
             if(i == 0)
             {
                     return 2;
             }else
             {
                     return blockIndexInTexture;
             }
     }
}

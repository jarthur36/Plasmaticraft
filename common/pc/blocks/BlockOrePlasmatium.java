package Plasma.common.pc.blocks;

import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOrePlasmatium extends BlockOre{

	public BlockOrePlasmatium(int par1) {
		super(par1, 0);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName("plasmatiumOre");
	}
	

}

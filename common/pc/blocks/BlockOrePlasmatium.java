package Plasma.common.pc.blocks;

import Plasma.common.pc.core.CommonProxy;
import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockOrePlasmatium extends BlockOre{

	public BlockOrePlasmatium(int par1) {
		super(par1, 0);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName("plasmatiumOre");
		setTextureFile(CommonProxy.BLOCK);

	}
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        this.setLightValue(1.0F);
    }

}

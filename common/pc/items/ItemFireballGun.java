package Plasma.common.pc.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import Plasma.common.pc.core.CommonProxy;

public class ItemFireballGun extends Item {

	public ItemFireballGun() {
		super(1002);
		setIconIndex(2);
		setCreativeTab(CommonProxy.CTAB);
		setTextureFile(CommonProxy.ITEM);
		setItemName("pGun");
		// TODO Auto-generated constructor stub
	}
	 public void addInformation(ItemStack par1ItemStack, List par2List)
     {
      par2List.add("A gun, thats able to shoot &a fireballs!");
     }
	 public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer thePlayer) {
		  if (!par2World.isRemote && thePlayer.inventory.hasItemStack(new ItemStack(Item.fireballCharge)))
	         {
			  thePlayer.inventory.consumeInventoryItem(Item.fireballCharge.itemID);
			  par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() + 1);
	                 Vec3 look = thePlayer.getLookVec();
	                 EntitySmallFireball fireball2 = new EntitySmallFireball(par2World, thePlayer, 1, 1, 1);
	                 fireball2.setPosition(
	                                 thePlayer.posX + look.xCoord * 5,
	                                 thePlayer.posY + look.yCoord * 5,
	                                 thePlayer.posZ + look.zCoord * 5);
	                 fireball2.accelerationX = look.xCoord * 0.1;
	                 fireball2.accelerationY = look.yCoord * 0.1;
	                 fireball2.accelerationZ = look.zCoord * 0.1;
	                 par2World.spawnEntityInWorld(fireball2);
	         }
		  else if(thePlayer.capabilities.isCreativeMode) {
			  Vec3 look = thePlayer.getLookVec();
              EntitySmallFireball fireball2 = new EntitySmallFireball(par2World, thePlayer, 1, 1, 1);
              fireball2.setPosition(
                              thePlayer.posX + look.xCoord * 5,
                              thePlayer.posY + look.yCoord * 5,
                              thePlayer.posZ + look.zCoord * 5);
              fireball2.accelerationX = look.xCoord * 0.1;
              fireball2.accelerationY = look.yCoord * 0.1;
              fireball2.accelerationZ = look.zCoord * 0.1;
              par2World.spawnEntityInWorld(fireball2);
		  }
		  
		 return par1ItemStack; 
		
		 
	 }
	 public EnumRarity getRarity() {
		return EnumRarity.epic;
	 
	 }

}

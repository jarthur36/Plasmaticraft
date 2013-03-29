package Plasma.common.pc.power.Condenser;

import Plasma.common.pc.Plasmaticraft;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileCondenser extends TileEntity implements IInventory {
	/**
	 * @author Matheus
	 * @package Plasma.common.pc.power.Condenser
	 * @project Minecraft
	 */
	 /** The number of ticks that the furnace will keep burning */
    public int furnaceBurnTime = 0;
    public static int power = 0;
    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
    public int currentItemBurnTime = 0;
	private ItemStack[] inv;
	private ItemStack sampleStack = new ItemStack(Plasmaticraft.pShard);
	public TileCondenser() {
		inv = new ItemStack[100];
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		// TODO Auto-generated method stub
		return inv[slot];
	}
	
	@Override
	public ItemStack decrStackSize(int slot, int amt) {
		  ItemStack stack = getStackInSlot(slot);
          if (stack != null) {
                  if (stack.stackSize <= amt) {
                          setInventorySlotContents(slot, null);
                  } else {
                          stack = stack.splitStack(amt);
                          if (stack.stackSize == 0) {
                                  setInventorySlotContents(slot, null);
                          }
                  }
          }
          return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		 ItemStack stack = getStackInSlot(slot);
         if (stack != null) {
                 setInventorySlotContents(slot, null);
         }
         return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		  inv[slot] = stack;
          if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                  stack.stackSize = getInventoryStackLimit();
          }               
	}

	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return "condenser.tile";
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 16;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		 return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this &&
	                player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}
	@Override
    public void readFromNBT(NBTTagCompound tagCompound) {
            super.readFromNBT(tagCompound);
            
            NBTTagList tagList = tagCompound.getTagList("Inventory");
            for (int i = 0; i < tagList.tagCount(); i++) {
                    NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
                    byte slot = tag.getByte("Slot");
                    if (slot >= 0 && slot < inv.length) {
                            inv[slot] = ItemStack.loadItemStackFromNBT(tag);
                    }
                    
            }
            this.furnaceBurnTime = tagCompound.getShort("BurnTime");
            this.power = tagCompound.getInteger("Power");
           
            
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
            super.writeToNBT(tagCompound);
            tagCompound.setShort("BurnTime", (short)this.furnaceBurnTime);               
            NBTTagList itemList = new NBTTagList();
            for (int i = 0; i < inv.length; i++) {
                    ItemStack stack = inv[i];
                    if (stack != null) {
                            NBTTagCompound tag = new NBTTagCompound();
                            tag.setByte("Slot", (byte) i);
                            stack.writeToNBT(tag);
                            itemList.appendTag(tag);
                    }
            }
            tagCompound.setTag("Inventory", itemList);
            tagCompound.setInteger("Power", power);
    }
    public void updateEntity() {
    	// If theres stack in slot

    	if(getStackInSlot(0) != null) {
    	//if(getItemBurnTimeScaled(12,getStackInSlot(0)) > 0) {
    		
    		if(getItemBurnTimeScaled(12,getStackInSlot(0)) == 0) {
    			decrStackSize(0,1);
    		}
    		this.currentItemBurnTime = getItemBurnTimeScaled(0,getStackInSlot(0));
    		}
    	/*
    		if(getStackInSlot(0).itemID != sampleStack.itemID) {
    		//	inv[0] = null;
    		} */ 
    		if(getStackInSlot(1) != null) {
    			
    				power = power + 10000;
    				decrStackSize(0,1);
        			decrStackSize(1,1);
    			
    		
    	}else {
			//Else, get sad and return the method.
			return;
    	}
    		if(power >= 10000) {
    			inv[3] = inv[2];
				 power = power - 10000;
		}
    		}
    	
		//}
    
    public int getItemBurnTimeScaled(int scale, ItemStack stack) {
    	if(stack.itemID == sampleStack.itemID) {
    		return 1000 * scale;
    	} else {
    		return 0;
    	}
    }

          
}

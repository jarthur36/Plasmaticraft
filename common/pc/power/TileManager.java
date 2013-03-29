package Plasma.common.pc.power;

import Plasma.common.pc.Plasmaticraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileManager extends TileEntity {
	public int yCoord;
	public int xCoord;
	public int zCoord;
	public World worldObj;
	public int theBuffer = 0;
	private int powerToGenerate;
	/**
	 * @author Matheus
	 * @package Plasma.common.pc.power
	 * @project Minecraft
	 */
	public TileManager() {
		//TODO : Mats code generated constructor stub for class TileManager
	}
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
	    super.readFromNBT(nbt);
	    this.powerToGenerate = nbt.getInteger("power");
	    this.theBuffer = nbt.getInteger("buffer");
	}
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
	    super.writeToNBT(nbt);
	    	nbt.setInteger("buffer", theBuffer + powerToGenerate);
	}
	public void addPowerToBuffer(int thePowerToAdd) {
		theBuffer = theBuffer + thePowerToAdd;
		Plasmaticraft.modLog("One TileManager got it's buffer modified");
	}
	public void removeFromBuffer(int powerToGenerate2) {
		theBuffer = theBuffer - powerToGenerate2;
		
	}

}

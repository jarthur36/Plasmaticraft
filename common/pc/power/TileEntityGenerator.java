package Plasma.common.pc.power;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityGenerator extends TileEntity {
	int buffer = 0;
	int powerToGenerate;
	public int yCoord;
	public int xCoord;
	public int zCoord;
	public World worldObj;
	public TileEntityGenerator(int power, int x, int y, int z, World world) {
		
		int powerToGenerate = power;
		int yCoord = x;
		int xCoord = y;
		int zCoord = z;
	}
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
	    super.readFromNBT(nbt);
	    this.powerToGenerate = nbt.getInteger("power");
	    this.buffer = nbt.getInteger("buffer");
	}
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
	    super.writeToNBT(nbt);
	    	nbt.setInteger("buffer", buffer + powerToGenerate);
	}
	public void processActivate(EntityPlayer par5EntityPlayer, World world) {
        EnergyNetworkAPI.emitPowerTo(powerToGenerate, this);
	}
	public void removeFromBuffer(int thePowerToRemove) {
		buffer = buffer - thePowerToRemove;
	}
	
}

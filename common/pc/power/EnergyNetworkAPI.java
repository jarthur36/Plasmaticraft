package Plasma.common.pc.power;

import Plasma.common.pc.blocks.BlockEnetManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EnergyNetworkAPI {
	/**
	 * @author Matheus
	 * @package Plasma.common.pc.power
	 * @project Minecraft
	 */
	public EnergyNetworkAPI() {
		//TODO : Mats code generated constructor stub for class EnergyNetworkAPI
	}

	public static void emitPowerTo(int powerToGenerate, TileEntityGenerator theGen) {
		
		
		 int theManager = getManagers(theGen);
		if(theManager  != 0 ) {
			TileManager theManager1 = (TileManager) theGen.worldObj.getBlockTileEntity(theGen.xCoord,theManager, theGen.yCoord);
			theManager1.addPowerToBuffer(powerToGenerate);
			 theGen.removeFromBuffer(powerToGenerate);
		 } else
		 {
			 throw new NullPointerException("A theManager entity was null");
		 }
		
		}
	public static int getManagers(TileEntityGenerator tile) {
		int block = 0;
		for( int i = 0; i <= 6; i++) 
		{
			if(block == 0) {
				int id =  tile.worldObj.getBlockId(tile.xCoord,tile.yCoord - 1, tile.zCoord);
				if(id == 1001 && id != 0) {
					block++;
					return tile.yCoord;
				}
				
			} else if(block == 1 ) {
				int id =  tile.worldObj.getBlockId(tile.xCoord,tile.yCoord + 1, tile.zCoord);
				if(id == 1001 && id != 0) {
					block++;
					return tile.yCoord;
				}
			}  else   { 
				return (Integer) null; 
				}
			
		}
		
		return (Integer) null;
	}
	
	} 


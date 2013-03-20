package Plasma.common.pc.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import Plasma.common.pc.PlasmTab;
import cpw.mods.fml.common.network.IGuiHandler;

@SuppressWarnings("unused")
public class CommonProxy implements IGuiHandler{ //THIS IS IMPORTANT, CANNOT BE A PROXY/GUI HANDLER WITHOUT THIS!!
	public static String PREFIXFILE =  System.getenv("APPDATA") + ".minecraft/PlasmatiCraft Mod Files/prefix";
	public static String ITEM = "/Plasma/textures/items.png";
	public static String BLOCK = "/Plasma/textures/blocks.png";
	public static CreativeTabs CTAB = new PlasmTab();
	public void registerRenderInformation() //Client side texture registering
	{
	}
@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { //For GUI's
		return null;
	}
@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { //For GUI's
		return null;
	}
	public void registerTiles(){ //For registering TileEntities
	}
	}

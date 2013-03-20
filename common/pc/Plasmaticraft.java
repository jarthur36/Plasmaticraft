package Plasma.common.pc;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import Plasma.common.pc.blocks.BlockEnetManager;
import Plasma.common.pc.blocks.BlockOrePlasmatium;
import Plasma.common.pc.client.core.handlers.ClientPacketHandler;
import Plasma.common.pc.core.CommonProxy;
import Plasma.common.pc.core.handlers.ServerPacketHandler;
import Plasma.common.pc.items.ItemFireballGun;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@NetworkMod(clientSideRequired=true,serverSideRequired=false, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"TutorialGeneral" }, packetHandler = ClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {}, packetHandler = ServerPacketHandler.class)) //For serverside packet handling
@Mod(modid="Plasmaticraft",name="Plasmaticraft",version="1.0") //Gives Forge extra info about your mod
public class Plasmaticraft { //The class file
static Item pIngot = new Item(1000).setIconIndex(0).setItemName("plasmiumIngot").setCreativeTab(CommonProxy.CTAB).setTextureFile(CommonProxy.ITEM);
static Item pShard = new Item(1001).setIconIndex(1).setItemName("plasmiumShard").setCreativeTab(CommonProxy.CTAB).setTextureFile(CommonProxy.ITEM);
public static Item pWrench = new Item(1002).setIconIndex(2).setItemName("plasmiumWrench").setCreativeTab(CommonProxy.CTAB).setTextureFile(CommonProxy.ITEM);
static Item pGun = new ItemFireballGun();
static Block pOre = new BlockOrePlasmatium(1000).setCreativeTab(CommonProxy.CTAB);
static Block pEnetMan = new BlockEnetManager().setCreativeTab(CommonProxy.CTAB);
@SidedProxy(clientSide = "Plasma.common.pc.client.core.ClientProxy", serverSide = "Plasma.common.pc.core.CommonProxy") //Tells Forge the location of your proxies
public static CommonProxy proxy;

@Init
public void load(FMLInitializationEvent event) { //Your main initialization method
	modLog("This is PlasmatiCraft 1.0");
	NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data
	LanguageRegistry.addName(pIngot, "Plasmium ingot");
	LanguageRegistry.addName(pShard, "Plasmium Shard");
	LanguageRegistry.addName(pWrench, "Plasmium Shard");
	LanguageRegistry.addName(pGun, "Plasmium Gun");
	LanguageRegistry.instance().addStringLocalization("itemGroup.PlasmatiCraft Mod", "en_US", "PlasmatiCraft Mod");
	GameRegistry.registerBlock(pOre);
	GameRegistry.registerBlock(pEnetMan);
	LanguageRegistry.addName(pOre,"Plasmium Ore");
	LanguageRegistry.addName(pWrench,"Plasmium Wrench");
	LanguageRegistry.addName(pEnetMan,"Plasmium EnergyNet Manager");
	GameRegistry.addSmelting(pOre.blockID, new ItemStack(pIngot,1), 1.0F); // Registers the smelting recipe

	}
public static void modLog( String str) {
	System.out.println("[PLASMCRAFT]" + str);

}
public int addFuel(int id, int metadata)
{
   switch(id) {
 case 1001 :
	 return 100000;
case 1000 :
	 return 1000000;
default : 
	   return 0;
   }
}
}

  


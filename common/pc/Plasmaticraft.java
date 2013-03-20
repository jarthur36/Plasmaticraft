package Plasma.common.pc;

import net.minecraft.item.Item;
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
import cpw.mods.fml.common.registry.LanguageRegistry;

@NetworkMod(clientSideRequired=true,serverSideRequired=false, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"TutorialGeneral" }, packetHandler = ClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {}, packetHandler = ServerPacketHandler.class)) //For serverside packet handling
@Mod(modid="Plasmaticraft",name="Plasmaticraft",version="1.0") //Gives Forge extra info about your mod
public class Plasmaticraft { //The class file
static Item pIngot = new Item(1000).setIconIndex(0).setItemName("plasmiumIngot").setCreativeTab(CommonProxy.CTAB).setTextureFile(CommonProxy.ITEM);
static Item pShard = new Item(1001).setIconIndex(1).setItemName("plasmiumShard").setCreativeTab(CommonProxy.CTAB).setTextureFile(CommonProxy.ITEM);
static Item pGun = new ItemFireballGun();
@SidedProxy(clientSide = "Plasma.common.pc.client.core.ClientProxy", serverSide = "Plasma.common.pc.core.CommonProxy") //Tells Forge the location of your proxies
public static CommonProxy proxy;

@Init
public void load(FMLInitializationEvent event) { //Your main initialization method
	modLog("This is PlasmatiCraft 1.0");
	NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data
	LanguageRegistry.addName(pIngot, "Plasmium ingot");
	LanguageRegistry.addName(pShard, "Plasmium Shard");
	LanguageRegistry.addName(pGun, "Plasmium Gun");
	LanguageRegistry.instance().addStringLocalization("itemGroup.PlasmatiCraft Mod", "en_US", "PlasmatiCraft Mod");
}
public static void modLog( String str) {
	System.out.println("[PLASMCRAFT]" + str);

}
}

  


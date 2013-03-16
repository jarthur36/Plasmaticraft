package common.pc;

import common.pc.client.core.handlers.ClientPacketHandler;
import common.pc.core.CommonProxy;
import common.pc.core.handlers.ServerPacketHandler;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;

@NetworkMod(clientSideRequired=true,serverSideRequired=false, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"TutorialGeneral" }, packetHandler = ClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {}, packetHandler = ServerPacketHandler.class)) //For serverside packet handling
@Mod(modid="Plasmaticraft",name="Plasmaticraft",version="1.0") //Gives Forge extra info about your mod
public class Plasmaticraft { //The class file


@SidedProxy(clientSide = "common.pc.client.core.ClientProxy", serverSide = "common.pc.core.CommonProxy") //Tells Forge the location of your proxies
public static CommonProxy proxy;

@Init
public void load(FMLInitializationEvent event){ //Your main initialization method

NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data
}
}

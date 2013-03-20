package Plasma.common.pc.client.core;
import net.minecraftforge.client.MinecraftForgeClient;
import Plasma.common.pc.core.CommonProxy;
@SuppressWarnings("unused")
public class ClientProxy extends CommonProxy {
        
	public void registerRenderInformation(){
		MinecraftForgeClient.preloadTexture(BLOCK);
		MinecraftForgeClient.preloadTexture(ITEM);
	}

}
package Plasma.common.pc.power.Condenser;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GooeyCondenser extends GuiContainer {
	static TileCondenser theCondenser;
        public GooeyCondenser (InventoryPlayer inventoryPlayer,
                        TileCondenser tileEntity) {
                //the container is instanciated and passed to the superclass for handling
                super(new ContainerCondenser(inventoryPlayer, tileEntity));
                theCondenser = tileEntity;
        }

        @Override
        protected void drawGuiContainerForegroundLayer(int param1, int param2) {
                //draw text and stuff here
                //the parameters for drawString are: string, x, y, color
                fontRenderer.drawString("Plasmium Condenser", 8, 6, 4210752);
                //draws "Inventory" or your regional equivalent
                fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
                fontRenderer.drawString("Power:" + Integer.toString(theCondenser.power), 78,7, 4210752);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float par1, int par2,
                        int par3) {
                //draw your Gui here, only thing you need to change is the path
                int texture = mc.renderEngine.getTexture("/plasma/textures/guicondenser.png");
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                this.mc.renderEngine.bindTexture(texture);
                int x = (width - xSize) / 2;
                int y = (height - ySize) / 2;
                this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
                int var7;
               
                   
                
               

                
        }

}
package interia.module.modules;

import org.lwjgl.input.Keyboard;

import interia.Interia;
import interia.event.player.EventPlayerUpdate;
import interia.event.render.EventRenderWorld;
import interia.lib.event.EventListener;
import interia.lib.event.HandleEvent;
import interia.module.Category;
import interia.module.InteriaModule;
import interia.utils.RenderUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.network.play.client.C07PacketPlayerDigging;

public class Nuker extends InteriaModule implements EventListener
{
	int xPos = -1; 
	int yPos = -1; 
	int zPos = -1;
	double nukerRadius = 5.5;
	
	public Nuker() 
	{
		super("Nuker", Category.WORLD);
		Interia.theInteria.eventHandler.registerListener(this);
		this.setKeyBind(Keyboard.KEY_H);
	}

	@HandleEvent
	public void updatePlayer(EventPlayerUpdate theEvent)
	{
		if(!this.isToggled())
			return;
		for (int y = (int)this.nukerRadius; y >= (int)(-this.nukerRadius); y--)
		{
			for (int z = (int)(-this.nukerRadius); z <= this.nukerRadius; z++)
	        {
				for (int x = (int)(-this.nukerRadius); x <= this.nukerRadius; x++)
				{
					this.xPos = (int)Math.round(Interia.theInteria.getMinecraft().thePlayer.posX + x);
					this.yPos = (int)Math.round(Interia.theInteria.getMinecraft().thePlayer.posY + y);
					this.zPos = (int)Math.round(Interia.theInteria.getMinecraft().thePlayer.posZ + z);

					Block block = Interia.theInteria.getMinecraft().theWorld.getBlock(this.xPos, this.yPos, this.zPos);

					if(Interia.theInteria.getMinecraft().theWorld.getBlockMaterial(block) == Material.air)
						continue;
					Interia.theInteria.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(0, this.xPos, this.yPos, this.zPos, 1));
					Interia.theInteria.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(2, this.xPos, this.yPos, this.zPos, 1));
	            }
	        }
		}
	}
	
	@HandleEvent
	public void renderWorld(EventRenderWorld theEvent)
	{
		if(!this.isToggled())
			return;
		for (int y = (int)this.nukerRadius; y >= (int)(-this.nukerRadius); y--)
		{
	        for (int z = (int)(-this.nukerRadius); z <= this.nukerRadius; z++)
	        {
	        	for (int x = (int)(-this.nukerRadius); x <= this.nukerRadius; x++)
	        	{
	        		int xPos = (int)Math.round(Interia.theInteria.getMinecraft().thePlayer.posX + x);
	        		int yPos = (int)Math.round(Interia.theInteria.getMinecraft().thePlayer.posY + y);
	        		int zPos = (int)Math.round(Interia.theInteria.getMinecraft().thePlayer.posZ + z);
	        		
	        		Block block = Interia.theInteria.getMinecraft().theWorld.getBlock(xPos, yPos, zPos);
	        		if (Interia.theInteria.getMinecraft().theWorld.getBlockMaterial(block) == Material.air)
	        			continue;
	        		Interia.theInteria.getMinecraft().entityRenderer.disableLightmap(1D);
	        		RenderUtils.drawNukerESP(xPos - RenderManager.renderPosX, yPos - RenderManager.renderPosY, zPos - RenderManager.renderPosZ, 0.45D, 0.45D, 0.45D, 0.15D);
	        		Interia.theInteria.getMinecraft().entityRenderer.enableLightmap(1D);
	        	}
	        }
		}
	}	
}

package interia.module.modules;

import interia.Interia;
import interia.event.render.EventRenderWorld;
import interia.lib.event.EventListener;
import interia.lib.event.HandleEvent;
import interia.module.Category;
import interia.module.InteriaModule;
import interia.utils.RenderUtils;

import java.util.Iterator;

import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.AxisAlignedBB;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class PlayerESP extends InteriaModule implements EventListener
{
	public PlayerESP() 
	{
		super("PlayerESP", Category.DISPLAY);
		Interia.theInteria.eventHandler.registerListener(this);
		this.setKeyBind(Keyboard.KEY_LBRACKET);
	}

	@HandleEvent
	public void renderWorld(EventRenderWorld theEvent)
	{
		if(!this.isToggled())
			return;
		for (Iterator localIterator = Interia.theInteria.getMinecraft().theWorld.loadedEntityList.iterator(); localIterator.hasNext();) 
		{ 
			Object o = localIterator.next();
			if ((o instanceof EntityOtherPlayerMP)) 
			{
				EntityOtherPlayerMP player = (EntityOtherPlayerMP)o;
				double d = player.lastTickPosX + (player.posX - player.lastTickPosX) * 	Interia.theInteria.getMinecraft().timer.renderPartialTicks;
				double d1 = player.lastTickPosY + (player.posY - player.lastTickPosY) * Interia.theInteria.getMinecraft().timer.renderPartialTicks;
				double d2 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * Interia.theInteria.getMinecraft().timer.renderPartialTicks;
				Interia.theInteria.getMinecraft().entityRenderer.disableLightmap(1.0D);
          		this.drawPlayerESP(d - RenderManager.renderPosX, d1 - RenderManager.renderPosY, d2 - RenderManager.renderPosZ, player, player.height - 0.1D, player.width - 0.12D, 0.45F, 0.45F);
          		Interia.theInteria.getMinecraft().entityRenderer.enableLightmap(1.0D);
			}	
		}
	}
	
	private void drawPlayerESP(double d, double d1, double d2, EntityOtherPlayerMP player, double e, double f, float alpha, float alpha2) 
	{
		GL11.glPushMatrix();
	    GL11.glEnable(3042);
	    Interia.theInteria.getMinecraft().entityRenderer.disableLightmap(1.0D);
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
	    GL11.glDisable(3553);
	    GL11.glDisable(2896);
	    GL11.glDisable(2929);
	    GL11.glDepthMask(false);
	    GL11.glLineWidth(1.0F);
	    GL11.glBlendFunc(770, 771);
	    GL11.glEnable(2848);
	    RenderUtils.drawBoundingBox(new AxisAlignedBB(d - f, d1 + 0.1D, d2 - f, d + f, d1 + e + 0.25D, d2 + f));
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha2 - 0.1F);
	    RenderUtils.drawOutlinedBoundingBox(new AxisAlignedBB(d - f, d1 + 0.1D, d2 - f, d + f, d1 + e + 0.25D, d2 + f));
	    GL11.glDepthMask(true);
	    GL11.glEnable(2929);
	    GL11.glEnable(3553);
	    GL11.glEnable(2896);
	    GL11.glDisable(2848);
	    GL11.glDisable(3042);
	    GL11.glPopMatrix();
	}
}

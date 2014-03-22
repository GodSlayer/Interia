package interia.module.modules;

import interia.Interia;
import interia.event.render.EventRenderWorld;
import interia.lib.event.EventListener;
import interia.lib.event.HandleEvent;
import interia.module.Category;
import interia.module.InteriaModule;
import interia.utils.RenderUtils;

import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.AxisAlignedBB;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class MobESP extends InteriaModule implements EventListener
{
	public MobESP()
	{
		super("MobESP", Category.DISPLAY);
		Interia.theInteria.eventHandler.registerListener(this);
		this.setKeyBind(Keyboard.KEY_P);
	}
	
	@HandleEvent
	public void renderWorld(EventRenderWorld theEvent)
	{
		if(!this.isToggled())
			return;
		for (Iterator localIterator = Interia.theInteria.getMinecraft().theWorld.loadedEntityList.iterator(); localIterator.hasNext();) 
		{ 
			Object o = localIterator.next();
			if((o instanceof EntityMob) || (o instanceof EntityAnimal))
			{
				EntityLiving ep = (EntityLiving)o;
				double d = ep.lastTickPosX + (ep.posX - ep.lastTickPosX) * Interia.theInteria.getMinecraft().timer.renderPartialTicks;
				double d1 = ep.lastTickPosY + (ep.posY - ep.lastTickPosY) * Interia.theInteria.getMinecraft().timer.renderPartialTicks;
				double d2 = ep.lastTickPosZ + (ep.posZ - ep.lastTickPosZ) * Interia.theInteria.getMinecraft().timer.renderPartialTicks;
				Interia.theInteria.getMinecraft().entityRenderer.disableLightmap(1.0D);
				this.drawMobESP(d - RenderManager.renderPosX, d1 - RenderManager.renderPosY, d2 - RenderManager.renderPosZ, ep, ep.height - 0.1D, ep.width, 0.45F, 0.45F);				
				Interia.theInteria.getMinecraft().entityRenderer.enableLightmap(1.0D);
			}
		}
	}

	private void drawMobESP(double d, double d1, double d2, EntityLiving ep, double e, double f, float alpha, float alpha2) 
	{
	    GL11.glPushMatrix();
	    GL11.glEnable(3042);
	    Minecraft.getMinecraft().entityRenderer.disableLightmap(1.0D);
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
	    GL11.glDisable(3553);
	    GL11.glDisable(2896);
	    GL11.glDisable(2929);
	    GL11.glDepthMask(false);
	    GL11.glLineWidth(0.8F);
	    GL11.glBlendFunc(770, 771);
	    GL11.glEnable(2848);
	    RenderUtils.drawBoundingBox(new AxisAlignedBB(d - f, d1 + 0.1D, d2 - f, d + f, d1 + e + 0.25D, d2 + f));
	    GL11.glColor4f(0.4F, 0.4F, 0.4F, alpha2);
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

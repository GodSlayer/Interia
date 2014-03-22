package interia.module.modules;

import interia.Interia;
import interia.event.render.EventRenderWorld;
import interia.lib.event.EventListener;
import interia.lib.event.HandleEvent;
import interia.module.Category;
import interia.module.InteriaModule;

import java.util.Iterator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Tracers extends InteriaModule implements EventListener
{
	public Tracers() 
	{
		super("Tracers", Category.DISPLAY);
		Interia.theInteria.eventHandler.registerListener(this);
		this.setKeyBind(Keyboard.KEY_U);
	}

	@HandleEvent
	public void renderWorld(EventRenderWorld theEvent)
	{
		if(!this.isToggled())
			return;
		try
		{
			Interia.theInteria.getMinecraft().gameSettings.viewBobbing = false;
			GL11.glPushMatrix();
	        Interia.theInteria.getMinecraft().entityRenderer.disableLightmap(1.0D);
	        GL11.glEnable(3042);
	        GL11.glEnable(2848);
	        GL11.glDisable(2929);
	        GL11.glDisable(2896);
	        GL11.glDisable(3553);
	        GL11.glBlendFunc(770, 771);
	        GL11.glEnable(3042);
	        GL11.glLineWidth(1.0F);
	        for (Iterator localIterator = Interia.theInteria.getMinecraft().theWorld.loadedEntityList.iterator(); localIterator.hasNext();) 
	        { 
	        	Object o = localIterator.next();
	        	if ((o == Interia.theInteria.getMinecraft().thePlayer) || (o == null))
	        		continue;
	        	if (!(o instanceof EntityPlayer))
	        		continue;
	        	EntityPlayer entity = (EntityPlayer)o;
	        	double posX = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) - RenderManager.renderPosX;
	        	double posY = entity.lastTickPosY + 1.0D + (entity.posY - entity.lastTickPosY) - RenderManager.renderPosY;
	        	double posZ = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) - RenderManager.renderPosZ;

	        	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        	
	        	GL11.glBegin(2);
	            GL11.glVertex3d(0.0D, 0.0D, 0.0D);
	            GL11.glVertex3d(posX, posY, posZ);
	            GL11.glEnd();
	        }
	        GL11.glDisable(3042);
	        GL11.glEnable(3553);
	        GL11.glEnable(2929);
	        GL11.glDisable(2848);
	        GL11.glDisable(3042);
	        GL11.glEnable(2896);
	        Interia.theInteria.getMinecraft().entityRenderer.enableLightmap(1.0D);
	        GL11.glPopMatrix();
		}catch(Exception theException){}
	}
}

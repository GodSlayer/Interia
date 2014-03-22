package interia.module.modules;

import interia.Interia;
import interia.event.render.EventRenderWorld;
import interia.lib.event.EventListener;
import interia.lib.event.HandleEvent;
import interia.module.Category;
import interia.module.InteriaModule;
import interia.utils.RenderUtils;

import java.util.Iterator;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.tileentity.TileEntityChest;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class ChestESP extends InteriaModule implements EventListener
{
	public ChestESP() 
	{
		super("ChestESP", Category.DISPLAY);
		Interia.theInteria.eventHandler.registerListener(this);
		this.setKeyBind(Keyboard.KEY_V);
	}

	@HandleEvent
	public void renderWorld(EventRenderWorld theEvent)
	{
		if(!this.isToggled())
			return;
		for (Iterator localIterator = Interia.theInteria.getMinecraft().theWorld.field_147482_g.iterator(); localIterator.hasNext();) 
		{ 
			Object o = localIterator.next();
			if ((o instanceof TileEntityChest)) 
			{
				TileEntityChest chest = (TileEntityChest)o;
				Interia.theInteria.getMinecraft().gameSettings.viewBobbing = false;
				drawESP(chest, chest.field_145851_c, chest.field_145848_d, chest.field_145849_e, 1.0F);
			}
		}
	}
	
	public void drawESP(TileEntityChest chest, double x, double y, double z, float f)
	{
	    if((chest.field_145987_o != 0) || (chest.field_145983_q != 0) || (chest.field_145982_r != 0))
	    {
	      Interia.theInteria.getMinecraft().entityRenderer.disableLightmap(f);
	      RenderUtils.drawESP(x - RenderManager.renderPosX, y - RenderManager.renderPosY, z - RenderManager.renderPosZ, 0D, 0D, 1D, 0.45F);
	      GL11.glPushMatrix();
	      GL11.glEnable(3042);
	      GL11.glEnable(2848);
	      GL11.glDisable(2929);
	      GL11.glDisable(2896);
	      GL11.glDisable(3553);
	      GL11.glBlendFunc(770, 771);
	      GL11.glEnable(3042);
	      GL11.glLineWidth(1.0F);
	      GL11.glColor4f(1F, 1F, 1F, 0.45F);
	      GL11.glBegin(2);
	      GL11.glVertex3d(0.0D, 0.0D, 0.0D);
	      GL11.glVertex3d(x + 0.5D - RenderManager.renderPosX, y + 0.5D - RenderManager.renderPosY, z + 0.5D - RenderManager.renderPosZ);
	      GL11.glEnd();
	      GL11.glDisable(3042);
	      GL11.glEnable(3553);
	      GL11.glEnable(2929);
	      GL11.glDisable(2848);
	      GL11.glDisable(3042);
	      GL11.glEnable(2896);
	      GL11.glPopMatrix();
	      Interia.theInteria.getMinecraft().entityRenderer.enableLightmap(f);
	    }
	}
}

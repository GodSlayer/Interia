package interia.module.modules;

import interia.Interia;
import interia.event.player.EventPlayerUpdate;
import interia.lib.event.EventListener;
import interia.lib.event.HandleEvent;
import interia.module.Category;
import interia.module.InteriaModule;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

public class Criticals extends InteriaModule implements EventListener
{
	public Criticals() 
	{
		super("Criticals", Category.COMBAT);
		Interia.theInteria.eventHandler.registerListener(this);
	}
	public static Minecraft mc = Minecraft.getMinecraft();
	
	
	@HandleEvent
	public void updatePlayer(EventPlayerUpdate theEvent){
		if(isToggled())
	    if (shouldCritical()) {
	      mc.thePlayer.motionY = 0.1000000014901161D;
	      mc.thePlayer.fallDistance = 0.1F;
	      mc.thePlayer.onGround = false;
	    }
	  }

	  private boolean shouldCritical() {
	    return (!mc.thePlayer.isInWater()) && (mc.thePlayer.onGround);
	  }
	}

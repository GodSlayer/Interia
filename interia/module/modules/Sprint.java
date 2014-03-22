package interia.module.modules;

import org.lwjgl.input.Keyboard;

import interia.Interia;
import interia.event.player.EventPlayerUpdate;
import interia.lib.event.EventListener;
import interia.lib.event.HandleEvent;
import interia.module.Category;
import interia.module.InteriaModule;

public class Sprint extends InteriaModule implements EventListener
{
	public Sprint() 
	{
		super("Sprint", Category.PLAYER);
		Interia.theInteria.eventHandler.registerListener(this);
		this.setKeyBind(Keyboard.KEY_F);
	}

	@HandleEvent
	public void updatePlayer(EventPlayerUpdate theEvent)
	{
		if((this.isToggled()) && (!Interia.theInteria.getMinecraft().thePlayer.isCollidedHorizontally) && (Interia.theInteria.getMinecraft().thePlayer.moveForward != 0.0F))
		{
			Interia.theInteria.getMinecraft().thePlayer.setSprinting(true);
		}		
	}
}

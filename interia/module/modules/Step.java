package interia.module.modules;

import org.lwjgl.input.Keyboard;

import interia.Interia;
import interia.event.player.EventPlayerUpdate;
import interia.lib.event.EventListener;
import interia.lib.event.HandleEvent;
import interia.module.Category;
import interia.module.InteriaModule;

public class Step extends InteriaModule implements EventListener
{
	public Step() 
	{
		super("Step", Category.PLAYER);
		Interia.theInteria.eventHandler.registerListener(this);
		this.setKeyBind(Keyboard.KEY_Y);
	}

	@HandleEvent
	public void updatePlayer(EventPlayerUpdate theEvent)
	{
		if(this.isToggled())
		{
			Interia.theInteria.getMinecraft().thePlayer.stepHeight = 1.0F;
		}else
		{
			Interia.theInteria.getMinecraft().thePlayer.stepHeight = 0.5F;
		}
	}
}

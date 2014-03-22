package interia.module.modules;

import interia.Interia;
import interia.event.player.EventPlayerUpdate;
import interia.lib.event.EventListener;
import interia.lib.event.HandleEvent;
import interia.module.Category;
import interia.module.InteriaModule;

import org.lwjgl.input.Keyboard;

public class FullBright extends InteriaModule implements EventListener
{
	public FullBright() 
	{
		super("FullBright", Category.DISPLAY);
		Interia.theInteria.eventHandler.registerListener(this);
		this.setKeyBind(Keyboard.KEY_B);
	}

	@HandleEvent
	public void updateGamma(EventPlayerUpdate theEvent)
	{
		if(this.isToggled())
			Interia.theInteria.getMinecraft().gameSettings.gammaSetting = 10.0F;
		else
			Interia.theInteria.getMinecraft().gameSettings.gammaSetting = 1.0F;
	}
}

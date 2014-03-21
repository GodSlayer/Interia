package interia.module.modules;

import org.lwjgl.input.Keyboard;

import interia.Interia;
import interia.event.player.EventPlayerUpdate;
import interia.lib.event.EventListener;
import interia.lib.event.HandleEvent;
import interia.module.Category;
import interia.module.InteriaModule;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;

public class Flight extends InteriaModule implements EventListener
{
	public Flight()
	{
		super("Flight", Category.PLAYER);
		Interia.theInteria.eventHandler.registerListener(this);
		this.setKeyBind(Keyboard.KEY_R);
	}
	
	@HandleEvent
    public void updatePlayer(EventPlayerUpdate event) 
	{
        if(!this.isToggled())
        	return;

        EntityPlayer thePlayer = event.getPlayer();

        thePlayer.landMovementFactor = 0.5f;
        thePlayer.jumpMovementFactor = 0.5f;

        thePlayer.capabilities.isFlying = false;
        thePlayer.setSneaking(false);

        Interia.theInteria.getMinecraft().thePlayer.motionX = 0;
        Interia.theInteria.getMinecraft().thePlayer.motionY = 0;
        Interia.theInteria.getMinecraft().thePlayer.motionZ = 0;

        if(Interia.theInteria.getMinecraft().currentScreen == null) 
        {
            if (GameSettings.isKeyDown(Interia.theInteria.getMinecraft().gameSettings.keyBindJump))
            {
            	Interia.theInteria.getMinecraft().thePlayer.motionY = 1;
            }
            if (GameSettings.isKeyDown(Interia.theInteria.getMinecraft().gameSettings.keyBindSneak)) 
            {
            	Interia.theInteria.getMinecraft().thePlayer.motionY = -1;
            }
        }

        Interia.theInteria.getMinecraft().thePlayer.jumpMovementFactor *= 3;
    }	
}

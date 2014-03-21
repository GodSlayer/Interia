package interia.event.player;

import net.minecraft.entity.player.EntityPlayer;

public class EventPlayerPostMotionUpdate extends EventPlayerUpdate
{
	public EventPlayerPostMotionUpdate(EntityPlayer thePlayer) 
	{
		super(thePlayer);
	}
}

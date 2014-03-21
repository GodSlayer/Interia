package interia.event.player;

import interia.lib.event.Event;
import net.minecraft.entity.player.EntityPlayer;

public abstract class EventPlayer extends Event
{	
	private EntityPlayer thePlayer;
	
	public EventPlayer(EntityPlayer thePlayer)
	{
		this.thePlayer = thePlayer;
	}
	
	public EntityPlayer getPlayer()
	{
		return this.thePlayer;
	}
}

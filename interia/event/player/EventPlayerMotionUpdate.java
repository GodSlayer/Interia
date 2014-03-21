package interia.event.player;

import net.minecraft.entity.player.EntityPlayer;
import interia.lib.event.Cancellable;

public class EventPlayerMotionUpdate extends EventPlayer implements Cancellable
{
	private boolean isCancelled;
	
	public EventPlayerMotionUpdate(EntityPlayer thePlayer) 
	{
		super(thePlayer);
	}

	@Override
	public void setCancelled(boolean shouldCancel)
	{
		this.isCancelled = shouldCancel;
	}
	
	@Override
	public boolean getCancelled()
	{
		return this.isCancelled;
	}
}

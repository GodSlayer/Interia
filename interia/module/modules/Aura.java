package interia.module.modules;

import interia.event.player.EventPlayerUpdate;
import interia.lib.event.EventListener;
import interia.lib.event.HandleEvent;
import interia.module.Category;
import interia.module.InteriaModule;
import net.minecraft.entity.Entity;

public class Aura extends InteriaModule implements EventListener
{
	public static float reach = 3.8F;
	public static Entity target = null;
	private static Long last = null, delay = 125L;
	
	public Aura() 
	{
		super("Aura", Category.COMBAT);
	}
	
	@HandleEvent
	public void updatePlayer(EventPlayerUpdate theEvent)
	{
		
	}
}

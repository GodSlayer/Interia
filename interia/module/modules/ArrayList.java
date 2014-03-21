package interia.module.modules;

import interia.event.render.EventRenderInGame;
import interia.lib.event.EventListener;
import interia.lib.event.HandleEvent;
import interia.module.Category;
import interia.module.InteriaModule;

public class ArrayList extends InteriaModule implements EventListener
{
	public ArrayList() 
	{
		super("ArrayList", Category.DISPLAY);
	}
	
	@HandleEvent
	public void renderArrayList(EventRenderInGame theEvent)
	{
		
	}
}

package interia.module;

import interia.Interia;
import interia.event.other.EventKeyPress;
import interia.lib.event.EventListener;
import interia.lib.event.HandleEvent;
import interia.lib.module.ModuleManager;
import interia.module.modules.ChestESP;
import interia.module.modules.ClickGui;
import interia.module.modules.Flight;
import interia.module.modules.FullBright;
import interia.module.modules.MobESP;
import interia.module.modules.Nuker;
import interia.module.modules.PlayerESP;
import interia.module.modules.Sprint;
import interia.module.modules.Tracers;

import java.util.ArrayList;
import java.util.List;

public class InteriaModuleManager extends ModuleManager implements EventListener
{
	private List<InteriaModule> theModules = new ArrayList<InteriaModule>();
	
	public InteriaModuleManager()
	{
		Interia.theInteria.eventHandler.registerListener(this);
		this.theModules.add(new ChestESP());
		this.theModules.add(new ClickGui());
		this.theModules.add(new Flight());
		this.theModules.add(new FullBright());
		this.theModules.add(new MobESP());
		this.theModules.add(new Nuker());
		this.theModules.add(new PlayerESP());
		this.theModules.add(new Sprint());
		this.theModules.add(new Tracers());
	}
	
	@HandleEvent
    public void pressKey(EventKeyPress event) 
	{
        int keyCode = event.getKeyCode();
        for (InteriaModule theModule : this.theModules) 
        {
            if (keyCode == theModule.getKeyBind()) 
            {
            	theModule.toggleModule();
            }
        }
    }
	
	@Override
	public InteriaModule[] getModules() 
	{
		return this.theModules.toArray(new InteriaModule[this.theModules.size()]);
	}
}

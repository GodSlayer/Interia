package interia;

import interia.event.other.EventStartup;
import interia.lib.event.EventHandler;
import interia.module.InteriaModuleManager;
import interia.ui.gui.InteriaGuiManager;
import interia.ui.gui.theme.interia.InteriaTheme;
import net.minecraft.client.Minecraft;

public class Interia 
{
	public static final Interia theInteria = new Interia();
	
	public static final String CLIENT_NAME = "Interia";
	
	public static final String CLIENT_VERSION = "a1";
	
	private Minecraft theMinecraft;
	
	public EventHandler eventHandler;
	
	public InteriaModuleManager moduleManager;
	
	public InteriaGuiManager guiManager;
	
	public void startInteria(Minecraft theMinecraft)
	{
		this.theMinecraft = theMinecraft;
		this.eventHandler = new EventHandler();
		this.moduleManager = new InteriaModuleManager();
		this.guiManager = new InteriaGuiManager();
		
		this.guiManager.setTheme(new InteriaTheme());
		this.guiManager.setup();
		
		this.theInteria.eventHandler.fireEvent(new EventStartup());
	}
	
	public Minecraft getMinecraft()
	{
		return this.theMinecraft.getMinecraft();
	}
}

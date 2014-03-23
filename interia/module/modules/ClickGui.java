package interia.module.modules;

import interia.Interia;
import interia.module.Category;
import interia.module.InteriaModule;

import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;
import org.lwjgl.input.Keyboard;

public class ClickGui extends InteriaModule
{
	public ClickGui() 
	{
		super("ClickGui", Category.OTHER);
		this.setKeyBind(Keyboard.KEY_RSHIFT);
	}
	
	public void onToggle()
	{
		if(Interia.theInteria.getMinecraft().currentScreen == null)
			Interia.theInteria.getMinecraft().displayGuiScreen(new GuiManagerDisplayScreen(Interia.theInteria.guiManager));
	}
}

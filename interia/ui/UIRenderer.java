package interia.ui;

import interia.Interia;
import interia.font.Fonts;
import interia.module.InteriaModule;
import net.minecraft.client.gui.Gui;

public class UIRenderer 
{
	public static void renderUI()
	{
		Gui.drawString(Fonts.avenir22, Interia.CLIENT_NAME, 2, 2, 0x90FFFFFF);
		
		int arrayCount = 15;
		
		for(InteriaModule theModule : Interia.theInteria.moduleManager.getModules())
		{
			if(theModule.isToggled())
			{
				Gui.drawString(Fonts.avenir16, theModule.getName(), 2, arrayCount, 0x90FFFFFF);
				arrayCount += 9;
			}
		}
	}
}

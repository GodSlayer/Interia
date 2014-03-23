package interia.ui;

import interia.Interia;
import interia.font.Fonts;
import interia.module.Category;
import interia.module.InteriaModule;
import net.minecraft.client.gui.Gui;

import org.darkstorm.minecraft.gui.component.Frame;
import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;

public class UIRenderer 
{
	public static void renderUI()
	{
		Gui.drawString(Fonts.avenir22, Interia.CLIENT_NAME, 2, 2, 0x90FFFFFF);
		
		int arrayCount = 15;
		
		for(InteriaModule theModule : Interia.theInteria.moduleManager.getModules())
		{
			if(theModule.isToggled() && !(theModule.getCategory().equals(Category.OTHER)))
			{
				Gui.drawString(Fonts.avenir16, theModule.getName(), 2, arrayCount, 0x90FFFFFF);
				arrayCount += 9;
			}
		}
		
		for(Frame theFrame : Interia.theInteria.guiManager.getFrames())
		{
			if(theFrame.isPinned() || Interia.theInteria.getMinecraft().currentScreen instanceof GuiManagerDisplayScreen)
				theFrame.render();
		}
		
		for(Frame theFrame : Interia.theInteria.guiManager.getFrames())
		{
			theFrame.update();
		}
	}
}

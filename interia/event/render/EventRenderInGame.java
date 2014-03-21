package interia.event.render;

import net.minecraft.client.gui.GuiIngame;

public class EventRenderInGame extends EventRender
{
	private GuiIngame ingameGUI;
	
	public EventRenderInGame(GuiIngame ingameGUI)
	{
		this.ingameGUI = ingameGUI;
	}
	
	public GuiIngame getIngameGUI()
	{
		return this.ingameGUI;
	}
}

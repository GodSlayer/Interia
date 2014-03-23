package interia.ui.gui.theme.interia;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2d;
import interia.utils.RenderUtils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import net.minecraft.client.gui.Gui;

import org.darkstorm.minecraft.gui.component.Button;
import org.darkstorm.minecraft.gui.component.Component;
import org.darkstorm.minecraft.gui.theme.AbstractComponentUI;
import org.darkstorm.minecraft.gui.util.RenderUtil;
import org.lwjgl.input.Mouse;

public class InteriaButtonUI extends AbstractComponentUI<Button> {
	private final InteriaTheme theme;

	InteriaButtonUI(InteriaTheme theme) {
		super(Button.class);
		this.theme = theme;

		foreground = Color.gray;
		background = new Color(128, 128, 128, 128 + 128 / 2);
	}

	@Override
	protected void renderComponent(Button button) {
		translateComponent(button, false);
		Rectangle area = button.getArea();
		
		/**
		 * Draw the button
		 */
		RenderUtils.drawBorderedRect(1, 1, area.width - 1, area.height - 1, 0xFF696969, 0xFFFFFFFF);
		
		Point mouse = RenderUtil.calculateMouseLocation();
		Component parent = button.getParent();
		while(parent != null) {
			mouse.x -= parent.getX();
			mouse.y -= parent.getY();
			parent = parent.getParent();
		}
		if(area.contains(mouse)) 
		{
			RenderUtils.drawBorderedRect(1, 1, area.width - 1, area.height - 1, 0xFF696969, 0xFFC0C0C0);
		}
		glEnable(GL_TEXTURE_2D);

		String text = button.getText();
		theme.getFontRenderer().drawString(
				text,
				area.width / 2 - theme.getFontRenderer().getStringWidth(text)
						/ 2,
				area.height / 2 - theme.getFontRenderer().FONT_HEIGHT / 2,
				RenderUtil.toRGBA(button.getForegroundColor()));

		glEnable(GL_CULL_FACE);
		glDisable(GL_BLEND);
		translateComponent(button, true);
	}

	@Override
	protected Dimension getDefaultComponentSize(Button component) {
		return new Dimension(theme.getFontRenderer().getStringWidth(
				component.getText()) + 4,
				theme.getFontRenderer().FONT_HEIGHT + 4);
	}

	@Override
	protected Rectangle[] getInteractableComponentRegions(Button component) {
		return new Rectangle[] { new Rectangle(0, 0, component.getWidth(),
				component.getHeight()) };
	}

	@Override
	protected void handleComponentInteraction(Button component, Point location,
			int button) {
		if(location.x <= component.getWidth()
				&& location.y <= component.getHeight() && button == 0)
			component.press();
	}
}
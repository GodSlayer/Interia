package interia.ui.gui.theme.interia;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_LINE_LOOP;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLineWidth;
import static org.lwjgl.opengl.GL11.glVertex2d;
import interia.utils.RenderUtils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import org.darkstorm.minecraft.gui.component.Component;
import org.darkstorm.minecraft.gui.component.Frame;
import org.darkstorm.minecraft.gui.layout.Constraint;
import org.darkstorm.minecraft.gui.theme.AbstractComponentUI;
import org.darkstorm.minecraft.gui.util.RenderUtil;

public class InteriaFrameUI extends AbstractComponentUI<Frame> {
	private final InteriaTheme theme;

	InteriaFrameUI(InteriaTheme theme) 
	{
		super(Frame.class);
		this.theme = theme;

		foreground = Color.WHITE;
		background = new Color(128, 128, 128, 128);
	}

	@Override
	protected void renderComponent(Frame component) 
	{
		Rectangle area = new Rectangle(component.getArea());
		int fontHeight = theme.getFontRenderer().FONT_HEIGHT;
		translateComponent(component, false);
		glEnable(GL_BLEND);
		glDisable(GL_CULL_FACE);
		glDisable(GL_TEXTURE_2D);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		// Draw frame background
		if(component.isMinimized())
			area.height = fontHeight + 4;
		
		RenderUtils.drawBorderedRect(0, 0, area.width, area.height, 0xff000000, 0xAF0f0f0f);

		// Draw controls
		int offset = component.getWidth() - 2;
		Point mouse = RenderUtil.calculateMouseLocation();
		Component parent = component;
		while(parent != null) {
			mouse.x -= parent.getX();
			mouse.y -= parent.getY();
			parent = parent.getParent();
		}
		boolean[] checks = new boolean[] { component.isClosable(),
				component.isPinnable(), component.isMinimizable() };
		boolean[] overlays = new boolean[] { false, component.isPinned(),
				component.isMinimized() };
		for(int i = 0; i < checks.length; i++) {
			if(!checks[i])
				continue;
			RenderUtil.setColor(component.getBackgroundColor());
			
			RenderUtils.drawBorderedRect(offset - fontHeight, 2, offset, fontHeight + 2, 0xff000000, 0xff292929);
			
			if(overlays[i]) 
			{
				RenderUtils.drawBorderedRect(offset - fontHeight, 2, offset, fontHeight + 2, 0xff000000, 0xff202020);
			}
			if(mouse.x >= offset - fontHeight && mouse.x <= offset
					&& mouse.y >= 2 && mouse.y <= fontHeight + 2) 
			{
				RenderUtils.drawBorderedRect(offset - fontHeight, 2, offset, fontHeight + 2, 0xff000000, 0xff33ccff);
			}
			offset -= fontHeight + 2;
		}

		glColor4f(0f, 0f, 0f, 1f);
		glLineWidth(1.0f);
		glBegin(GL_LINES);
		{
			glVertex2d(2, theme.getFontRenderer().FONT_HEIGHT + 4);
			glVertex2d(area.width - 2, theme.getFontRenderer().FONT_HEIGHT + 4);
		}
		glEnd();
		glEnable(GL_TEXTURE_2D);
		theme.getFontRenderer().drawStringWithShadow(component.getTitle(), 2,
				2, RenderUtil.toRGBA(component.getForegroundColor()));
		glEnable(GL_CULL_FACE);
		glDisable(GL_BLEND);
		translateComponent(component, true);
	}

	@Override
	protected Rectangle getContainerChildRenderArea(Frame container) {
		Rectangle area = new Rectangle(container.getArea());
		area.x = 2;
		area.y = theme.getFontRenderer().FONT_HEIGHT + 6;
		area.width -= 4;
		area.height -= theme.getFontRenderer().FONT_HEIGHT + 8;
		return area;
	}

	@Override
	protected Dimension getDefaultComponentSize(Frame component) {
		Component[] children = component.getChildren();
		Rectangle[] areas = new Rectangle[children.length];
		Constraint[][] constraints = new Constraint[children.length][];
		for(int i = 0; i < children.length; i++) {
			Component child = children[i];
			Dimension size = child.getTheme().getUIForComponent(child)
					.getDefaultSize(child);
			areas[i] = new Rectangle(0, 0, size.width, size.height);
			constraints[i] = component.getConstraints(child);
		}
		Dimension size = component.getLayoutManager().getOptimalPositionedSize(
				areas, constraints);
		size.width += 4;
		size.height += theme.getFontRenderer().FONT_HEIGHT + 8;
		return size;
	}

	@Override
	protected Rectangle[] getInteractableComponentRegions(Frame component) {
		return new Rectangle[] { new Rectangle(0, 0, component.getWidth(),
				theme.getFontRenderer().FONT_HEIGHT + 4) };
	}

	@Override
	protected void handleComponentInteraction(Frame component, Point location,
			int button) {
		if(button != 0)
			return;
		int offset = component.getWidth() - 2;
		int textHeight = theme.getFontRenderer().FONT_HEIGHT;
		if(component.isClosable()) {
			if(location.x >= offset - textHeight && location.x <= offset
					&& location.y >= 2 && location.y <= textHeight + 2) {
				component.close();
				return;
			}
			offset -= textHeight + 2;
		}
		if(component.isPinnable()) {
			if(location.x >= offset - textHeight && location.x <= offset
					&& location.y >= 2 && location.y <= textHeight + 2) {
				component.setPinned(!component.isPinned());
				return;
			}
			offset -= textHeight + 2;
		}
		if(component.isMinimizable()) {
			if(location.x >= offset - textHeight && location.x <= offset
					&& location.y >= 2 && location.y <= textHeight + 2) {
				component.setMinimized(!component.isMinimized());
				return;
			}
			offset -= textHeight + 2;
		}
		if(location.x >= 0 && location.x <= offset && location.y >= 0
				&& location.y <= textHeight + 4) {
			component.setDragging(true);
			return;
		}
	}
}

package interia.ui.gui.theme.interia;

import interia.font.UnicodeFontRenderer;

import java.awt.Font;

import net.minecraft.client.gui.FontRenderer;

import org.darkstorm.minecraft.gui.theme.AbstractTheme;

public class InteriaTheme extends AbstractTheme {
	private final FontRenderer fontRenderer;

	public InteriaTheme() 
	{
		fontRenderer = new UnicodeFontRenderer(new Font("Avenir", Font.PLAIN, 23));

		installUI(new InteriaFrameUI(this));
		installUI(new InteriaPanelUI(this));
		installUI(new InteriaLabelUI(this));
		installUI(new InteriaButtonUI(this));
		installUI(new InteriaCheckButtonUI(this));
		installUI(new InteriaComboBoxUI(this));
		installUI(new InteriaSliderUI(this));
		installUI(new InteriaProgressBarUI(this));
	}

	public FontRenderer getFontRenderer() {
		return fontRenderer;
	}
}

package interia.font;

import java.awt.Font;

public class Fonts 
{
	public static UnicodeFontRenderer avenir16;
	public static UnicodeFontRenderer avenir22;
	
	public static void loadFonts()
	{
		avenir16 = new UnicodeFontRenderer(new Font("Avenir", Font.PLAIN, 16));
		avenir22 = new UnicodeFontRenderer(new Font("Avenir", Font.BOLD, 22));
	}
}

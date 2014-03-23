package interia.utils;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.AxisAlignedBB;

import org.lwjgl.opengl.GL11;

public class RenderUtils extends Gui
{
	public static void drawOutlinedBoundingBox(AxisAlignedBB aa)
	{
		Tessellator t = Tessellator.instance;
	    t.startDrawing(3);
	    t.addVertex(aa.minX, aa.minY, aa.minZ);
	    t.addVertex(aa.maxX, aa.minY, aa.minZ);
	    t.addVertex(aa.maxX, aa.minY, aa.maxZ);
	    t.addVertex(aa.minX, aa.minY, aa.maxZ);
	    t.addVertex(aa.minX, aa.minY, aa.minZ);
	    t.draw();
	    t.startDrawing(3);
	    t.addVertex(aa.minX, aa.maxY, aa.minZ);
	    t.addVertex(aa.maxX, aa.maxY, aa.minZ);
	    t.addVertex(aa.maxX, aa.maxY, aa.maxZ);
	    t.addVertex(aa.minX, aa.maxY, aa.maxZ);
	    t.addVertex(aa.minX, aa.maxY, aa.minZ);
	    t.draw();
	    t.startDrawing(1);
	    t.addVertex(aa.minX, aa.minY, aa.minZ);
	    t.addVertex(aa.minX, aa.maxY, aa.minZ);
	    t.addVertex(aa.maxX, aa.minY, aa.minZ);
	    t.addVertex(aa.maxX, aa.maxY, aa.minZ);
	    t.addVertex(aa.maxX, aa.minY, aa.maxZ);
	    t.addVertex(aa.maxX, aa.maxY, aa.maxZ);
	    t.addVertex(aa.minX, aa.minY, aa.maxZ);
	    t.addVertex(aa.minX, aa.maxY, aa.maxZ);
	    t.draw();
	  }

	  public static void drawBoundingBox(AxisAlignedBB aa)
	  {
	    Tessellator t = Tessellator.instance;
	    t.startDrawingQuads();
	    t.addVertex(aa.minX, aa.minY, aa.minZ);
	    t.addVertex(aa.minX, aa.maxY, aa.minZ);
	    t.addVertex(aa.maxX, aa.minY, aa.minZ);
	    t.addVertex(aa.maxX, aa.maxY, aa.minZ);
	    t.addVertex(aa.maxX, aa.minY, aa.maxZ);
	    t.addVertex(aa.maxX, aa.maxY, aa.maxZ);
	    t.addVertex(aa.minX, aa.minY, aa.maxZ);
	    t.addVertex(aa.minX, aa.maxY, aa.maxZ);
	    t.draw();
	    t.startDrawingQuads();
	    t.addVertex(aa.maxX, aa.maxY, aa.minZ);
	    t.addVertex(aa.maxX, aa.minY, aa.minZ);
	    t.addVertex(aa.minX, aa.maxY, aa.minZ);
	    t.addVertex(aa.minX, aa.minY, aa.minZ);
	    t.addVertex(aa.minX, aa.maxY, aa.maxZ);
	    t.addVertex(aa.minX, aa.minY, aa.maxZ);
	    t.addVertex(aa.maxX, aa.maxY, aa.maxZ);
	    t.addVertex(aa.maxX, aa.minY, aa.maxZ);
	    t.draw();
	    t.startDrawingQuads();
	    t.addVertex(aa.minX, aa.maxY, aa.minZ);
	    t.addVertex(aa.maxX, aa.maxY, aa.minZ);
	    t.addVertex(aa.maxX, aa.maxY, aa.maxZ);
	    t.addVertex(aa.minX, aa.maxY, aa.maxZ);
	    t.addVertex(aa.minX, aa.maxY, aa.minZ);
	    t.addVertex(aa.minX, aa.maxY, aa.maxZ);
	    t.addVertex(aa.maxX, aa.maxY, aa.maxZ);
	    t.addVertex(aa.maxX, aa.maxY, aa.minZ);
	    t.draw();
	    t.startDrawingQuads();
	    t.addVertex(aa.minX, aa.minY, aa.minZ);
	    t.addVertex(aa.maxX, aa.minY, aa.minZ);
	    t.addVertex(aa.maxX, aa.minY, aa.maxZ);
	    t.addVertex(aa.minX, aa.minY, aa.maxZ);
	    t.addVertex(aa.minX, aa.minY, aa.minZ);
	    t.addVertex(aa.minX, aa.minY, aa.maxZ);
	    t.addVertex(aa.maxX, aa.minY, aa.maxZ);
	    t.addVertex(aa.maxX, aa.minY, aa.minZ);
	    t.draw();
	    t.startDrawingQuads();
	    t.addVertex(aa.minX, aa.minY, aa.minZ);
	    t.addVertex(aa.minX, aa.maxY, aa.minZ);
	    t.addVertex(aa.minX, aa.minY, aa.maxZ);
	    t.addVertex(aa.minX, aa.maxY, aa.maxZ);
	    t.addVertex(aa.maxX, aa.minY, aa.maxZ);
	    t.addVertex(aa.maxX, aa.maxY, aa.maxZ);
	    t.addVertex(aa.maxX, aa.minY, aa.minZ);
	    t.addVertex(aa.maxX, aa.maxY, aa.minZ);
	    t.draw();
	    t.startDrawingQuads();
	    t.addVertex(aa.minX, aa.maxY, aa.maxZ);
	    t.addVertex(aa.minX, aa.minY, aa.maxZ);
	    t.addVertex(aa.minX, aa.maxY, aa.minZ);
	    t.addVertex(aa.minX, aa.minY, aa.minZ);
	    t.addVertex(aa.maxX, aa.maxY, aa.minZ);
	    t.addVertex(aa.maxX, aa.minY, aa.minZ);
	    t.addVertex(aa.maxX, aa.maxY, aa.maxZ);
	    t.addVertex(aa.maxX, aa.minY, aa.maxZ);
	    t.draw();
	  }

	  public static void drawESP(double d, double d1, double d2, double r, double b, double g, double alpha)
	  {
	    GL11.glPushMatrix();
	    GL11.glEnable(3042);
	    GL11.glBlendFunc(770, 771);
	    GL11.glLineWidth(1.0F);
	    GL11.glDisable(2896);
	    GL11.glDisable(3553);
	    GL11.glEnable(2848);
	    GL11.glDisable(2929);
	    GL11.glDepthMask(false);
	    GL11.glColor4d(r, g, b, alpha);
	    drawBoundingBox(new AxisAlignedBB(d, d1, d2, d + 1.0D, d1 + 1.0D, d2 + 1.0D));
	    GL11.glColor4d(r, g, b, 1.0D);
	    drawOutlinedBoundingBox(new AxisAlignedBB(d, d1, d2, d + 1.0D, d1 + 1.0D, d2 + 1.0D));
	    GL11.glLineWidth(2.0F);
	    GL11.glDisable(2848);
	    GL11.glEnable(3553);
	    GL11.glEnable(2896);
	    GL11.glEnable(2929);
	    GL11.glDepthMask(true);
	    GL11.glDisable(3042);
	    GL11.glPopMatrix();
	  }
	  
	  public static void drawNukerESP(double d, double d1, double d2, double r, double b, double g, double alpha)
	  {
	    GL11.glPushMatrix();
	    GL11.glEnable(3042);
	    GL11.glBlendFunc(770, 771);
	    GL11.glLineWidth(1.0F);
	    GL11.glDisable(2896);
	    GL11.glDisable(3553);
	    GL11.glEnable(2848);
	    GL11.glDisable(2929);
	    GL11.glDepthMask(false);
	    GL11.glColor4d(r, g, b, alpha);
	    drawBoundingBox(new AxisAlignedBB(d, d1, d2, d + 1.0D, d1 + 1.0D, d2 + 1.0D));
	    GL11.glColor4d(1.0D, 1.0D, 1.0D, 1.0D);
	    drawOutlinedBoundingBox(new AxisAlignedBB(d, d1, d2, d + 1.0D, d1 + 1.0D, d2 + 1.0D));
	    GL11.glLineWidth(2.0F);
	    GL11.glDisable(2848);
	    GL11.glEnable(3553);
	    GL11.glEnable(2896);
	    GL11.glEnable(2929);
	    GL11.glDepthMask(true);
	    GL11.glDisable(3042);
	    GL11.glPopMatrix();
	  }
	  
	  public static void drawGradientRect(double x, double y, double x2, double y2, int col1, int col2) 
	  {
			float f = (float)(col1 >> 24 & 0xFF) / 255F;
			float f1 = (float)(col1 >> 16 & 0xFF) / 255F;
			float f2 = (float)(col1 >> 8 & 0xFF) / 255F;
			float f3 = (float)(col1 & 0xFF) / 255F;

			float f4 = (float)(col2 >> 24 & 0xFF) / 255F;
			float f5 = (float)(col2 >> 16 & 0xFF) / 255F;
			float f6 = (float)(col2 >> 8 & 0xFF) / 255F;
			float f7 = (float)(col2 & 0xFF) / 255F;

			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glEnable(GL11.GL_LINE_SMOOTH);
			GL11.glShadeModel(GL11.GL_SMOOTH);

			GL11.glPushMatrix();
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glColor4f(f1, f2, f3, f);
			GL11.glVertex2d(x2, y);
			GL11.glVertex2d(x, y);

			GL11.glColor4f(f5, f6, f7, f4);
			GL11.glVertex2d(x, y2);
			GL11.glVertex2d(x2, y2);
			GL11.glEnd();
			GL11.glPopMatrix();

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_LINE_SMOOTH);
			GL11.glShadeModel(GL11.GL_FLAT);
		}

		public static void drawGradientBorderedRect(double x, double y, double x2, double y2, float l1, int col1, int col2, int col3)
		{
			float f = (float)(col1 >> 24 & 0xFF) / 255F;
			float f1 = (float)(col1 >> 16 & 0xFF) / 255F;
			float f2 = (float)(col1 >> 8 & 0xFF) / 255F;
			float f3 = (float)(col1 & 0xFF) / 255F;

			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glEnable(GL11.GL_LINE_SMOOTH);
			GL11.glDisable(GL11.GL_BLEND);

			GL11.glPushMatrix();
			GL11.glColor4f(f1, f2, f3, f);
			GL11.glLineWidth(1F);
			GL11.glBegin(GL11.GL_LINES);
			GL11.glVertex2d(x, y);
			GL11.glVertex2d(x, y2);
			GL11.glVertex2d(x2, y2);
			GL11.glVertex2d(x2, y);
			GL11.glVertex2d(x, y);
			GL11.glVertex2d(x2, y);
			GL11.glVertex2d(x, y2);
			GL11.glVertex2d(x2, y2);
			GL11.glEnd();
			GL11.glPopMatrix();

			drawGradientRect(x, y, x2, y2, col2, col3);

			GL11.glEnable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_LINE_SMOOTH);
		}
		
		public static void drawRect(float par0, float par1, float par2, float par3, int par4)
		{
		    if (par0 < par2)
		    {
		      float var5 = par0;
		      par0 = par2;
		      par2 = var5;
		    }

		    if (par1 < par3)
		    {
		      float var5 = par1;
		      par1 = par3;
		      par3 = var5;
		    }

		    float var10 = (par4 >> 24 & 0xFF) / 255.0F;
		    float var6 = (par4 >> 16 & 0xFF) / 255.0F;
		    float var7 = (par4 >> 8 & 0xFF) / 255.0F;
		    float var8 = (par4 & 0xFF) / 255.0F;
		    Tessellator var9 = Tessellator.instance;
		    GL11.glEnable(3042);
		    GL11.glDisable(3553);
		    GL11.glDisable(2896);
		    OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		    GL11.glColor4f(var6, var7, var8, var10);
		    var9.startDrawingQuads();
		    var9.addVertex(par0, par3, 0.0D);
		    var9.addVertex(par2, par3, 0.0D);
		    var9.addVertex(par2, par1, 0.0D);
		    var9.addVertex(par0, par1, 0.0D);
		    var9.draw();
		    GL11.glEnable(3553);
		    GL11.glDisable(3042);
		  }
		
		public static void drawBorderedRect(float x, float y, float x1, float y1, int borderC, int insideC)
		{
			x *= 2; x1 *= 2; y *= 2; y1 *= 2;
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			drawVLine(x, y, y1 - 1, borderC);
			drawVLine(x1 - 1, y , y1, borderC);
			drawHLine(x, x1 - 1, y, borderC);
			drawHLine(x, x1 - 2, y1 -1, borderC);
			drawRect(x + 1, y + 1, x1 - 1, y1 - 1, insideC);
			GL11.glScalef(2.0F, 2.0F, 2.0F);
		}
		
		public static void drawHLine(float par1, float par2, float par3, int par4)
		{
			if (par2 < par1)
			{
				float var5 = par1;
				par1 = par2;
				par2 = var5;
			}

			drawRect(par1, par3, par2 + 1, par3 + 1, par4);
		}

		public static void drawVLine(float par1, float par2, float par3, int par4)
		{
			if (par3 < par2)
			{
				float var5 = par2;
				par2 = par3;
				par3 = var5;
			}

			drawRect(par1, par2 + 1, par1 + 1, par3, par4);
		}
}

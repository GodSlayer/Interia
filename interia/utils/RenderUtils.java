package interia.utils;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.AxisAlignedBB;

import org.lwjgl.opengl.GL11;

public class RenderUtils 
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
}

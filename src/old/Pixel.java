
package old;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * 
 * @author sergiodiazpinilla
 */
public class Pixel extends Canvas
{
	
	private static int matrixPixel[][];
	private static int HEIGHT;
	private static int WHIDTH;
	
	public static int getHEIGHT()
	{
		return HEIGHT;
	}
	
	public static void setHEIGHT(int HEIGHT)
	{
		Pixel.HEIGHT = HEIGHT;
	}
	
	public static int getWHIDTH()
	{
		return WHIDTH;
	}
	
	public static void setWHIDTH(int WHIDTH)
	{
		Pixel.WHIDTH = WHIDTH;
	}
	
	public static int[][] getmatrixPixel()
	{
		return matrixPixel;
	}
	
	public static void setmatrixPixel(int[][] matrixPixel)
	{
		Pixel.matrixPixel = matrixPixel;
	}
	
	private Color Colormatrix(int RGB)
	{
		return new Color(RGB);
	}
	
	public Pixel(int[][] matrixPixel, int whidth, int height)
	{
		
		this.matrixPixel = matrixPixel;
		WHIDTH = whidth;
		HEIGHT = height;
	}
	
	public Pixel()
	{
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		
		for (int i = 0; i < HEIGHT; i++)
		{
			for (int j = 0; j < WHIDTH; j++)
			{
				g.setColor(Colormatrix(matrixPixel[j][i]));
				g.drawLine(j, i, j, i);
				
			}
			
		}
		
	}
	
	public static JFrame pintar(int whidth, int height)
	{
		
		JFrame frame = new JFrame();
		
		frame.setSize(whidth, height);
		
		frame.add(new Pixel(matrixPixel, WHIDTH, HEIGHT));
		
		frame.setVisible(true);
		
		return frame;
	}
}

/**
 * File: ImageUtil.java
 * Package: ProyectoDiscretas2.image.ImageUtil
 * Creation: 21/05/2014 at 15:45:32
 */

package image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author camiloasc1
 * 
 */
public class ImageUtil
{
	public static BufferedImage readImage(String file)
	{
		BufferedImage image = null;
		
		try
		{
			image = ImageIO.read(new File(file));
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
		
		return image;
	}
	
	public static void saveImage(String file, BufferedImage image)
	{
		try
		{
			ImageIO.write(image, "png", new File(file));
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
	}
	
	public static int[][] imageToMatrix(BufferedImage image)
	{
		int w = image.getWidth();
		int h = image.getHeight();
		int[][] imageMatrix = new int[w][h];
		
		for (int i = 0; i < w; i++)
		{
			for (int j = 0; j < h; j++)
			{
				imageMatrix[i][j] = image.getRGB(i, j);
			}
		}
		return imageMatrix;
	}
	
	public static BufferedImage matrixToImage(int[][] imageMatrix)
	{
		int w = imageMatrix.length;
		int h = imageMatrix[0].length;
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		
		for (int i = 0; i < w; i++)
		{
			for (int j = 0; j < h; j++)
			{
				image.setRGB(i, j, imageMatrix[i][j]);
			}
		}
		return image;
	}
}

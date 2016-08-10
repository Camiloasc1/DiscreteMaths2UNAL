
package crypto;

import java.awt.Canvas;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import util.Pixel;

/**
 * 
 * @author sergiodiazpinilla
 */
public class Process extends Canvas
{
	private static final long serialVersionUID = -7635915398849188478L;
	
	// Funcion que convierte una image en una matrix
	public static int[][] imageMatrix(BufferedImage image)
	{
		
		int[][] imageMatrix = new int[image.getWidth()][image.getHeight()];
		for (int i = 0; i < image.getHeight(); i++)
		{
			for (int j = 0; j < image.getWidth(); j++)
			{
				try
				{
					imageMatrix[j][i] = image.getRGB(j, i);
				}
				catch (ArrayIndexOutOfBoundsException e)
				{
					System.out.println("Cordenada[" + j + "][" + i + "]");
				}
				
			}
		}
		return imageMatrix;
	}
	
	// Funcion que pasa el arreglo con valores de pixel en una image
	public static BufferedImage imageArray(int[] pixels, int width, int height)
	{
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int ctr = 0;
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				image.setRGB(j, i, pixels[ctr]);
				ctr++;
			}
		}
		return image;
	}
	
	// Funcion que carga la image
	
	public static BufferedImage load(String directorio)
	{
		BufferedImage image = null;
		try
		{
			image = ImageIO.read(new File(directorio));
		}
		catch (IOException ex)
		{
			Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
			
		}
		System.out.println("imagen cargada :" + directorio);
		return image;
	}
	
	// Metodo que guarda la image
	public static void save(String directory, BufferedImage image)
	{
		BufferedImage img = image;
		try
		{
			BufferedImage bi = img;
			File outputfile = new File("src/saved.png");
			ImageIO.write(bi, "png", outputfile);
		}
		catch (IOException e)
		{
			System.out.println("image no encontrada en" + directory);
		}
		System.out.println("image guardada en " + directory);
		
	}
	
	// Funcion qque convierte una matiz un arreglo
	
	public static int[] arrayToMatrix(int[][] matrix, int width, int height)
	{
		int[] imageArray = new int[width * height];
		int ind = 0;
		
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				imageArray[ind] = matrix[j][i];
				ind++;
			}
			
		}
		return imageArray;
		
	}
	
	// Funcion que imprime los valores de los pixeles en forma de matrix (Para mirrar si serve)
	
	public static void printMatrix(int[][] matrix, int width, int height)
	{
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				System.out.print("[" + matrix[j][i] + "]");
			}
			System.out.println();
		}
		
	}
	
	// Calculos para el cifrado
	public static double caothicFunction(double r, int n, double x)
	{
		double x2;
		if (n < 0)
		{
			n = -n;
		}
		for (int i = 1; i <= n; i++)
		{
			x2 = r * x * (1 - x);
			x = x2;
		}
		
		if (x < 0)
			// System.out.println(x);
			return (x);
		else
			// System.out.println(x);
			return x;
		
	}
	
	// Funcion en la cual se haria la codificacion
	public static int[][] logisticFunctionPixel(int[][] imageMatrix, int width, int height, double password)
	{
		Random random = new Random();
		int[][] image = new int[width][height];
		image = imageMatrix;
		
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				
				image[j][i] = (int) (image[j][i] * (caothicFunction(4.0, image[j][i], password)));
				// imageMatrix[caothicFunction(j, j, password) % width][caothicFunction(i, i, password) % height];
				// imageMatrix[(int)(random.nextDouble() * width)][(int)(random.nextDouble() * height)];
			}
			
		}
		
		return image;
		
	}
	
	public static int[][] decryptLogisticFunctionPixel(int[][] imageMatrix, int width, int height, double password)
	{
		
		Random random = new Random();
		int[][] image = new int[width][height];
		image = imageMatrix;
		
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				
				image[j][i] = (int) (image[j][i] / (caothicFunction(4.0, 1340, password)));
				
				// imageMatrix[caothicFunction(j, j, password) % width][caothicFunction(i, i, password) % height];
				// imageMatrix[(int)(random.nextDouble() * width)][(int)(random.nextDouble() * height)];
			}
			
		}
		
		return image;
		
	}
	
	public static int[][] logisticFunctionMatrix(int[][] imageMatrix, int width, int height, double password)
	{
		Random random = new Random();
		int[][] image = new int[width][height];
		image = imageMatrix;
		
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				// System.out.println("Original"+image[j][i]);
				// System.out.println("Opreratin:"+(j*caothicFunction(4.0, 1340, password))+",....."+(i*caothicFunction(4.0, 1340, password)));
				image[j][i] = image[(int) (100 * j * caothicFunction(4.0, 1340, password)) % width][(int) (100 * i * caothicFunction(
						4.0, 1340, password)) % height];
				
				// imageMatrix[caothicFunction(j, j, password) % width][caothicFunction(i, i, password) % height];
				// imageMatrix[(int)(random.nextDouble() * width)][(int)(random.nextDouble() * height)];
			}
			
		}
		
		return image;
		
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		
		BufferedImage img = null;
		img = load("UNAL.png");
		final int width = img.getWidth();
		final int height = img.getHeight();
		double password = 0.1;
		int[][] imageMatrix = new int[width][height];
		int[][] finalImage = new int[width][height];
		
		int[] imageArray = new int[width * height];
		
		imageMatrix = imageMatrix(img);
		
		Pixel imageMatrixPintar = new Pixel(imageMatrix, width, height);
		imageMatrixPintar.pintar(width, height);
		
		Thread.sleep(1000);
		System.out.println("Imagen despues de logisticFunctionMatix");
		imageMatrix = logisticFunctionMatrix(imageMatrix, width, height, password);
		Pixel imagelogisticFunctionMatix = new Pixel(imageMatrix, width, height);
		imagelogisticFunctionMatix.pintar(width, height);
		
		Thread.sleep(1000);
		System.out.println("Imagen despues de logisticFunctionPixel");
		imageMatrix = logisticFunctionPixel(imageMatrix, width, height, password);
		Pixel imagelogisticFunctionPixel = new Pixel(imageMatrix, width, height);
		imagelogisticFunctionPixel.pintar(width, height);
		
		imageArray = arrayToMatrix(imageMatrix, width, height);
		
		BufferedImage img2 = null;
		img2 = imageArray(imageArray, width, height);
		save("src/saved.png", img2);
		
		Thread.sleep(1000);
		Pixel encriptedImage = new Pixel(imageMatrix, width, height);
		encriptedImage.pintar(width, height);
		
		Thread.sleep(1000);
		finalImage = decryptLogisticFunctionPixel(finalImage, width, height, .1);
		Pixel imagedecryptLogisticFunctionPixel = new Pixel(finalImage, width, height);
		imagedecryptLogisticFunctionPixel.pintar(width, height);
		
	}
}

// http://warse.org/pdfs/2013/ijacst06282013.pdf
// ftp://ftp.elet.polimi.it/outgoing/Carlo.Piccardi/VarieCda/ArticoliStudenti/i14.pdf
// http://en.wikipedia.org/wiki/List_of_chaotic_maps

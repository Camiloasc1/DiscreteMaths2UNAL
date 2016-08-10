/**
 * File: Crypto.java
 * Package: ProyectoDiscretas2.crypto.Crypto
 * Creation: 21/05/2014 at 16:46:30
 */
package crypto;

import image.ImageUtil;

import java.awt.image.BufferedImage;

import chaotic.ChaoticSource;
import chaotic.LogisticMap;

/**
 * @author camiloasc1
 * 
 */
public class Crypto {

    public static BufferedImage encode(BufferedImage image, ChaoticSource chaotic) {

        String temp = "";
        String temp2 = "";
        String temp3 = "";
        int[][] imageMatrix = ImageUtil.imageToMatrix(image);
        temp=Integer.toBinaryString(imageMatrix[0][0]);
        int temp5=imageMatrix[0][0];
        int temp6=0;
        
        
        for (int i = 0; i < imageMatrix.length; i++) {
            for (int j = 0; j < imageMatrix[0].length; j++) {
                
                int temp4 =wrap(chaotic);
                imageMatrix[i][j] ^= temp4;
                if(i==0&&j==0){
                    temp3=Integer.toBinaryString(temp4);
                    temp6=temp4;
                }
                
            }
        }
         temp2=Integer.toBinaryString(imageMatrix[0][0]);
         
         System.out.println("    "+temp+"("+temp5+")");
         System.out.println("XOR   "+temp3+"("+temp6+")");
         System.out.println("   ="+temp2+"("+imageMatrix[0][0]+")");

        return ImageUtil.matrixToImage(imageMatrix);
    }

    public static BufferedImage decode(BufferedImage image, ChaoticSource chaotic) {
        int[][] imageMatrix = ImageUtil.imageToMatrix(image);
        for (int i = 0; i < imageMatrix.length; i++) {
            for (int j = 0; j < imageMatrix[0].length; j++) {
                imageMatrix[i][j] ^= wrap(chaotic);
            }
        }
        return ImageUtil.matrixToImage(imageMatrix);
    }

    private static int wrap(ChaoticSource chaotic) {
        if (chaotic instanceof LogisticMap) {
            return (int) (chaotic.next() * 10E8);
        }
        return 0;
    }
}

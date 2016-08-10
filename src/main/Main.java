package main;

import image.ImageUtil;

import java.awt.image.BufferedImage;

import chaotic.ChaoticSource;
import chaotic.LogisticMap;
import crypto.Crypto;

/**
 * @author camiloasc1

 */
public class Main {

    public static String encode(String open, String save) {

        BufferedImage image = ImageUtil.readImage(open);
        ImageUtil.saveImage(save, image);

        ChaoticSource chaotic = new LogisticMap();
        chaotic.init();
        byte[] key = chaotic.getKey();

        image = Crypto.encode(image, chaotic);
        ImageUtil.saveImage(save, image);


        String password = "";
        for (byte b : key) {
            
            password = password + b + ":";
        }
        
 
        return password;

    }

    public static void decode(String open, String save, String password) {

        BufferedImage image = ImageUtil.readImage(open);
        ImageUtil.saveImage(save, image);
        String[] sincomas = password.split(":");
        ChaoticSource chaotic = new LogisticMap();

        byte[] key = new byte[sincomas.length];
        for (int i = 0; i < sincomas.length; i++) {
            key[i] = (byte) Integer.parseInt(sincomas[i]);
        }

        chaotic.init(key);
        image = Crypto.decode(image, chaotic);
        ImageUtil.saveImage(save, image);


    }
}

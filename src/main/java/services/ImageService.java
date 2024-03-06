package services;

import entities.Image;

import java.awt.*;

public class ImageService {

    public static void setFirstPixelBlue(Image image){
        image.getBufferedImage().setRGB(0, 0, Color.BLUE.getRGB());
    }

    public static void setCentralPixelGreen(Image image){
        image.getBufferedImage().setRGB(image.getWidth()/2,image.getHeight()/2, Color.GREEN.getRGB());
    }

    public static void setLastPixelRed(Image image){
        image.getBufferedImage().setRGB(image.getWidth()-1, image.getHeight()-1, Color.RED.getRGB());
    }

    public static void showRGBofEveryPixel(Image image){
        // Format: x,y - R G B
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                System.out.println(i + "," + j + " - " + color.getRed() + " " + color.getGreen() + " " + color.getBlue());
            }
        }
    }
}

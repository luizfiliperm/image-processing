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
}

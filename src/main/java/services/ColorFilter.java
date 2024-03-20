package services;

import entities.Image;

import java.awt.*;

public class ColorFilter {

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

    public static void blackAndWhiteRedBased(Image image){
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); i++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(color.getRed(), color.getRed(), color.getRed());
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    public static void blackAndWhiteBlueBased(Image image){
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); i++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(color.getBlue(), color.getBlue(), color.getBlue());
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    public static void blackAndWhiteGreenBased(Image image){
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); i++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(color.getGreen(), color.getGreen(), color.getGreen());
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    public static void blackAndWhiteFilter(Image image){
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                int average = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                Color newColor = new Color(average, average, average);
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    public static void invertColors(Image image){
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    public static void redBand(Image image){
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(color.getRed(), 0, 0);
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    public static void greenBand(Image image){
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(0, color.getGreen(), 0);
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    public static void blueBand(Image image){
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(0, 0, color.getBlue());
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    public static void increaseTonality(Image image, int value){
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(getColorValue(color.getRed(), value), color.getGreen(), color.getBlue());
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    private static int getColorValue(int color, int value){
        if(color + value > 255){
            return 255;
        }else if(color + value < 0){
            return 0;
        }
        return color + value;
    }

    public static void binaryImage(Image image){
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));

                int media = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                int binaryValue = getBinaryValue(media);

                Color newColor = new Color(binaryValue, binaryValue, binaryValue);
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    private static int getBinaryValue(int value){
        if(value > 100){
            return 255;
        }
        return 0;
    }

    public static void increaseBright(Image image, int value){
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(getColorValue(color.getRed(), value), getColorValue(color.getGreen(), value), getColorValue(color.getBlue(), value));
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }
}

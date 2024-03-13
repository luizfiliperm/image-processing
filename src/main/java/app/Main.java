package app;

import entities.Image;
import services.ImageService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Insert the path of the image: ");
        String path = sc.nextLine();

        Image image = new Image(path);

        System.out.println("Height: " + image.getHeight());
        System.out.println("Width: " + image.getWidth());
        System.out.println("Pixels: " + image.getPixels());


        String savePath = path.substring(0, path.lastIndexOf(".")) + "_copy.jpg";

        ImageService.invertColors(image);

        ImageService.showRGBofEveryPixel(image);

        image.saveImage(savePath);

        sc.close();
    }
}
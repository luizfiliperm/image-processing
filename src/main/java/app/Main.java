package app;

import entities.Image;
import services.ColorFilter;
import util.ImageUtil;

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

        Image increaseTonality = new Image(path);
        ColorFilter.increaseTonality(image, -40);

        Image binaryImage = new Image(path);
        ColorFilter.binaryImage(binaryImage);

        Image increaseBright = new Image(path);
        ColorFilter.increaseBright(increaseBright, 40);

        ImageUtil.showImages(image, increaseTonality, binaryImage, increaseBright);

        sc.close();
    }
}
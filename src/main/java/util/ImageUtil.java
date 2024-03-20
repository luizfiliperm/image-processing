package util;

import entities.Image;

import javax.swing.*;
import java.awt.*;

public class ImageUtil {

    public static void showImages(Image... images){
        JFrame frame = new JFrame();
        frame.setTitle("Images");
        frame.getContentPane().setLayout(new FlowLayout());


        for(Image image: images){
            JLabel label = new JLabel(new ImageIcon(image.getBufferedImage()));
            frame.getContentPane().add(label);
        }

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

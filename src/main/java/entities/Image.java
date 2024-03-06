package entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    private File path;

    private int height;

    private int width;

    private int pixels;

    private BufferedImage bufferedImage;

    public Image() {
    }

    public Image(String path) throws IOException {
        this.path = new File(path);
        this.bufferedImage = readBufferedImage();
    }

    public Image(BufferedImage bufferedImage){
        this.bufferedImage = bufferedImage;
    }

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }

    public int getHeight() {
        return bufferedImage.getHeight();
    }


    public int getWidth() {
        return bufferedImage.getWidth();
    }

    public int getPixels(){
        return getHeight() * getWidth();
    }

    private BufferedImage readBufferedImage() throws IOException {
        return ImageIO.read(path);
    }

    public BufferedImage getBufferedImage(){
        return bufferedImage;
    }

    public void saveImage(String path){
        try {
            ImageIO.write(bufferedImage, "jpg", new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

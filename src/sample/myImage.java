package sample;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import java.io.File;

public class myImage extends Image {

    private  double size;
    private File file;

    public myImage(String s) {
        super(s);
        file = new File(s);
        size = this.getHeight() * this.getWidth();
    }

    public myImage(File file){
        super(file.toURI().toString());
        size = this.getHeight() * this.getWidth();
        this.file = file;
    }

    public int getSimilarityCoeff(myImage image){
        //Color color1, color2;
        System.out.println("im1 " + this.file.getName());
        System.out.println("im2" + image.file.getName());
        Color color1, color2;
        int width = (int)image.getWidth();
        int height = (int)image.getHeight();
        if(this.getHeight() < height) {height = (int)this.getHeight();}
        if(this.getWidth() < width) {width = (int)this.getWidth();}
        PixelReader reader1 = this.getPixelReader();
        PixelReader reader2 = image.getPixelReader();
        double sum = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                color1 = reader1.getColor(i,j);
                color2 = reader2.getColor(i,j);
                double diff = Math.abs(color1.getRed() - color2.getRed());
                diff += Math.abs(color1.getGreen() - color2.getGreen());
                diff += Math.abs(color1.getBlue() - color2.getBlue());
                diff = diff / 3;
                sum += diff;
            }

        }
        sum = sum / (width * height);
        System.out.println("SumDiff = " + sum);

        return 100 -  (int)(sum * 100);
    }


    @Override
    public String toString(){
        return this.getUrl();
    }

    public double getSize() {
        return size;
    }

    public File getFile() {
        return file;
    }
}

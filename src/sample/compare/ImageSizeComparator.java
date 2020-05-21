package sample.compare;

import sample.myImage;

import java.util.Comparator;

public class ImageSizeComparator implements Comparator<myImage> {
    @Override
    public int compare(myImage o1, myImage o2) {
        return (int) (o1.getSize() - o2.getSize());
    }

    @Override
    public String toString(){
        return "Compare by Size";
    }
}

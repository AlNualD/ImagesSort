package sample.compare;

import sample.myImage;

import java.util.Comparator;

public class ImageNameComparator implements Comparator<myImage> {
    @Override
    public int compare(myImage o1, myImage o2) {
        return o1.getFile().getName().compareTo(o2.getFile().getName());
    }

    @Override
    public String toString(){
        return "Compare by Name";
    }
}

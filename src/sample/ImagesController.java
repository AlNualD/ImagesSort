package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import java.io.File;
import java.util.Comparator;

public class ImagesController {
    private  ObservableList<myImage> showImages = FXCollections.observableArrayList();
    private ObservableList<myImage> allImages = FXCollections.observableArrayList();
    private ListView<myImage> listView;

    private final String defPath = "src/pictures/";
    private final String defEnd = "_pic.jpg";
    private boolean defLoad = false;

    public void sorting(Comparator<myImage> comparator){
        showImages.sort(comparator);
    }

    public void findSimilar(myImage image, int coeff){
        ObservableList<myImage> buff = FXCollections.observableArrayList();
        buff.add(image);
        for (myImage im : showImages) {
           if(im != image)
           {
              if(image.getSimilarityCoeff(im) > coeff) buff.add(im);
           }
        }
        showImages.removeAll();
        showImages.setAll(buff);
    }

    public ObservableList<myImage> getImagesList(){
        return showImages;
    }

    private void loadToListViewer(){
        System.out.println("LOAD TO VIEWER");
        Platform.runLater(()->{
            listView.setItems(showImages);
        });
    }

    public boolean isDefLoadEnabled(){
        return defLoad;
    }

    public ImagesController(ListView<myImage> listView) {
        this.listView = listView;
    }

    public void addItem(File file){
        if(file.exists())
        {
            myImage image = new myImage(file);
            allImages.add(image);
            showImages.add(image);
        }
    }

    public void returnNormalState(){
        showImages.removeAll();
        showImages.setAll(allImages);
    }

    public void defaultPicturesLoad(){
        if(isDefLoadEnabled()) return;
        defLoad = true;
        String bufPath = "";
        for (int i = 1; i < 11; i++) {
            File file = new File(defPath + i + defEnd);
            System.out.println(defPath + i + defEnd);
            addItem(file);

        }
    }
}

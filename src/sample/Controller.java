package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import sample.compare.ImageNameComparator;
import sample.compare.ImageSizeComparator;

import java.util.Comparator;

public class Controller {
   @FXML private ChoiceBox<Comparator<myImage>> orderChoiceBox;
    @FXML private ListView<myImage> picturesList;
    @FXML private ImageView pictureView;
    @FXML private Label nameLabel;
    @FXML private  Label sizeLabel;
    @FXML private Slider slider;
    private Main mainClass;
    private ImagesController imagesController;
    private ObservableList<Comparator<myImage>> comparators = FXCollections.observableArrayList( new ImageSizeComparator(), new ImageNameComparator());

    @FXML
    private void initialize(){
        imagesController = new ImagesController(picturesList);
        picturesList.setItems(imagesController.getImagesList());
        orderChoiceBox.setItems(comparators);

    }

    public void setMainClass(Main mainClass){
        this.mainClass = mainClass;
    }

    public void addButtonClicked(){
      mainClass.showAddPictureDialog(imagesController);
    }

    public void onListClick() {
        myImage image = picturesList.getSelectionModel().getSelectedItem();
        Platform.runLater(()->{
            nameLabel.setText(image.getFile().getName());
        });
        Platform.runLater(()->{
            sizeLabel.setText(String.valueOf(image.getSize()));
        });
        Platform.runLater(()->{
            pictureView.setImage(image);
        });


    }

    public void sortButtonClicked(){
        if (orderChoiceBox.getSelectionModel().isEmpty()) return;
        imagesController.sorting(orderChoiceBox.getSelectionModel().getSelectedItem());
    }

    public void findSimilarPicturesButtonClicked(){
        imagesController.findSimilar(picturesList.getSelectionModel().getSelectedItem(), (int)slider.getValue());
    }

    public void resetButtonClicked(){
        imagesController.returnNormalState();
    }




}

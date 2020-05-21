package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class addPictureDialogController {

    @FXML private TextField fileTextField;

    private Stage dialogStage;
    private ImagesController imagesController;
    private ListView<Image> pictureList;


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    public void setImagesController(ImagesController imagesController){
        this.imagesController = imagesController;
    }

    public void closeButtonClicked(){
        dialogStage.close();
    }

    public void addButtonClicked(){
        String path = fileTextField.getText();
        File file = new File(path);
        if(file.exists())
        {
            imagesController.addItem(file);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Path error");
            alert.setHeaderText("Wrong path");
            alert.setContentText("Cant find this file");
            alert.showAndWait();
        }
    }

    public void defaultButtonClicked(){
        imagesController.defaultPicturesLoad();
    }

    public void setPictureList(ListView<Image> pictureList) {
        this.pictureList = pictureList;
    }
}

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
       Parent root =  loader.load();

       Controller controller = loader.getController();
        controller.setMainClass(this);
        primaryStage.setTitle("ImagesSorting");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void showAddPictureDialog(ImagesController imagesController) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("addPictureDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add pictures");
            dialogStage.initModality(Modality.NONE);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            addPictureDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setImagesController(imagesController);
            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

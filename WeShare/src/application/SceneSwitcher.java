package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneSwitcher {
	 @FXML
	    
	private AnchorPane mainPane2;

    @FXML
    void handle2Screen(ActionEvent event) throws IOException {
    	  System.out.println("You clicked me");
    	  mainPane2 = FXMLLoader.load(getClass().getResource("LogInEntrance.fxml"));// pane you are GOING TO
          Scene scene = new Scene(mainPane2);// pane you are GOING TO show
          Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
          window.setScene(scene);
          window.show();
    }

    
}

//Samuel Shiau wbd992
//This class contains the event handlers, message displays, and more
package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import java.util.Random;
import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;
import java.net.URL;

public class MenuController implements Initializable {
	@FXML
	private AnchorPane PaneP;
	@FXML
	private AnchorPane PaneVRC;
	@FXML
	private Text messageD;
	@FXML
	private Text timeD;
	
	@FXML  //will open the posting interface when the button is clicked 
	public void clickPost(ActionEvent event)throws IOException {
		PaneP=FXMLLoader.load(getClass().getResource("Post.fxml"));   //get resource
		Scene scP=new Scene(PaneP);
		Stage winP=(Stage) ((Node)event.getSource()).getScene().getWindow();
		winP.setScene(scP);
		winP.show();   //show the stage
	}
	@FXML   // will open the view react and comment interface when the button is clicked
	public void clickViewReactComment(ActionEvent event)throws IOException{
		PaneVRC=FXMLLoader.load(getClass().getResource("ViewReactComment.fxml"));   //get resource
		Scene scVRC=new Scene(PaneVRC);
		Stage winVRC=(Stage) ((Node)event.getSource()).getScene().getWindow();
		winVRC.setScene(scVRC);
		winVRC.show();	  // show the stage
	}
	// this method will run when the menu interface is opened, it will display the message and the timer 
	public void initialize(URL location, ResourceBundle resources) {
		Random rand=new Random();
		try {
			HashMap<String,String> messageMap=new HashMap<String,String>();
			Properties MessageP=new Properties();     // create property object
			File messageF=new File("Messages.properties");   // file object
			FileInputStream fileM=new FileInputStream(messageF);  
			MessageP.load(fileM);  // load the info into the object
			
			for(String key:MessageP.stringPropertyNames()) {  // put the info into the hashmap
				String quote=MessageP.getProperty(key);
				messageMap.put(key,quote);
			}
			
			int ranKey=rand.nextInt(29)+1;   // get random values from 1-30
			String ranKeystr=Integer.toString(ranKey);
			String display=messageMap.get(ranKeystr);  // get the string to display
			messageD.setText(display);   // display the string on the interface
			long end=System.nanoTime();   //whenever the interface if opened, get the value of current time
			long time=end-Main.begin;   // end time minus start time
			long timesec=time/1000000000;   // divide to get the unit in second
			long timemin=timesec/60;    // divide to get the unit in minute
			timeD.setText("App use time: "+timemin+" minutes");   // display time in minutes
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	
	
}

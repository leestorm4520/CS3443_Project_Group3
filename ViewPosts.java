/*
 * Lisette Isais' assigned part for WeShare Project
 */

package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class ViewPosts {

	@FXML
	private Circle homeBtn;

	@FXML
	private TextArea UserName;

	@FXML
	private TextArea PostContent;

	@FXML
	private Button Next;

	@FXML
	private ListView<String> commentDisplay;

	@FXML
	private TextArea commentBox;

	@FXML
	private Button Post;

	@FXML
	private AnchorPane ViewPostsPane;

	@FXML
// initialize() will have first post displayed when scene is opened 
	public void initialize() throws IOException {
		/*
		 * File file = new File ("post.properties"); if (!(file.exists())) {
		 * file.createNewFile(); } HashMap<String, String> h=new HashMap<String,
		 * String>(); // File file=new File("post.properties"); FileInputStream
		 * reader=new FileInputStream(file); Properties properties=new Properties();
		 * 
		 * properties.load(reader); reader.close();
		 * 
		 * for(String key: properties.stringPropertyNames()){
		 * PostContent.setText(properties.get(key).toString()); h.put(key,
		 * properties.get(key).toString()); UserName.setText(key); // h.findFirst();
		 * //PostContent.setText(properties.get(key).toString()); }
		 */
		File file = new File("post.properties");
		if (!(file.exists())) {
			file.createNewFile();
		}
		HashMap<String, String> h = new HashMap<String, String>();

		FileInputStream reader = new FileInputStream(file);
		Properties properties = new Properties();

		properties.load(reader);
		reader.close();

		// while (!Next.isPressed()) {
		for (String key : properties.stringPropertyNames()) {
			h.put(key, properties.get(key).toString());
			UserName.setText(key);
			PostContent.setText(properties.get(key).toString());
		}
		// }

		/*
		 * Iterator<Entry<String, String>> postIterator = h.entrySet().iterator();
		 * while(!Next.isPressed()) { while (postIterator.hasNext()) { Map.Entry
		 * postContent = (Map.Entry)postIterator.next(); String content =
		 * (String)postContent.getValue(); String name = (String)postContent.getKey();
		 * PostContent.setText(content); UserName.setText(name); } }
		 */
	}

	// nextPost() iterates through user's posts one by one
	@FXML
	public void nextPost(ActionEvent event) throws IOException {
		File file = new File("post.properties");
		if (!(file.exists())) {
			file.createNewFile();
		}
		HashMap<String, String> h = new HashMap<String, String>();

		FileInputStream reader = new FileInputStream(file);
		Properties properties = new Properties();

		properties.load(reader);
		reader.close();

		// while (!Next.isPressed()) {
		for (String key : properties.stringPropertyNames()) {
			h.put(key, properties.get(key).toString());
			UserName.setText(key);
			PostContent.setText(properties.get(key).toString());
		}

		// }

		/* FIXME: CLEAR COMMENT BOX WHEN CHANGING TO NEXT POST */

		/*
		 * Iterator postIterator = h.entrySet().iterator();
		 * 
		 * while (postIterator.hasNext()) { Map.Entry postContent =
		 * (Map.Entry)postIterator.next(); String content =
		 * (String)postContent.getValue(); PostContent.setText(content); }
		 */
	}

	// displayComments() displays user's comments for post
	@FXML
	public void displayComments(ActionEvent event) throws IOException {
		File file = new File("comment.properties");
		if (!(file.exists())) {
			file.createNewFile();
		}
		String input = commentBox.getText();

		HashMap<String, String> h = new HashMap<String, String>();
		FileInputStream reader = new FileInputStream(file);
		Properties properties = new Properties();

		properties.load(reader);
		reader.close();
		commentDisplay.getItems().addAll(input);

		// stores items into variable "key"
		for (String key : properties.stringPropertyNames()) {
			h.put(key, properties.get(key).toString());
			commentDisplay.getItems().addAll(key, h.get(key));
			commentDisplay.getItems().addAll(input, h.get(input));
		}

		commentBox.clear();
	}

	// this method changes scenes to home
	/*
	 * public void goHome(ActionEvent event) throws IOException { inventPane =
	 * FXMLLoader.load(getClass().getResource("Main.fxml")); // pane I am going to
	 * Scene scene = new Scene(inventPane); //pane i'm going to show Stage window =
	 * (Stage) ((Node)event.getSource()).getScene().getWindow(); //pane I am on
	 * window.setScene(scene); window.show(); }
	 */

}

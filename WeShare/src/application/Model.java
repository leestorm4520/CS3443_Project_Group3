package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.regex.*;

public class Model throws IOException{
  User userInfo=new User();
  private static HashMap<String, userInfo> h=new HashMap<String, userInfo>();
  private Properties properties=new Properties();
  File file= new File("data.properties");
  Alert a=new Alert(AlertType.NONE);
  
  public boolean userFormatValidation(String id, String password){
    Pattern p=Pattern.compile("\w{8,15}"};
    Matcher m1=p.matcher(id);
    Matcher m2=p.matcher(password);
    
    if(!m1.find() || !m2.find()){
      a.setAlertType(AlertType.ERROR);
      a.setContentText("Either user id or password is not in the correct format");
      a.show();
  }
                               
  public boolean userExistenceValidation(String id, String password){
   file.createNewFile();
    FileInputStream reader=new FileInputStream(file);
    properties.load(read);
    reader.close();
    for(String object: properties.stringPropertiesName()){
      h.put(object, properties.get(object).toString());
    
    if(h.containsKey(id)){
      
    }
  }
}

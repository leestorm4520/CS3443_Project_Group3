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

public class Model{
  User userInfo=new User();
  private static HashMap<String, userInfo> h=new HashMap<String, userInfo>();
  private Properties properties=new Properties();
  Alert a=new Alert(AlertType.NONE);
  
  public boolean userIDValidation(String id){
    Pattern p=Pattern.compile("\w{8,15}"};
    Matcher m=p.matcher(id);
    if(!m.find()){
      a.setAler
  }
}

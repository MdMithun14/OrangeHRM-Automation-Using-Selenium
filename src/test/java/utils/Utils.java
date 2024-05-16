package utils;

import config.userModal;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static void  doScroll(WebDriver driver,int firstpos,int lastpos){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+firstpos+","+lastpos+")");
    }
    public  static void  saveUser(userModal modal) throws IOException, ParseException {
        String filename= "./src/test/resources/user.json";
        JSONParser jsonParser= new JSONParser();
      JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(filename));

      JSONObject jsonObject = new JSONObject();
      jsonObject.put("firstName",modal.getFirstname());
      jsonObject.put("lastName",modal.getLastname());
      jsonObject.put("empId",modal.getEmpid());
      jsonObject.put("userName",modal.getUsername());
      jsonObject.put("password",modal.getPassword());


      jsonArray.add(jsonObject);

        FileWriter writer = new FileWriter(filename);
        writer.write(jsonArray.toJSONString());
        writer.flush();
        writer.close();

    }

    public  static JSONArray getUser() throws IOException, ParseException {
        String filename= "./src/test/resources/user.json";
        JSONParser jsonParser= new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(filename));
       // JSONObject  empObj = (JSONObject) jsonArray.get(jsonArray.size() - 1);
        return jsonArray;
    }

}

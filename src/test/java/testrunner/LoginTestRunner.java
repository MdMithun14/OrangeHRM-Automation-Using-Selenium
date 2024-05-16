package testrunner;
import config.setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.Login;
import page.PIMpage;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class LoginTestRunner extends setup {
    @Test(priority = 1, description = "Admin can login sucessfully")

    public void dologin() throws IOException, ParseException {

        Login login = new Login(driver);
        Utils utils = new Utils();
        JSONArray jsonArry = utils.getUser();
        JSONObject userObj = (JSONObject) jsonArry.get(0);
        String userName = (String) userObj.get("userName");
        String password = (String) userObj.get("password");
        login.dologin(userName, password);
        WebElement imgProfile = driver.findElement(By.className("oxd-userdropdown-img"));
        Assert.assertTrue(imgProfile.isDisplayed());
    }
}
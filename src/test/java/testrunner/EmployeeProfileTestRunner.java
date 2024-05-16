package testrunner;

import config.setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.Login;
import page.PIMpage;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class EmployeeProfileTestRunner extends setup {
    @Test(priority = 1,description = "Login by newly created ueser")
    public void doEmpLogin() throws IOException, ParseException {
        Login login= new Login(driver);
        Utils utils = new Utils();
        JSONArray jsonArray = utils.getUser();
        JSONObject userObj = (JSONObject) jsonArray.get(jsonArray.size() - 1);
        String username = (String) userObj.get("userName");
        String password = (String) userObj.get("password");
        login.dologin(username,password);
        WebElement ProfileName =  driver.findElement (By.className("oxd-userdropdown-name"));
        Assert.assertTrue(ProfileName.isDisplayed());
    }
   // @Test(priority = 2)
    public void updateGender() throws InterruptedException {
        WebElement myInfo = driver.findElements(By.className("oxd-main-menu-item-wrapper")).get(2);
        myInfo.click();
       List<WebElement> title = driver.findElements(By.className("orangehrm-main-title"));
        WebElement gender = driver.findElements(By.className("oxd-radio-input")).get(1);
        gender.click();
        Utils.doScroll(driver, 0, 350);
        WebElement selectBloodIcon = driver.findElements(By.className("oxd-select-text-input")).get(1);
        selectBloodIcon.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        WebElement saveBtn = driver.findElements(By.className("oxd-button")).get(1);
        saveBtn.click();
    }

}

package testrunner;

import com.github.javafaker.Faker;
import config.setup;
import config.userModal;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.Login;
import page.PIMpage;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class PimTestRunner extends setup {
@BeforeTest
    public void dologin()  {

        Login login = new Login(driver);
        login.dologin("Admin","admin123");
        WebElement imgProfile =  driver.findElement (By.className("oxd-userdropdown-img"));
        Assert.assertTrue(imgProfile.isDisplayed());
    }
   @Test (priority = 1,description = "Create user")
    public void employeeRegister() throws InterruptedException, IOException, ParseException {
        PIMpage pimpage = new PIMpage(driver);
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userName = faker.name().username();

        String password = "Testsuer12";


        Utils.doScroll(driver,0,300);
        pimpage.regsitration(firstName,lastName,userName,password);


       List<WebElement> id = driver.findElements(By.className("oxd-input"));
       String empID = id.get(4).getAttribute("value");
       Thread.sleep(5000);
        userModal usersModel = new userModal();
        usersModel.setFirstname(firstName);
        usersModel.setLastname(lastName);
        usersModel.setEmpid(empID);
        usersModel.setUsername(userName);
        usersModel.setPassword(password);
        Utils.saveUser(usersModel);
        Thread.sleep(3000);
    }
    @Test(priority = 2, description="Search user by valid employeeId")
    public void searchUser() throws IOException, ParseException, InterruptedException {
        PIMpage piMpage = new PIMpage(driver);
        JSONArray jsonArray = Utils.getUser();
        JSONObject userObj = (JSONObject) jsonArray.get(jsonArray.size() - 1);
        String empid= (String) userObj.get("empId");
        Thread.sleep(2000);
        piMpage.searchEmpId(empid);



    }
     @Test (priority = 3,description = "search user by valid Employeename")
    public void searchEmpbyName() throws IOException, ParseException, InterruptedException {
        PIMpage piMpage = new PIMpage(driver);
        JSONArray jsonArray = Utils.getUser();
        JSONObject userObj = (JSONObject) jsonArray.get(jsonArray.size() - 1);
        String empname= (String) userObj.get("firstName");
        piMpage.searchEmpname(empname);
    }


}

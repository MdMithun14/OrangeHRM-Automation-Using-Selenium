package page;

import config.setup;
import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.util.List;

public class PIMpage extends setup {
    @FindBy (className = "oxd-main-menu-item")
    List<WebElement> menuiteams;
    @FindBy (className = "oxd-button")
    List<WebElement>  button;
    @FindBy (className = "oxd-input")
   List<WebElement>  inputfield;
//    @FindBy(className = "oxd-input ")
//    List<WebElement>emipid;
    @FindBy(className = "oxd-input")
   List<WebElement>empId ;

@FindBy(tagName = "input")
 List<WebElement> employeeName;
@FindBy(className = "oxd-select-text-input")
List<WebElement>Bloodgroup;

@FindBy(css = "[role=\"listbox\"]")
    WebElement selectRole;
    @FindBy(className = "oxd-switch-input")
    WebElement togglebutton;

    public PIMpage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void regsitration(String firstName,String lastName,String userName,String password){
        menuiteams.get(1).click();//click on pim
        button.get(2).click();//Click on add button
        togglebutton.click();
        inputfield.get(1).sendKeys(firstName);
        inputfield.get(3).sendKeys(lastName);
        inputfield.get(5).sendKeys(userName);
        inputfield.get(6).sendKeys(password);
        inputfield.get(7).sendKeys(password);
        //inputfield.get(4).sendKeys(empid);
        button.get(1).click();

    }
    public void searchEmpId(String empid){
        menuiteams.get(1).click();
        inputfield.get(1).sendKeys(empid);
        button.get(1).click();

    }
    public  void  searchEmpname(String empname) throws InterruptedException {
        menuiteams.get(8).click();
        employeeName.get(1).sendKeys(empname);
        Thread.sleep(2000);
        selectRole.click();
        button.get(1).click();
    }
    public void saveBloodgroup(){
      menuiteams.get(5).click();
      Utils.doScroll(driver,0,300);
      Bloodgroup.get(2).click();
      button.get(1).click();
    }

}

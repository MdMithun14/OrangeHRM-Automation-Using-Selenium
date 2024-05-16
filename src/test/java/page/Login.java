package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Login {
    @FindBy(name="username")
    WebElement txtusername;
    @FindBy(name="password")
    WebElement txtpassword;

    @FindBy(css ="[type=\"submit\"]")
    WebElement btnlogin;
 @FindBy(css="[role=\"menuitem\"]")
   List <WebElement> btnlogout;
@FindBy(className = "oxd-userdropdown-name")
 WebElement logedinUser;
WebDriver driver;
public Login(WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver,this);
}

public void dologin(String username,String Password){
    txtusername.sendKeys(username);
    txtpassword.sendKeys(Password);
    btnlogin.click();
}
    public void dologOut(){
        Login loginpage = new Login(driver);
        loginpage.logedinUser.click();
        loginpage.btnlogout.get(3).click();

    }

}


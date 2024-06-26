package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import page.Login;

import java.time.Duration;

public class setup {
   public WebDriver driver;
 @BeforeTest
    public void setup(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
    @AfterTest
    public void quitbrowser(){
     Login loginpage = new Login(driver);
     loginpage.dologOut();
      driver.quit();
    }

}

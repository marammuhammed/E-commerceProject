package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage {
    By UserName= new AppiumBy.ByAccessibilityId("test-Username");
    By Password= new AppiumBy.ByAccessibilityId("test-Password");
    By Login_BUTTON= new AppiumBy.ByAccessibilityId("test-LOGIN");

    By Error_Message=By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");


    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }
    public LoginPage enterUserName(String username){
        driver.findElement(UserName).sendKeys(username);
        return  this;

    }
    public LoginPage enterPassword(String password){
        driver.findElement(Password).sendKeys(password);
        return this;


    }
    public Products_Page clickOnLoginBtn(){
        driver.findElement(Login_BUTTON).click();
        return new Products_Page(driver);

    }
    public LoginPage userLogin(String username, String password){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        enterUserName(username);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        enterPassword(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clickOnLoginBtn();
        return  this;
    }

    public boolean Validation(String Message) {
        return driver.findElement(Error_Message).getText().toLowerCase().contains(Message);
    }

}

package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut_InformationPage {
    WebDriver driver;
    By FirstName = new AppiumBy.ByAccessibilityId("test-First Name");
    By LastName = new AppiumBy.ByAccessibilityId("test-Last Name");
    By ZipCode = new AppiumBy.ByAccessibilityId("test-Zip/Postal Code");
    By Continue = new AppiumBy.ByAccessibilityId("test-CONTINUE");

    public CheckOut_InformationPage(WebDriver driver) {

        this.driver = driver;
    }
    public CheckOut_InformationPage enterFirstName(String username){
        driver.findElement(FirstName).sendKeys(username);
        return  this;

    }
    public CheckOut_InformationPage enterLastName(String lastName){
        driver.findElement(LastName).sendKeys(lastName);
        return  this;

    }
    public CheckOut_InformationPage enterZipCode(String postalCode){
        driver.findElement(ZipCode).sendKeys(postalCode);
        return  this;

    }
    public CheckOut_InformationPage ClickON_ContinueBtn(){
        driver.findElement(Continue).click();
        return  this;

    }
    public void CheckOut_Form(String username, String lastName,String postalCode){
        enterFirstName(username);
        enterLastName(lastName);
        enterZipCode(postalCode);
        ClickON_ContinueBtn();

    }




}

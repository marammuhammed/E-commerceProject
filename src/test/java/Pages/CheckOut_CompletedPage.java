package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut_CompletedPage {
    WebDriver driver;
    By success_Text =By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]");


    public CheckOut_CompletedPage(WebDriver driver) {

        this.driver = driver;
    }
    public String OrderSuccess_Text(){

        return driver.findElement(success_Text).getText();
    }
    public CheckOut_CompletedPage FinishBtn(){
         driver.findElement(success_Text).click();
        return this;
    }



}

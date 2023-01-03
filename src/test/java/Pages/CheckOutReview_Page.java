package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;

public class CheckOutReview_Page {
    //WebDriver driver;
    private static WebDriver driver;
    AndroidDriver androidDriver;

    By Total_Price=By.xpath("//android.widget.TextView[@text=\"Total: $32.39\"]");
    By Finish_Btn= new AppiumBy.ByAccessibilityId("test-FINISH");
    public CheckOutReview_Page(WebDriver driver) {
        this.driver = driver;
    }

    public String Total_Price_Text(){
        return driver.findElement(Total_Price).getText();
    }
    /*public void scrollAndClick(String visibleText) {
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true). instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+
                        "\").instance(0))").click();
    }*/
    public CheckOutReview_Page Click_onFinishBTN() {
        driver.findElement(Finish_Btn).click();
        return this;
    }
}







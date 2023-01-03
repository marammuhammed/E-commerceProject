package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Cart_Page {
    WebDriver driver;
    By Added_Product_Name = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
    By Added_Product_Price = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");
    By REmove_Btn = new AppiumBy.ByAccessibilityId("test-REMOVE");
   By Cart_Icon = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");
   By Cart_Icon_Number =By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView");
    By CheckOut_Btn = new AppiumBy.ByAccessibilityId("test-CHECKOUT");

    public Cart_Page(WebDriver driver) {

        this.driver = driver;
    }

    public String checkProducted_Name() {
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(Added_Product_Name).getText().toLowerCase();

    }

    public String checkProducted_Price() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(Added_Product_Price).getText().toLowerCase();

    }

    public Cart_Page Click_onRemove() {
        driver.findElement(REmove_Btn).click();
        return this;
    }

    public String checkCartIcon() {

        return driver.findElement(Cart_Icon).getText();
    }

    public String Check_RemoveBtn() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(REmove_Btn).getText();

    }
    public CheckOut_InformationPage Click_onCheckOUT() {
        driver.findElement(CheckOut_Btn).click();
        return new CheckOut_InformationPage(driver);
    }


    public boolean validateItemsAreRemoved() {
        try {
            driver.findElement(Cart_Icon_Number);
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }
}



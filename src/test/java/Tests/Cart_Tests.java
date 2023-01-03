package Tests;

import Pages.Cart_Page;
import Pages.LoginPage;
import Pages.Products_Page;
import com.google.common.io.Files;
import com.shaft.driver.SHAFT;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Cart_Tests {
    WebDriver driver;
    SHAFT.TestData.JSON testData;

    @BeforeMethod
    public void setupDevice() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "OPPO A53");
        caps.setCapability("appium:app", "C:\\work\\Appium\\Android.SauceLabs.Mobile.Sample.app.2.2.0.apk");
        caps.setCapability("appium:appWaitActivity", "com.swaglabsmobileapp.MainActivity");
        caps.setCapability("appium:platformVersion", "11");
        caps.setCapability("appium:automationName", "UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);
        testData= new SHAFT.TestData.JSON("Data.json");
        new LoginPage(driver)
                .userLogin(testData.getTestData("userName"),testData.getTestData("Password"));
        new Products_Page(driver)
                .clickOnAddToCartButton()
                .clickOnCartIcon();
    }
    @Test
    public void checkAddToCart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       String check_AddedProduct_ByName= new Cart_Page(driver)
                                        .checkProducted_Name();
        String check_AddedProduct_ByPrice= new Cart_Page(driver)
                                        .checkProducted_Price();
        Assert.assertEquals(check_AddedProduct_ByName,"sauce labs backpack");
        Assert.assertEquals(check_AddedProduct_ByPrice,"$29.99");
    }
    @Test
    // check if the Item is removed successfully & cart page is Empty by checking cart Icon is Disappeared
    public void check_Cart_is_empty() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        boolean Cart_is_Empty=  new Cart_Page(driver)
                                .Click_onRemove()
                                 .validateItemsAreRemoved();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Cart_is_Empty);
        softAssert.assertAll();
        new Cart_Page(driver).Click_onCheckOUT();






    }
    //Attaching a screenshot to the report
    @AfterMethod
    public void takeScreenshot(ITestResult result) throws IOException {
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        File newScreenShot = new File("src/main/resources/screenshots/" + result.getName() + ".png");
        Files.move(screenshot, newScreenShot);
        Allure.addAttachment(result.getName(), new FileInputStream(newScreenShot));
    }



}

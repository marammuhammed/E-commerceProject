package Tests;

import Pages.LoginPage;
import Pages.Products_Page;
import com.google.common.io.Files;
import com.shaft.driver.SHAFT;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Products_tests {
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
        testData= new SHAFT.TestData.JSON("Data.json");
        driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);
                        new LoginPage(driver)
                         .userLogin(testData.getTestData("userName"), testData.getTestData("Password"));

    }

// Add cart to item by clicking on Add to cart button & click on cart icon to view product
    @Test
    public void AddToCart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                      new Products_Page(driver)
                         .clickOnAddToCartButton()
                         .clickOnCartIcon();
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

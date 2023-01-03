package Tests;

import Pages.Cart_Page;
import Pages.CheckOut_InformationPage;
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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CheckOut_InformationTests {
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
                .userLogin(testData.getTestData("userName"), testData.getTestData("Password"));
        new Products_Page(driver)
                .clickOnAddToCartButton()
                .clickOnCartIcon();
        new Cart_Page(driver)
                .Click_onCheckOUT();

    }
    // enter the required data to fill form by Externalizing test data (jason file)
    @Test
    public void CheckOut_Information() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        new CheckOut_InformationPage(driver)
                .enterFirstName(testData.getTestData("Firstname"))
                .enterLastName(testData.getTestData("Secondname"))
                .enterZipCode(testData.getTestData("zipCode"))
                .ClickON_ContinueBtn();

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

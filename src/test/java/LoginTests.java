import Pages.LoginPage;
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

public class LoginTests {
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
    }
    // enter the required data for login by Externalizing test data (jason file)(valid data)
    @Test
    public void Loginsuccess(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      String Login_Success=  new LoginPage(driver)
                .enterUserName(testData.getTestData("userName"))
                .enterPassword(testData.getTestData("Password"))
                .clickOnLoginBtn()
              .Check_Login();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(Login_Success,"PRODUCTS");

    }
    // enter the required data for login by Externalizing test data (jason file)(invalid data)
    @Test
    public void LoginFail(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                             new LoginPage(driver)
                            .enterUserName(testData.getTestData("userName2"))
                             .enterPassword(testData.getTestData("Password"))
                              .clickOnLoginBtn();
        boolean Login_fail = new LoginPage(driver)
                                .Validation("locked out");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Login_fail);
        softAssert.assertAll();

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



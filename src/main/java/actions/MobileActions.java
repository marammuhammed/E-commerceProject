//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package actions;

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

public class MobileActions {
    private static WebDriver driver;

    public MobileActions(WebDriver driver) {
        MobileActions.driver = driver;
    }

    public static void scrollDownToSpecificText(String text) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(0))"));
    }

    public static void scrollDownToSpecificTextContained(String text) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))"));
    }

    private static void swipeRightOnElement(WebElement element, WebDriver driver) {
        Point point = element.getLocation();
        Dimension eleSize = element.getSize();
        int centerX = driver.manage().window().getSize().width / 2;
        int centerY = point.getY() + eleSize.getHeight() / 2;
        int moveToX = driver.manage().window().getSize().width / 2;
        int moveToY = point.getY() + eleSize.getHeight() / 2;
        System.out.println("centerX :" + centerX);
        System.out.println("moveToX :" + centerX * 8 / 5);
        System.out.println("moveToY :" + moveToY);
        (new TouchAction((PerformsTouchActions)driver)).press(PointOption.point(centerX, centerY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000L))).moveTo(PointOption.point(centerX * 8 / 5, moveToY)).release().perform();
    }

    public static void swipeRightOnElement(By element, WebDriver driver) {
        swipeRightOnElement(driver.findElement(element), driver);
    }

    private static void swipeLeftOnElement(WebElement element, WebDriver driver) {
        Point point = element.getLocation();
        Dimension eleSize = element.getSize();
        int centerX = driver.manage().window().getSize().width / 2;
        int centerY = point.getY() + eleSize.getHeight() / 2;
        int moveToX = driver.manage().window().getSize().width / 2;
        int moveToY = point.getY() + eleSize.getHeight() / 2;
        System.out.println("centerX :" + centerX);
        System.out.println("moveToX :" + centerX * 1 / 5);
        System.out.println("moveToY :" + moveToY);
        (new TouchAction((PerformsTouchActions)driver)).press(PointOption.point(centerX, centerY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000L))).moveTo(PointOption.point(centerX * 1 / 5, moveToY)).release().perform();
    }

    public static void swipeLeftOnElement(By element) {
        swipeLeftOnElement(driver.findElement(element), driver);
    }
}

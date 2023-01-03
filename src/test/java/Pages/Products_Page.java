package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Products_Page {
    WebDriver driver;


    By Product_Page =By.xpath("//android.widget.TextView[@text='PRODUCTS']");
   // By Product_Name = By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]");
   // By Product_Price = By.xpath("(//android.widget.TextView[@content-desc=\"test-Price\"])[1]");
    By AddToCart_Btn= By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView");
    By Cart_Icon =By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");
    By Remove_Btn=By.xpath("//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]/android.widget.TextView");


    public Products_Page(WebDriver driver) {

        this.driver = driver;
    }

    public String Check_Login() {

        return driver.findElement(Product_Page).getText();
    }
    public Products_Page clickOnAddToCartButton(){

        driver.findElement(AddToCart_Btn).click();
        return this;
    }
  /*  public String checkRemove(){
        return driver.findElement(Remove_Btn).getText().toLowerCase();
    }
    public boolean checkCartIcon(String icon){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(Cart_Icon).getText().toLowerCase().contains(icon);
    }*/


    public Cart_Page clickOnCartIcon(){

        driver.findElement(Cart_Icon).click();
        return new Cart_Page(driver);
    }

}


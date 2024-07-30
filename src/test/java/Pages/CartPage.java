package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage {

    WebDriver driver;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Your Cart')]")
    WebElement yourCart_xpath;

    @FindBy(xpath = "//a[@class='shopping_cart_link'][contains(.,'2')]")
    WebElement clickShoppingCart_xpath;

    @FindBy(xpath = "//button[contains(@id,'checkout')]")
    WebElement checkOut_xpath;

    public void verifyYourCart(){
        String yourCart = yourCart_xpath.getText();
        Assert.assertEquals(yourCart, "Your Cart");
    }

    public void verifyProductsAddToCart(){
        int numberOfProducts = Integer.parseInt(clickShoppingCart_xpath.getText());
        Assert.assertNotEquals(numberOfProducts,0);
    }

    public void checkOutBtn(){
        checkOut_xpath.click();
    }

}
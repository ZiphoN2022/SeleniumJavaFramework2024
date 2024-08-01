package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Products')]")
    WebElement productTitle_xpath;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement AddToCartButton_Id;

    @FindBy(xpath = "//a[@class='shopping_cart_link'][contains(.,'1')]")
    WebElement ItemInCart_xpath;

    @FindBy(xpath = "//span[contains(@class,'shopping_cart_badge')]")
    WebElement CartTrolley_xpath;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProductTitleIsDisplayed() {

        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(productTitle_xpath));
        String productTitle = productTitle_xpath.getText();
        Assert.assertEquals(productTitle, "Products");
    }
    public void clickButtonAddToCart() {
        AddToCartButton_Id.click();
    }
    public void verifyItemWasAddedToTheCart()
    {
        int NoOfItemsInTheCart = Integer.parseInt(ItemInCart_xpath.getText());

        if(NoOfItemsInTheCart>0)
        {
            CartTrolley_xpath.click();
            System.out.println("1 Item is added to the cart.");
        }
        else {
            System.out.println("The cart is empty.");
        }
    }

}


package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Products')]")
    WebElement productTitle_xpath;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-backpack')]")
    WebElement addLabsBackpack_xpath;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-bike-light')]")
    WebElement addLabsBikeLight_xpath;

    @FindBy(xpath = "//a[@class='shopping_cart_link'][contains(.,'2')]")
    WebElement clickShoppingCart_xpath;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProductTitleIsDisplayed() {

        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(productTitle_xpath));
        String productTitle = productTitle_xpath.getText();
        Assert.assertEquals(productTitle, "Products");
    }

    public void addProducts(){
        addLabsBackpack_xpath.click();
        addLabsBikeLight_xpath.click();
    }

    public void verifyProductsAddToCart(){
        int numberOfProducts = Integer.parseInt(clickShoppingCart_xpath.getText());
        Assert.assertNotEquals(numberOfProducts,0);

    }

    public void navigateToShoppingCart(){
        clickShoppingCart_xpath.click();
    }


}

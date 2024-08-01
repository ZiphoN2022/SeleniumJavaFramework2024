package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductsPage {

    WebDriver driver;

    @FindBy(xpath = "//a[contains@class,'shopping_cart_link')]")
    WebElement cartLink_xpath;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Products')]")
    WebElement productTitle_xpath;

    @FindBy(xpath = "//span[contains(@data-test,'shopping-cart-badge')]")
    WebElement shoppingCartIcon_xpath;


    public ProductsPage(WebDriver driver){
        this.driver=driver;
    }

    public void addItemToCart(String product){
        driver.findElement(By.id(product)).click();
    }
    public void clickShoppingCartLink(){
        cartLink_xpath.click();
    }
    public void verifyProductTitleIsDisplaying(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(productTitle_xpath));
        String productTitle = productTitle_xpath.getText();
        Assert.assertEquals(productTitle, "Products");
    }

    public void validateItemIsAddedToCart(String itemCount){
        String cartBadgeItemCount = shoppingCartIcon_xpath.getText();
        Assert.assertEquals();
    }




}

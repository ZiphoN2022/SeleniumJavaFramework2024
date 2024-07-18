package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
    WebElement cartLink_xpath;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addItemToCart(String product) {
        driver.findElement(By.id(product)).click();
    }

    public void clickShoppingCartLink(){
        cartLink_xpath.click();
    }
}

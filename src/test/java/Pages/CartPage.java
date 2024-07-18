package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage {

    WebDriver driver;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkout_xpath;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    WebElement continueShopping_xpath;

    public CartPage(WebDriver driver){this.driver=driver;}

    public  void removeProductFromShoppingCart(String product){
        driver.findElement(By.id(product)).click();
    }

    public  void clickCheckoutButton(){
        checkout_xpath.click();
    }

    public void clickContinueShoppingButton(){
        continueShopping_xpath.click();
    }
}

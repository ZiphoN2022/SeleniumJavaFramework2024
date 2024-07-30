package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(@data-test,'add-to-cart-sauce-labs-backpack')]")
    WebElement backPack_xpath;
    @FindBy(xpath = "//button[contains(@data-test,'add-to-cart-sauce-labs-bolt-t-shirt')]")
    WebElement boltTshirt_xpath;
    @FindBy(xpath = "//a[@class='shopping_cart_link'][contains(.,'2')]")
    WebElement cart_xpath;
    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]")
    WebElement backPackInCart_xpath;
    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Bolt T-Shirt')]")
    WebElement boltTshirtInCart_xpath;
    @FindBy(xpath = "//button[contains(@id,'checkout')]")
    WebElement checkOut_xpath;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBackPack() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(backPack_xpath));
        backPack_xpath.isDisplayed();
        backPack_xpath.click();

    }
    public void addBoltTshirt(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(boltTshirt_xpath));
        boltTshirt_xpath.isDisplayed();
        boltTshirt_xpath.click();
    }
    public void clickCart(){
        cart_xpath.click();
    }

    public void verifyCartItems(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(backPackInCart_xpath));
        backPackInCart_xpath.isDisplayed();
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(boltTshirtInCart_xpath));
        boltTshirtInCart_xpath.isDisplayed();
    }
    public void goToCheckout(){
        checkOut_xpath.click();
    }

}

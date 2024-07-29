package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class CartPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]")
    WebElement inventoryItems_xpath;

    public CartPage (WebDriver driver){
        this.driver=driver;

        public void verifyYourItemDisplays() {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(inventoryItems_xpath));
            String InventoryItems=inventoryItems_xpath.getText();
            Assert.assertEquals(ActualResults, "inventoryItems");
        }
    }
}

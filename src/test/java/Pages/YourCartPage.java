package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class YourCartPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]")
    WebElement YourProductDescription_xpath;

    @FindBy(id = "checkout")
    WebElement CheckoutButton_id;



    public YourCartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void verifyYourCart()
    {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(YourProductDescription_xpath));
        String Yourcarttitle = YourProductDescription_xpath.getText();
        Assert.assertEquals(Yourcarttitle,"Sauce Labs Backpack");
    }
    public void clickButtonCheckout()
    {
        CheckoutButton_id.click();
    }

}

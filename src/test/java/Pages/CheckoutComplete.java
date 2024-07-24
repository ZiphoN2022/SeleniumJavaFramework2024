package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutComplete {

    public WebDriver driver;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Complete!')]")
    WebElement checkoutCompleteTitle_xpath;

    @FindBy(xpath = "//h2[@class='complete-header'][contains(.,'Thank you for your order!')]")
    WebElement thankYouText_xpath;

    @FindBy(id = "back-to-products")
    WebElement backToProductButton_xpath;


    public CheckoutComplete(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCheckoutCompleteTitle() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(checkoutCompleteTitle_xpath));
        String checkoutCompleteTitle = checkoutCompleteTitle_xpath.getText();
        Assert.assertEquals(checkoutCompleteTitle, "Checkout: Complete!");
    }

    public void clickBackHomeButton() {
        backToProductButton_xpath.click();
    }

    public void verifyThankYouText() {
        String thankYouText = thankYouText_xpath.getText();
        Assert.assertEquals(thankYouText, "Thank you for your order!");
    }
}

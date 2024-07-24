package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPageStepTwo {

    public WebDriver driver;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Overview')]")
    WebElement checkoutOverviewTitle_xpath;

    @FindBy(id = "cancel")
    WebElement cancelButton_xpath;

    @FindBy(id = "finish")
    WebElement finishButton_xpath;


    public CheckoutPageStepTwo(WebDriver driver) {
        this.driver = driver;
    }


    public void verifyCheckoutOverviewTitle() {

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(checkoutOverviewTitle_xpath));
        String checkoutOverviewTitle = checkoutOverviewTitle_xpath.getText();
        Assert.assertEquals(checkoutOverviewTitle, "Checkout: Overview");
    }

    public void clickFinishButton(){
        finishButton_xpath.click();
    }

    public  void clickCancelButton(){
        cancelButton_xpath.click();
    }
}

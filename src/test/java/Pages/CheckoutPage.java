package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPage {

    public WebDriver driver;

    @FindBy(id = "first-name")
    WebElement firstName_id;

    @FindBy(id = "last-name")
    WebElement lastName_id;

    @FindBy(id = "postal-code")
    WebElement postalCode_id;

    @FindBy(id = "continue")
    WebElement continueButton_id;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Your Information')]")
    WebElement checkoutTitle_xpath;

    @FindBy(id = "cancel")
    WebElement cancelButton_id;

    public void CartPage(WebDriver driver){this.driver = driver;}

    public void enterFirstName(String firstName){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(firstName_id));
        firstName_id.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastName_id.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode){
        postalCode_id.sendKeys(postalCode);
    }

    public void clickContinueButton(){
        continueButton_id.click();
    }

    public void clickCancelButton(){
        cancelButton_id.click();
    }

    public  void verifyCheckoutTitle(){
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(checkoutTitle_xpath));
        String checkoutTitle = checkoutTitle_xpath.getText();
        Assert.assertEquals(checkoutTitle, "Checkout: Your Information");
    }
}

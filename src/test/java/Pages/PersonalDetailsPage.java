package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PersonalDetailsPage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(.,'Checkout: Your Information')]")
    WebElement YourInformationPage_xpath;

    @FindBy(id = "first-name")
    WebElement Firstname_id;

    @FindBy(id = "last-name")
    WebElement Lastname_id;

    @FindBy(id = "postal-code")
    WebElement Postalcode_id;

    public PersonalDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void CheckoutYourInformation()
    {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(YourInformationPage_xpath));
        String YourInformation = YourInformationPage_xpath.getText();
        Assert.assertEquals(YourInformation,"Checkout: Your Information");
    }
    public void EnterFirstName(String firstname)
    {
        Firstname_id.clear();
        Firstname_id.sendKeys(firstname);
    }
    public void EnterLastName(String lastname)
    {
        Lastname_id.clear();
        Lastname_id.sendKeys(lastname);
    }
    public void EnterZipCode(String zipcode)
    {
        Postalcode_id.clear();
        Postalcode_id.sendKeys(zipcode);
    }
}

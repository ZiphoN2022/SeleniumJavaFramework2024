package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static Utils.generateTestData.*;
import static java.lang.Thread.sleep;

public class CheckOutInformationPage {
    WebDriver driver;
    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Your Information')]")
    WebElement checkOutTitle_xpath;
    @FindBy(xpath = "//input[contains(@id,'first-name')]")
    WebElement firstName_xpath;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastName_xpath;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement zipcode_xpath;
    @FindBy(xpath = "//input[@name='continue']")
    WebElement continueButton_xpath;

    public CheckOutInformationPage(WebDriver driver) {
        this.driver = driver;
    }
    public void verifyCheckOutTitleIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(checkOutTitle_xpath));
        String checkOutTitle = checkOutTitle_xpath.getText();
        Assert.assertEquals(checkOutTitle, "Checkout: Your Information");
    }
    public void enterFirstname() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(firstName_xpath));
        firstName_xpath.clear();
        firstName_xpath.sendKeys(firstName);
        sleep(3000);
    }

    public void enterLastName() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(lastName_xpath));
        lastName_xpath.clear();
        lastName_xpath.sendKeys(lastName);
        sleep(3000);
    }

    public void enterZipcode() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(zipcode_xpath));
        zipcode_xpath.clear();
        zipcode_xpath.sendKeys(zipcode);
        sleep(3000);
    }
    public void clickContinue() throws InterruptedException {
        continueButton_xpath.click();
        sleep(3000);
    }
}

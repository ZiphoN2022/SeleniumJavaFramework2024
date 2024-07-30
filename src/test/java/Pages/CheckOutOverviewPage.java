package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static Pages.TaxCalculator.calculateTaxPercentage;
import static java.lang.Thread.sleep;

public class CheckOutOverviewPage {
    static WebDriver driver;
    @FindBy(xpath = "//span[contains(.,'Checkout: Overview')]")
    WebElement checkOutOverview_xpath;
    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]")
    static WebElement backPackInOverview_xpath;
    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Bolt T-Shirt')]")
    static WebElement boltTshirtInOverview_xpath;


    public CheckOutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCheckOutIsDisplayed() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(checkOutOverview_xpath));
        String checkOutOverviewPage = checkOutOverview_xpath.getText();
        Assert.assertEquals(checkOutOverviewPage, "Checkout: Overview");
        sleep(3000);
    }

    public void verifyCartItemsMatchOverviewItems() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(backPackInOverview_xpath));
        backPackInOverview_xpath.isDisplayed();
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(boltTshirtInOverview_xpath));
        boltTshirtInOverview_xpath.isDisplayed();
    }
//Incomplete
}
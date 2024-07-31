package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import static java.lang.Thread.sleep;

public class CheckOutOverviewPage {
    static WebDriver driver;
    @FindBy(xpath = "//span[contains(.,'Checkout: Overview')]")
    WebElement checkOutOverview_xpath;
    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]")
    static WebElement backPackInOverview_xpath;
    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Bolt T-Shirt')]")
    static WebElement boltTshirtInOverview_xpath;

    @FindBy(xpath = "//div[@class='summary_subtotal_label'][contains(.,'Item total: $45.98')]")
    static WebElement itemTotal_xpath;
    @FindBy(xpath = "//div[@class='summary_tax_label'][contains(.,'Tax: $3.68')]")
    static WebElement taxTotal_xpath;
    @FindBy(xpath = "//div[@class='summary_total_label'][contains(.,'Total: $49.66')]")
    static WebElement totalPrice_xpath;

    @FindBy(xpath = "//button[contains(@id,'finish')]")
    static WebElement finishButton_xpath;
    @FindBy(xpath = "//button[contains(@id,'cancel')]")
    static WebElement cancelButton_xpath;
    @FindBy(xpath = "//h2[@class='complete-header'][contains(.,'Thank you for your order!')]")
    static WebElement orderDispatched_xpath;
    @FindBy(xpath = "//button[contains(@id,'react-burger-menu-btn')]")
    static WebElement burgerMenu_xpath;
    @FindBy(xpath = "//a[contains(@id,'link')][@class='bm-item menu-item'][contains(.,'Logout')]")
    static WebElement logoutButton_xpath;
    @FindBy(xpath = "//div[@class='login_logo'][contains(.,'Swag Labs')]")
    static WebElement homePage_xpath;

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
    public void verifyItemTotalPlusTaxEqualsFinalTotal() throws InterruptedException {
        String itemTotal = itemTotal_xpath.getText();
        double itemT = Double.parseDouble(itemTotal.replaceAll("[^0-9.]", ""));
        System.out.println(itemT);
        String itemTax = taxTotal_xpath.getText();
        double itemTx = Double.parseDouble(itemTax.replaceAll("[^0-9.]", ""));
        System.out.println(itemTx);
        String totalPrice = totalPrice_xpath.getText();
        double totalP = Double.parseDouble(totalPrice.replaceAll("[^0-9.]", ""));
        System.out.println(totalP);

        if (totalP == (itemTx + itemT)) {
            finishButton_xpath.click();
            Thread.sleep(5000);
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(orderDispatched_xpath));
            orderDispatched_xpath.isDisplayed();
            String thanksforshopping = driver.findElement(By.xpath("//h2[@class='complete-header'][contains(.,'Thank you for your order!')]")).getText();
            Assert.assertEquals(thanksforshopping,"Thank you for your order!");
            Thread.sleep(5000);
            System.out.println("Shopping is Completed!!.");
        } else {
            System.out.println("Go back to fix cart items.");
            cancelButton_xpath.click();
            Thread.sleep(5000);
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(burgerMenu_xpath));
            burgerMenu_xpath.isDisplayed();
            burgerMenu_xpath.click();
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(logoutButton_xpath));
            logoutButton_xpath.isDisplayed();
            logoutButton_xpath.click();
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(homePage_xpath));
            homePage_xpath.isDisplayed();
            System.out.println("Back to Home Page.");
        }



    }





}
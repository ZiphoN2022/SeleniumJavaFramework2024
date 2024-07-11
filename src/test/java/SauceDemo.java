import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.openqa.selenium.JavascriptExecutor;

import static org.openqa.selenium.By.*;

public class SauceDemo {

    WebDriver driver;

    // this is the test method

    private static final DecimalFormat decfor = new DecimalFormat("0.00");

    @Test
    public void loginTests() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/"); // This line start the browser
        driver.findElement(id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(id("login-button")).click();
        Thread.sleep(2000);
        String ProductsPage = driver.findElement(xpath("//span[contains(.,'Products')]")).getText();
        Assert.assertEquals(ProductsPage, "Products");
       /* JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('style', 'background:blue')",ProductsPage );
*/
        Thread.sleep(4000);


        //Add Items to cart
        driver.findElement(id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(id("add-to-cart-sauce-labs-bike-light")).click();


       /* //go to cart
        String CartPage;
        CartPage = driver.findElement(By.xpath("//a[contains(@class,'shopping_cart_link')]")).getText();
*/

        driver.findElement(By.id("shopping_cart_container")).click();
        //Assert.assertEquals(CartPage, "Your Cart");
        Thread.sleep(4000);


        //checkout
        driver.findElement(id("checkout")).click();

        //Enter Info
        driver.findElement(id("first-name")).click();
        driver.findElement(id("first-name")).sendKeys("@HumanR");
        Thread.sleep(1000);
        driver.findElement(id("last-name")).click();
        driver.findElement(id("last-name")).sendKeys("Earthling_T");
        Thread.sleep(1000);
        driver.findElement(id("postal-code")).click();
        driver.findElement(id("postal-code")).sendKeys("12");
        Thread.sleep(1000);
        driver.findElement(id("continue")).click();


        String SummaryPage = driver.findElement(By.xpath("//span[@class='title'][contains(.,'Checkout: Overview')]")).getText();
        Assert.assertEquals(SummaryPage, "Checkout: Overview");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('style', 'background:blue')", SummaryPage);
        Thread.sleep(4000);

        String ActualSubTotal = driver.findElement(By.xpath("//div[contains(@class,'summary_subtotal_label')]")).getText();

        Double ActualSubTotalConverted = Double.parseDouble(ActualSubTotal.substring(13));

        Double Tax = 0.08;

        Double ActualSubTotalWithTax = (ActualSubTotalConverted + (ActualSubTotalConverted * Tax));

        //Check If Summary Total is not null
        String ActualSummary_total_label = driver.findElement(By.xpath("//div[contains(@class,'summary_total_label')]")).getText();
        Double ActualSummary_total_labelConveted = Double.parseDouble(ActualSummary_total_label.substring(8));


        Assert.assertEquals(decfor.format(ActualSummary_total_labelConveted), decfor.format(ActualSubTotalWithTax));
        Thread.sleep(2000);


        //Click on finish button
        driver.findElement(By.id("finish")).click();
        Thread.sleep(1000);

        //Check Thank you landing page
        String ActualThankYouOrder = driver.findElement(By.xpath("//h2[@class='complete-header'][contains(.,'Thank you for your order!')]")).getText();
        Assert.assertEquals(ActualThankYouOrder, "Thank you for your order!");
        Thread.sleep(1000);

        //Back to products' button
        driver.findElement(By.id("back-to-products")).click();
        Thread.sleep(1000);

        // Burger menu button
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(1000);

        //Logout
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(2000);


    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}


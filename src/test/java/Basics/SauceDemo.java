package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SauceDemo {

    WebDriver driver;

    // this is the test method
    @Test
    public void loginTests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/"); // This line start the browser
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String ActualResults = driver.findElement(By.xpath("//span[contains(.,'Products')]")).getText();
        Thread.sleep(2000);
        Assert.assertEquals(ActualResults, "Products");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("shopping_cart_container")).click();

        Thread.sleep(2000);
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("More");
        driver.findElement(By.id("last-name")).sendKeys("Clara");
        driver.findElement(By.id("postal-code")).sendKeys("7700");
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("finish")).click();


        //ToDo create the coe to cater for the rest of the journey

    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}

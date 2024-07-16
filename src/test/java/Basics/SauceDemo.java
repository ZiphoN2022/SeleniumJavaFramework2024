package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class SauceDemo {

    WebDriver driver;


    @Test(priority=1)
    public void loginTests() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/"); // This line start the browser

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String ActualResults = driver.findElement(By.xpath("//span[contains(.,'Products')]")).getText();
        Assert.assertEquals(ActualResults, "Products");

    }

    @Test(priority = 2)
    public void addItem() {

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        String cartItemNumber = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(cartItemNumber, "4");

    }

    @Test(priority = 3)
    public void removeItem() {

        driver.findElement(By.id("remove-sauce-labs-bike-light")).click(); // removing an item

        Thread.sleep(2000);
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Mahadi");
        driver.findElement(By.id("last-name")).sendKeys("New");
        driver.findElement(By.id("postal-code")).sendKeys("2188");
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("finish")).click();


        //ToDo create the coe to cater for the rest of the jurney

    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}

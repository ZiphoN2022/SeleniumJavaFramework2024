import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SauceDemo {

    WebDriver driver;

    // this is the test method
    @Test
    public void loginTests() throws InterruptedException {
        driver = new ChromeDriver();
//        driver= new FirefoxDriver();
//        driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/"); // This line start the browser
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000) ;
        String ActualResults = driver.findElement(By.xpath("//span[contains(.,'Products')]")).getText();
        Assert.assertEquals(ActualResults, "Products");

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();

        String ActualResultsCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        Assert.assertEquals(ActualResultsCart,"Sauce Labs Backpack");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='checkout']")).click();
        Thread.sleep(2000);

        //String ActualCheckOut = driver.findElement(By.xpath("//*[@id=header_container']/div[2]/span")).getText();
        //Assert.assertEquals(ActualCheckOut,"Checkout: Your Information");

        driver.findElement(By.xpath("//*[@id='first-name']")).sendKeys("Mpho");
        driver.findElement(By.xpath("//*[@id='last-name']")).sendKeys("Mavhungu");
        driver.findElement(By.xpath("//*[@id='postal-code']")).sendKeys("2090");
        driver.findElement(By.xpath("//*[@id='continue']")).click();
        Thread.sleep(2000);

        String ActualOverView = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(ActualOverView,"Checkout: Overview");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='finish']")).click();
        Thread.sleep(2000);

        String ActualThankYou = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
        Assert.assertEquals(ActualThankYou,"Thank you for your order!");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='back-to-products']")).click();
        Thread.sleep(2000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}

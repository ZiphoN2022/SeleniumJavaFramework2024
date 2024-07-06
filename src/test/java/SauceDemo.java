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
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String ActualResults = driver.findElement(By.xpath("//span[contains(.,'Products')]")).getText();
        Assert.assertEquals(ActualResults, "Products");
        Thread.sleep(2000);
        //ToDo create the code to cater for the rest of the journey


        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(.,'1')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Nomhle");
        Thread.sleep(2000);
        driver.findElement(By.id("last-name")).sendKeys("Mazibuko");
        Thread.sleep(2000);
        driver.findElement(By.id("postal-code")).sendKeys("2012");
        Thread.sleep(2000);
        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("back-to-products")).click();


    }

    @AfterTest
    public void closeBrowser() {
        // driver.quit();
    }
}

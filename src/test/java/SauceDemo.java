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

    // this is the testm ethod
    @Test
    public void loginTests() {
        driver = new ChromeDriver();
//        driver= new FirefoxDriver();
//        driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/"); // This line start the browser
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String ActualResults = driver.findElement(By.xpath("//span[contains(.,'Products')]")).getText();
        Assert.assertEquals(ActualResults, "Products");

        //ToDo create the coe to cater for the rest of the jurney

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}

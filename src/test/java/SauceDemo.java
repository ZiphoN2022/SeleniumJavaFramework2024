import io.github.bonigarcia.wdm.WebDriverManager;
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

        String cartItemNumber = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(cartItemNumber, "3");

        driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a")).click(); // click the shopping cart

        driver.findElement(By.id("checkout")).click(); // checkout to the payment page

    }

    @Test(priority = 4)
    public void checkOutStepOne() {

        String checkoutHeaderTitle = driver.findElement(By.xpath("//span[@class='title'][contains(.,'Checkout: Your Information')]")).getText();
        Assert.assertEquals(checkoutHeaderTitle, "Checkout: Your Information");

        driver.findElement(By.id("first-name")).sendKeys("Shepherd");
        driver.findElement(By.id("last-name")).sendKeys("Gwasira");
        driver.findElement(By.id("postal-code")).sendKeys("2180");

        driver.findElement(By.id("continue")).click();

    }


    @Test(priority = 5)
    public void checkOutStepTwo() {

        String cardCode = driver.findElement(By.xpath("//div[@id='checkout_summary_container']/div/div[2]/div[2]")).getText();
        Assert.assertEquals(cardCode, "SauceCard #31337");

        String firstItemQty = driver.findElement(By.xpath("//div[@class='cart_quantity'][contains(.,'1')]")).getText();
        Assert.assertEquals(firstItemQty, "1");

        driver.findElement(By.id("finish")).click();


    }

    @Test(priority = 6)
    public void checkOutComplete() {

        String thankText = driver.findElement(By.xpath("//div[@id='checkout_complete_container']/h2")).getText();
        Assert.assertEquals(thankText, "Thank you for your order!");

        driver.findElement(By.id("back-to-products")).click();


    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}

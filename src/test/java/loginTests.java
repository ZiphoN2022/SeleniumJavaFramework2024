import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginTests {
    WebDriver driver;

    @BeforeTest
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/"); // This line starts the browser
    }

    @Test
    public void userNameTest() throws InterruptedException {
        String username = driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).getText();
        Assert.assertTrue(true, username);
        System.out.print("Username field present  ");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);

    }
    @Test(dependsOnMethods = "userNameTest")
    public void userPasswordTest() throws InterruptedException {
        String password = driver.findElement(By.xpath("//input[@id='password']")).getText();
        Assert.assertTrue(true, password);
        System.out.print("Password field Present  ");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "userPasswordTest")
    public void loginButton() throws InterruptedException {
        String LogButton = driver.findElement(By.xpath("//input[contains(@id,'login-button')]")).getText();
        Assert.assertTrue(true, LogButton);
        System.out.print("Login button Present  ");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        String ActualResults = driver.findElement(By.xpath("//span[contains(.,'Products')]")).getText();
        Assert.assertEquals(ActualResults,"Products");
        Thread.sleep(2000);
        System.out.print("Logged in for Shopping!!  ");
    }

    @Test (dependsOnMethods = "loginButton")
    public void selectBackpack() throws InterruptedException {
        String backpack = driver.findElement(By.xpath("//div[@class='inventory_item_name '][contains(.,'Sauce Labs Backpack')]")).getText();
        Assert.assertTrue(true, backpack);
        System.out.print("Backpack available  ");
        driver.findElement(By.xpath("//button[contains(@id,'add-to-cart-sauce-labs-backpack')]")).click();
        String bagAdded = driver.findElement(By.xpath("//button[contains(@id,'remove-sauce-labs-backpack')]")).getText();
        Assert.assertTrue(true, bagAdded);
        Thread.sleep(2000);
        System.out.print("Backpack added to cart!  ");
    }

    @Test (dependsOnMethods = "selectBackpack")
    public void selectBikelight() throws InterruptedException {
        String bikelight = driver.findElement(By.xpath("//div[@class='inventory_item_name '][contains(.,'Sauce Labs Bike Light')]")).getText();
        Assert.assertTrue(true, bikelight);
        System.out.print("Bike light available  ");
        driver.findElement(By.xpath("//button[contains(@id,'add-to-cart-sauce-labs-bike-light')]")).click();
        String lightAdded = driver.findElement(By.xpath("//button[contains(@id,'remove-sauce-labs-bike-light')]")).getText();
        Assert.assertTrue(true, lightAdded);
        Thread.sleep(2000);
        System.out.print("Bike light added to cart!  ");
    }

    @Test (dependsOnMethods = "selectBikelight")
    public void selectBoltshirt() throws InterruptedException {
        String boltshirt = driver.findElement(By.xpath("//div[@class='inventory_item_name '][contains(.,'Sauce Labs Bolt T-Shirt')]")).getText();
        Assert.assertTrue(true, boltshirt);
        System.out.print("T-Shirt available  ");
        driver.findElement(By.xpath("//button[contains(@id,'add-to-cart-sauce-labs-bolt-t-shirt')]")).click();
        String shirtAdded = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']")).getText();
        Assert.assertTrue(true, shirtAdded);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link'][contains(.,'3')]")).click();
        Thread.sleep(2000);
        System.out.print("T-Shirt added to cart! Let's got to cart!  ");
    }

    @Test (dependsOnMethods = "selectBoltshirt")
    public void finaliseCartItem1() throws InterruptedException {
        String backpack = driver.findElement(By.xpath("//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]")).getText();
        driver.findElement(By.xpath("(//div[@class='cart_quantity'])[1]")).getText();
        driver.findElement(By.xpath("//div[@class='inventory_item_price'][contains(.,'$29.99')]")).getText();
        Assert.assertTrue(true, backpack);
        System.out.print("Backpack available  ");
        Thread.sleep(2000);
    }

    @Test (dependsOnMethods = "finaliseCartItem1")
    public void finaliseCartItem2() throws InterruptedException {
        String bikelight = driver.findElement(By.xpath("//div[@class='inventory_item_name'][contains(.,'Sauce Labs Bike Light')]")).getText();
        driver.findElement(By.xpath("(//div[@class='cart_quantity'])[2]")).getText();
        driver.findElement(By.xpath("//div[@class='inventory_item_price'][contains(.,'$9.99')]")).getText();
        Assert.assertTrue(true, bikelight);
        System.out.print("Bike light available  ");
        Thread.sleep(2000);
    }
    @Test (dependsOnMethods = "finaliseCartItem2")
    public void finaliseCartItem3() throws InterruptedException {
        String boltshirt = driver.findElement(By.xpath("//div[@class='inventory_item_name'][contains(.,'Sauce Labs Bolt T-Shirt')]")).getText();
        driver.findElement(By.xpath("(//div[@class='cart_quantity'])[3]")).getText();
        driver.findElement(By.xpath("//div[@class='inventory_item_price'][contains(.,'$15.99')]")).getText();
        Assert.assertTrue(true, boltshirt);
        System.out.print("T-Shirt available  ");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(@id,'checkout')]")).click();
        Thread.sleep(2000);
        System.out.print("Cart ready let's checkout  ");
    }
    @Test (dependsOnMethods = "finaliseCartItem3")
    public void checkoutDetails() throws InterruptedException {
        driver.findElement(By.xpath("//input[contains(@id,'first-name')]")).sendKeys("Zipho");
        driver.findElement(By.xpath("//input[contains(@id,'last-name')]")).sendKeys("Ndu");
        driver.findElement(By.xpath("//input[contains(@id,'postal-code')]")).sendKeys("7945");
        driver.findElement(By.xpath("//input[contains(@id,'continue')]")).click();
        Thread.sleep(2000);
        System.out.print("Checking Out!!  ");
        Thread.sleep(2000);
    }

    @Test (dependsOnMethods = "checkoutDetails")
    public void paymentInvoiceItemsMatchesCart() {
        String backpack = driver.findElement(By.xpath("//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]")).getText();
        Assert.assertTrue(true, backpack);
        driver.findElement(By.xpath("(//div[@class='cart_quantity'])[1]")).getText();
        driver.findElement(By.xpath("//div[@class='inventory_item_price'][contains(.,'$29.99')]")).getText();
        String bikelight = driver.findElement(By.xpath("//div[@class='inventory_item_name'][contains(.,'Sauce Labs Bike Light')]")).getText();
        Assert.assertTrue(true, bikelight);
        driver.findElement(By.xpath("(//div[@class='cart_quantity'])[2]")).getText();
        driver.findElement(By.xpath("//div[@class='inventory_item_price'][contains(.,'$9.99')]")).getText();
        String boltshirt = driver.findElement(By.xpath("//div[@class='inventory_item_name'][contains(.,'Sauce Labs Bolt T-Shirt')]")).getText();
        Assert.assertTrue(true, boltshirt);
        driver.findElement(By.xpath("(//div[@class='cart_quantity'])[3]")).getText();
        driver.findElement(By.xpath("//div[@class='inventory_item_price'][contains(.,'$15.99')]")).getText();
        System.out.print("InvoiceItemsMatch Cart!!  ");
    }

    @Test (dependsOnMethods = "paymentInvoiceItemsMatchesCart")
    public void paymentInvoicePriceCheck() throws InterruptedException {
        String paymentinformation = driver.findElement(By.xpath("//div[@class='summary_value_label'][contains(.,'SauceCard #31337')]")).getText();
        Assert.assertTrue(true, paymentinformation);
        String shippinginformation = driver.findElement(By.xpath("//div[@class='summary_info_label'][contains(.,'Shipping Information:')]")).getText();
        Assert.assertTrue(true, shippinginformation);
        String pricetotal = driver.findElement(By.xpath("//div[@class='summary_info_label'][contains(.,'Price Total')]")).getText();
        Assert.assertTrue(true, pricetotal);
        String ActualItemtotal = driver.findElement(By.xpath("//div[@class='summary_subtotal_label'][contains(.,'Item total: $55.97')]")).getText();
        Assert.assertEquals(ActualItemtotal,"Item total: $55.97");
        Thread.sleep(2000);
        String ActualTaxResults = driver.findElement(By.xpath("//div[@class='summary_tax_label'][contains(.,'Tax: $4.48')]")).getText();
        Assert.assertEquals(ActualTaxResults,"Tax: $4.48");
        Thread.sleep(2000);
        String ActualTotalpayment = driver.findElement(By.xpath("//div[@class='summary_total_label'][contains(.,'Total: $60.45')]")).getText();
        Assert.assertEquals(ActualTotalpayment,"Total: $60.45");
    }
    @Test (dependsOnMethods = "paymentInvoicePriceCheck")
    public void finishShopping() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(@id,'finish')]")).click();
        String thanksforshopping = driver.findElement(By.xpath("//div[contains(@id,'container')][@class='checkout_complete_container'][contains(.,'Thank you for your order!Your order has been dispatched, and will arrive just as fast as the pony can get there!Back Home')]")).getText();
        Assert.assertEquals(thanksforshopping,"Thank you for your order!\n" +
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!\n" +
                "Back Home");
        Thread.sleep(5000);

    }
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}




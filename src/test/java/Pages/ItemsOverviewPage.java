package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ItemsOverviewPage {
    double subTotalTrim;
    double taxTrim;
    double totalCalculated = subTotalTrim + taxTrim;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Overview')]")
    WebElement overviewTitle;

    @FindBy(xpath = "//div[contains(@class,'summary_subtotal_label')]")
    WebElement subTotalAmount;

    @FindBy(xpath = "//div[contains(@class,'summary_tax_label')]")
    WebElement taxForPurchase;

    @FindBy(xpath = "//div[contains(@class,'summary_total_label')]")
    WebElement totalAmount;

    @FindBy(xpath = "//h2[contains(@class,'complete-header')]")
    WebElement confirmationOrderText;

    public void verifyOverviewPageTitle(){
        String overviewPage = overviewTitle.getText();
        Assert.assertEquals(overviewPage,"Checkout: Overview");
    }
    public void verifySubTotalAmount(){
        String subTotal = subTotalAmount.getText();
        System.out.println(subTotal);
        String subTotalString = subTotal.substring(12);
        subTotalTrim = Double.parseDouble(subTotalString);
        System.out.println(subTotalTrim);
    }
    public void verifyTaxForPurchase(){
        String tax = taxForPurchase.getText();
        System.out.println(tax);
        String subTaxString = tax.substring(5);
        taxTrim = Double.parseDouble(subTaxString);
    }
    public void verifyTotalAmount(){
        String theTotalAmount = totalAmount.getText();
        Assert.assertEquals(theTotalAmount,"$ "+totalCalculated);
    }
}

package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ItemsOverviewPage {
    double subTotalTrim;
    double taxTrim;
    double totalCalculated;

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

    @FindBy(xpath = "//button[contains(@id,'finish')]")
    WebElement finishButton;

    public void verifyOverviewPageTitle(){
        String overviewPage = overviewTitle.getText();
        Assert.assertEquals(overviewPage,"Checkout: Overview");
    }
    public void verifySubTotalAmount(){
        String subTotal = subTotalAmount.getText();
        System.out.println(subTotal);
        String subTotalString = subTotal.substring(13);
        subTotalTrim = Double.parseDouble(subTotalString);
        System.out.println(subTotalTrim);
    }
    public void verifyTaxForPurchase(){
        String tax = taxForPurchase.getText();
        System.out.println(tax);
        String subTaxString = tax.substring(6);
        taxTrim = Double.parseDouble(subTaxString);
    }

    public void verifyTotalAmount(){
        String theTotalAmount = totalAmount.getText();
        totalCalculated = subTotalTrim + taxTrim;
        Assert.assertEquals(theTotalAmount,"Total: $"+totalCalculated);
    }
    public void clickFinishButton(){
        finishButton.click();
    }

    public void verifyConfirmationOrderText(){
        String successOrderMessage = confirmationOrderText.getText();
        Assert.assertEquals(successOrderMessage,"Thank you for your order!");
    }
}

package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
    @FindBy(id = "billing_first_name") private WebElement billingFirstNameFld;
    @FindBy(id = "billing_last_name") private WebElement billingLastNameFld;
    @FindBy(id = "billing_address_1") private WebElement billingAddress1Fld;
    @FindBy(id = "billing_city") private WebElement billingCityFld;
    @FindBy(id = "billing_state") private WebElement billingStateDropDown;
    @FindBy(id = "billing_postcode") private WebElement billingPostCodeFld;
    @FindBy(id = "billing_email") private WebElement billingEmailFld;
    @FindBy(id = "place_order") private WebElement placeOrderBtn;
    @FindBy(css = ".woocommerce-thankyou-order-received") private WebElement noticeText;


    public CheckoutPage enterBillingFirstName(String billingFirstName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstNameFld));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }

    public CheckoutPage enterBillingLastName(String billingLastName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingLastNameFld));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckoutPage enterBillingAddress1(String billingAddress1) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddress1Fld));
        e.clear();
        e.sendKeys(billingAddress1);
        return this;
    }

    public CheckoutPage enterBillingCity(String billingCity) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityFld));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    public CheckoutPage selectFromStateDropdown(String billingState) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropDown)));
        select.selectByVisibleText(billingState);
        return this;
    }

    public CheckoutPage enterBillingPostcode(String billingPostcode) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingPostCodeFld));
        e.clear();
        e.sendKeys(billingPostcode);
        return this;
    }

    public CheckoutPage enterBillingEmail(String billingEmail) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailFld));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }

    public CheckoutPage setBillingDetails(
            String billingFirstName,
            String billingLastName,
            String billingAddress1,
            String billingCity,
            String billingState,
            String billingPostcode,
            String billingEmail
            ) {
        return enterBillingFirstName(billingFirstName)
                .enterBillingLastName(billingLastName)
                .enterBillingAddress1(billingAddress1)
                .enterBillingCity(billingCity)
                .selectFromStateDropdown(billingState)
                .enterBillingPostcode(billingPostcode)
                .enterBillingEmail(billingEmail);
    }

    public void placeOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }

    public String getNoticeText() {
        return wait.until(ExpectedConditions.visibilityOf(noticeText)).getText();
    }

    public CheckoutPage(WebDriver driver) {
        super(driver);
    };

}

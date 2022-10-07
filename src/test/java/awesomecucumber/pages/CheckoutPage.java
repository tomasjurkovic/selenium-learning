package awesomecucumber.pages;

import awesomecucumber.domainobjects.BillingDetails;
import org.openqa.selenium.By;
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
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");


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

    public CheckoutPage setBillingDetails(BillingDetails billingDetails) {
        return enterBillingFirstName(billingDetails.getBillingFirstName())
                .enterBillingLastName(billingDetails.getBillingLastName())
                .enterBillingAddress1(billingDetails.getBillingAddress1())
                .enterBillingCity(billingDetails.getBillingCity())
                .selectFromStateDropdown(billingDetails.getBillingStateName())
                .enterBillingPostcode(billingDetails.getBillingZip())
                .enterBillingEmail(billingDetails.getBillingEmail());
    }

    public void placeOrder() {
        waitForOverlaysToDisappear(overlay);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }

    public String getNoticeText() {
        return wait.until(ExpectedConditions.visibilityOf(noticeText)).getText();
    }

    public CheckoutPage(WebDriver driver) {
        super(driver);
    };

}

package awesomecucumber;

import awesomecucumber.factory.DriverFactory;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class MyStepDefinitions {

    private WebDriver driver;
    private String billingFirstName;
    private String billingLastName;
    private String billingAddress1;
    private String billingCity;
    private String billingStateName;
    private String billingZip;
    private String billingEmail;


    @Given("I'm on the Store Page")
    public void iMOnTheStorePage() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com/store");
    }

    @When("I add a {string} to the Cart")
    public void iAddAToTheCart(String productName) {
        new StorePage(driver).addToCart(productName);
    }

    @Then("I should see {int} {string} in the Cart")
    public void iShouldSeeInTheCart(int quantity, String productName) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
        Assert.assertEquals(productName, cartPage.getProductName());
    }

    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com/store");
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() {
        new StorePage(driver).addToCart("Blue Shoes");
    }

    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
        new CartPage(driver).checkout();
    }

    @And("my billing details are")
    public void myBillingDetailsAre(List<Map<String, String>> billingDetails) {
        billingFirstName = billingDetails.get(0).get("firstname");
        billingLastName = billingDetails.get(0).get("lastname");
        billingAddress1 = billingDetails.get(0).get("address_line_1");
        billingCity = billingDetails.get(0).get("city");
        billingStateName = billingDetails.get(0).get("state");
        billingZip = billingDetails.get(0).get("zip");
        billingEmail = billingDetails.get(0).get("email");

    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setBillingDetails(billingFirstName,
                billingLastName,
                billingAddress1,
                billingCity,
                billingStateName,
                billingZip,
                billingEmail)
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        new CheckoutPage(driver).placeOrder();
    }

    @Then("The order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        String expectedNoticeText = "Thank you. Your order has been received.";
        Assert.assertEquals(expectedNoticeText, new CheckoutPage(driver).getNoticeText());
    }
}

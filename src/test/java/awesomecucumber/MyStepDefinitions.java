package awesomecucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepDefinitions {

    private WebDriver driver;

    @Given("I'm on the Store Page")
    public void iMOnTheStorePage() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\tomas.jurkovic\\Downloads\\chromedriver\\chromedriver.exe"
        );
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/store");
    }

    @When("I add a {string} to the Cart")
    public void iAddAToTheCart(String productName) throws InterruptedException {
        By addToCartBtn = By.cssSelector("a[aria-label='Add “"+ productName + "” to your cart']");
        driver.findElement(addToCartBtn).click();
        Thread.sleep(5000);
        By viewCartLink = By.cssSelector("a[title='View cart']");
        driver.findElement(viewCartLink).click();
    }

    @Then("I should see {int} {string} in the Cart")
    public void iShouldSeeInTheCart(int quantity, String productName) {
        By productNameFld = By.cssSelector("td[class='product-name'] a");
        String actualProductName = driver.findElement(productNameFld).getText();
        By productQuantity = By.cssSelector("input[type=\"number\"]");
        String actualProductQuantity = driver.findElement(productQuantity).getAttribute("value");
        Assert.assertEquals(quantity, Integer.parseInt(actualProductQuantity));
        Assert.assertEquals(productName, actualProductName);

    }
}

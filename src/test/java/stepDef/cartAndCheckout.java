package stepDef;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.loginPages;
import pages.cartPage;
import pages.productPage;
import java.time.Duration;

public class cartAndCheckout {

    loginPages loginpage = new loginPages();
    productPage productpage = new productPage();
    cartPage cartpage = new cartPage();

    @Given("User is logged in and on the product page \\(cart)")
    public void userIsLoggedInAndOnTheProductPageCart() {
        loginpage.fillUsername("standard_user");
        loginpage.fillPassword("secret_sauce");
        loginpage.clickLogin();
        Assert.assertTrue(productpage.isDisplayed());
    }

    @When("User adds {string} to the cart")
    public void userAddsToTheCart(String productName) {
        productpage.addProduct(productName);
    }

    @Then("{string} should appear in the cart")
    public void shouldAppearInTheCart(String productName) {
        productpage.clickCartIcon();
        Assert.assertTrue(cartpage.isProductInCart(productName));
    }

    @Given("User is logged in and has {string} in the cart")
    public void userIsLoggedInAndHasInTheCart(String productName) {
        loginpage.fillUsername("standard_user");
        loginpage.fillPassword("secret_sauce");
        loginpage.clickLogin();
        productpage.addProduct(productName);
        productpage.clickCartIcon();
    }

    @When("Product removes {string} from the cart")
    public void productRemovesFromTheCart(String productName) {
        cartpage.removeProductFromCart(productName);
    }

    @Then("{string} should no longer appear in the cart")
    public void shouldNoLongerAppearInTheCart(String productName) {
        Assert.assertFalse(cartpage.isProductInCart(productName));
    }

    @And("User click cart icon")
    public void userClickCartIcon() {
        productpage.clickCartIcon();
    }

    @When("User click checkout")
    public void userClickCheckout() {
        cartpage.clickCheckout();
    }

    @And("User fills in the required data")
    public void userFillsInTheRequiredData() {
        cartpage.fillRequiredData("vania", "calista", "202");
    }

    @And("User click continue")
    public void userClickContinue() {
        cartpage.clickContinue();
    }

    @Then("the checkout process is complete")
    public void theCheckoutProcessIsComplete() {
        cartpage.getStatusCheckout();
    }

    @And("User click finish")
    public void userClickFinish() {
        cartpage.clickFinish();
    }


}

package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.loginPages;
import hooks.Hooks;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import pages.productPage;
import pages.productDetailPage;

public class Product {

    loginPages loginpage = new loginPages();
    productPage productpage = new productPage();
    productDetailPage productdetailpage = new productDetailPage();

    @Given("User is logged in and on the product page")
    public void userIsLoggedInAndOnTheProductPage() {
        loginpage.fillUsername("standard_user");
        loginpage.fillPassword("secret_sauce");
        loginpage.clickLogin();
        Assert.assertTrue(productpage.isDisplayed());
    }

    @When("User clicks on a product with name {string}")
    public void userClicksOnAProductWithName(String productName) {
        productpage.clickProductByName(productName);
    }

    @Then("User is redirected to the product detail page")
    public void userIsRedirectedToTheProductDetailPage() {
        Assert.assertTrue(productdetailpage.isDisplayed());
    }

    @And("Product title is displayed as {string}")
    public void productTitleIsDisplayedAs(String expectedTitle) {
        String actualTitle = productdetailpage.getProductTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @And("Product description is visible")
    public void productDescriptionIsVisible() {
        Assert.assertTrue(productdetailpage.isDescriptionVisible());
    }

    @And("Product price is visible")
    public void productPriceIsVisible() {
        Assert.assertTrue(productdetailpage.isPriceVisible());
    }

    @When("User click on the filter feature")
    public void userClickOnTheFilterFeature() {
        productpage.clickFilterFeature();
    }

    @And("User selects the {string} option")
    public void userSelectsTheOption(String optionName) {
        productpage.selectFilterOption(optionName);
    }

    @Then("Products are displayed according to the name filter from A to Z")
    public void productsAreDisplayedAccordingToTheNameFilterFromAToZ() {
        List<String> productNames = productpage.getProductsName();

        List<String> sortedNames = new ArrayList<>(productNames);
        Collections.sort(sortedNames);

        Assert.assertEquals(sortedNames, productNames);
    }

    @Then("Products are displayed according to the name filter from Z to A")
    public void productsAreDisplayedAccordingToTheNameFilterFromZToA() {
        List<String> productNames = productpage.getProductsName();

        List<String> sortedNames = new ArrayList<>(productNames);
        sortedNames.sort(Comparator.reverseOrder());

        Assert.assertEquals(sortedNames, productNames);
    }

    @Then("Products are displayed according to the price filter from low to high")
    public void productsAreDisplayedAccordingToThePriceFilterFromLowToHigh() {
        List<String> priceTexts = productpage.getProductPrices();

        List<Double> prices = priceTexts.stream()
                .map(price -> Double.parseDouble(price.replace("$", "").trim()))
                .collect(Collectors.toList());

        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        Assert.assertEquals(sortedPrices, prices);
    }

    @Then("Products are displayed according to the price filter from high to low")
    public void productsAreDisplayedAccordingToThePriceFilterFromHighToLow() {
        List<String> priceTexts = productpage.getProductPrices();

        List<Double> prices = priceTexts.stream()
                .map(price -> Double.parseDouble(price.replace("$", "").trim()))
                .collect(Collectors.toList());

        List<Double> sortedPrices = new ArrayList<>(prices);
        sortedPrices.sort(Comparator.reverseOrder());

        Assert.assertEquals(sortedPrices, prices);
    }
}

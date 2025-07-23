package stepDef;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.loginPages;
import hooks.Hooks;
import java.time.Duration;

public class Login{

    loginPages loginpage = new loginPages();

    @Given("User is in login page")
    public void userIsInLoginPage() {
        loginpage.isInLoginPage();
    }

    @When("User fill username and password")
    public void userFillUsernameAndPassword() {
        loginpage.fillUsername("standard_user");
        loginpage.fillPassword("secret_sauce");
    }

    @And("User click login button")
    public void userClickLoginButton() {
        loginpage.clickLogin();
    }

    @Then("User verify login result")
    public void userVerifyLoginResult() {
        loginpage.verifyLoginResult();
    }

    @When("User fill invalid username")
    public void userFillInvalidUsername() {
        loginpage.fillUsername("user");
    }

    @And("User fill password")
    public void userFillPassword() {
        loginpage.fillPassword("secret_sauce");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        loginpage.getErrorMessage();
    }

    @When("User fill username")
    public void userFillUsername() {
        loginpage.fillUsername("standard_user");
    }

    @And("User fill invalid password")
    public void userFillInvalidPassword() {
        loginpage.fillPassword("secret");
    }

    @When("User leave username blank")
    public void userLeaveUsernameBlank() {
        loginpage.fillUsername("");
    }

    @And("User leave password blank")
    public void userLeavePasswordBlank() {
        loginpage.fillPassword("");
    }

    @Then("User get error message {string}")
    public void userGetErrorMessage(String errorMessage) {
        loginpage.getErrorMessage(errorMessage);
    }

    //penerapan TDD
//    @Step("User fill invalid username and password")
//    @When("User fill invalid username and password")
//    public void userFillInvalidUsernameAndPassword() {
//        driver.findElement(By.name("user-name")).sendKeys("s123");
//        driver.findElement(By.id("password")).sendKeys("secret");
//    }
//
//    @Then("User get error message")
//    public void userGetErrorMessage() {
//        wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.className("error-button"))
//        );
//        driver.quit();
//    }
//
//    @When("^User input (.*) and (.*)$")
//    public void userInputUsernameAndPassword(String username, String password) {
//        driver.findElement(By.name("user-name")).sendKeys(username);
//        driver.findElement(By.id("password")).sendKeys(password);
//    }
//
//    @Then("^User get verify login (.*)$")
//    public void userGetVerifyLoginResults(String result) {
//        if (result == "Passed"){
//            wait.until(ExpectedConditions.or(
//                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(), 'Products')]"))
//            ));
//        } else if (result == "Failed") {
//            wait.until(ExpectedConditions.or(
//                    ExpectedConditions.visibilityOfElementLocated(By.className("error-button"))
//            ));
//        }
//        driver.quit();
//    }
}

package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends env_target {

    WebDriverWait wait;

    @Given("User is in login page")
    public void userIsInLoginPage() {
        // set driverLocation path
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        // Maximize driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // set url
        driver.get(sauceDemo);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-button']"))
        );
    }

    @When("User fill username and password")
    public void userFillUsernameAndPassword() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("User verify login result")
    public void userVerifyLoginResult() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(), 'Products')]"))
        );
        driver.quit();
    }

    @When("User fill invalid username and password")
    public void userFillInvalidUsernameAndPassword() {
        driver.findElement(By.name("user-name")).sendKeys("s123");
        driver.findElement(By.id("password")).sendKeys("secret");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("error-button"))
        );
        driver.quit();
    }

    @When("^User input (.*) and (.*)$")
    public void userInputUsernameAndPassword(String username, String password) {
        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("^User get verify login (.*)$")
    public void userGetVerifyLoginResults(String result) {
        if (result == "Passed"){
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(), 'Products')]"))
            ));
        } else if (result == "Failed") {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.className("error-button"))
            ));
        }
        driver.quit();
    }
}

package stepDef;

import config.env_target;
import org.openqa.selenium.WebDriver;
import pages.homePages;
import pages.registerPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;

public class Register extends env_target {

    WebDriverWait wait;
    WebDriver driver;

    @Given("User is on parabank homepage")
    public void userIsOnParabankHomepage() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(paraBank);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"leftPanel\"]"))
        );
    }

    @When("User click register link button")
    public void userClickRegisterLinkButton() {
        homePages homepage = new homePages(driver);

        homepage.clickRegister();
    }

    @Then("User is in register page")
    public void userIsInRegisterPage() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rightPanel']/h1"))
        );
    }

    @When("User input name")
    public void userInputName() {
        registerPages inputname = new registerPages(driver);

        inputname.inputNameData("aqeela", "calista");
    }

    @And("User input address detail")
    public void userInputAddressDetail() {
        driver.findElement(By.name("customer.address.street")).sendKeys("Jalan Golf No.44");
        driver.findElement(By.name("customer.address.city")).sendKeys("Malang");
        driver.findElement(By.name("customer.address.state")).sendKeys("Indonesia");
        driver.findElement(By.name("customer.address.zipCode")).sendKeys("21677");
        driver.findElement(By.name("customer.phoneNumber")).sendKeys("07665536");
        driver.findElement(By.name("customer.ssn")).sendKeys("11111");
    }

    @And("User fill valid username and password")
    public void userFillValidUsernameAndPassword() {
        Random rand = new Random();
        int userRand = rand.nextInt(10000);
        driver.findElement(By.name("customer.username")).sendKeys("user" + userRand);
        driver.findElement(By.name("customer.password")).sendKeys("123");
    }

    @And("User input password confirmation")
    public void userInputPasswordConfirmation() {
        driver.findElement(By.name("repeatedPassword")).sendKeys("123");
    }

    @When("User click register button")
    public void userClickRegisterButton() {
        driver.findElement(By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input")).click();
    }

    @Then("User regist successfully")
    public void userRegistSuccessfully() {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Your account was created successfully. You are now logged in.')]"))
        );
        driver.quit();
    }

    @And("User input invalid password confirmation")
    public void userInputInvalidPasswordConfirmation() {
        driver.findElement(By.name("repeatedPassword")).sendKeys("111");
    }

    @Then("User get error password did not match")
    public void userGetErrorPasswordDidNotMatch() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Passwords did not match')]"))
        );
        driver.quit();
    }
}

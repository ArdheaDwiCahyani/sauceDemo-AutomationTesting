package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class loginPages extends basePage {

    //locator dari login button
    By loginButton = By.name("login-button");
    By Username = By.name("user-name");
    By Password = By.name("password");

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void fillUsername(String username) {
        driver.findElement(Username).sendKeys(username);
    }

    public void fillPassword(String password) {
        driver.findElement(Password).sendKeys(password);
    }

    public void isInLoginPage() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("login-button"))
        );
    }

    public void verifyLoginResult() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(), 'Products')]"))
        );
    }

    public void getErrorMessage() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("error-button"))
        );
    }

    public void getErrorMessage(String errorMessage) {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), '" + errorMessage + "')]")
        ));
    }

}

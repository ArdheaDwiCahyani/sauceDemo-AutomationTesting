package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class cartPage extends basePage {
        public boolean isProductInCart(String productName) {
            try {
                String xpath = "//div[@class='cart_item']//div[@class='inventory_item_name' and text()='" + productName + "']";
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                return true;
            } catch (TimeoutException e) {
                return false;
            }
    }

    public void removeProductFromCart(String productName) {
        String xpath = "//div[@class='cart_item'][.//div[text()='" + productName + "']]";
        WebElement productCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement removeButton = productCard.findElement(By.xpath(".//button[contains(text(), 'Remove')]"));
        removeButton.click();
    }

    public void clickCheckout() {
        driver.findElement(By.xpath("//button[text()='Checkout']")).click();
    }

    public void fillRequiredData(String first, String last, String zip) {
        driver.findElement(By.name("firstName")).sendKeys(first);
        driver.findElement(By.name("lastName")).sendKeys(last);
        driver.findElement(By.name("postalCode")).sendKeys(zip);
    }

    public void clickContinue() {
        driver.findElement(By.name("continue")).click();
    }

    public String getStatusCheckout() {
        return driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
    }

    public void clickFinish() {
        driver.findElement(By.name("finish")).click();

    }

}

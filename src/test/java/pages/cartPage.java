package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class cartPage extends basePage {
        public boolean isProductInCart(String productName) {
        List<WebElement> items = driver.findElements(
                By.xpath("//div[@class='cart_item']//div[@class='inventory_item_name' and text()='" + productName + "']")
        );
        return !items.isEmpty();
    }

    public void removeProductFromCart(String productName) {
        WebElement productCard = driver.findElement(
                By.xpath("//div[@class='cart_item'][.//div[text()='" + productName + "']]")
        );
        productCard.findElement(By.xpath(".//button[contains(text(), 'Remove')]")).click();
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

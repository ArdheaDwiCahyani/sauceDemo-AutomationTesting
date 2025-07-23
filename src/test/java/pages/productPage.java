package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class productPage extends basePage {

    public boolean isDisplayed() {
        return driver.getCurrentUrl().contains("/inventory.html");
    }

    public void clickProductByName(String productName) {
        driver.findElement(By.xpath("//*[contains(text(), '" + productName + "')]")).click();
    }

    public void clickFilterFeature() {
        driver.findElement(By.className("product_sort_container")).click();
    }

    public void selectFilterOption(String optionName) {
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByVisibleText(optionName);
    }

    public List<String> getProductsName() {
        List<WebElement> productElements = driver.findElements(By.className("inventory_item_name"));
        List<String> productNames = new ArrayList<>();
        for (WebElement element : productElements) {
            productNames.add(element.getText());
        }
        return productNames;
    }

    public List<String> getProductPrices() {
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        List<String> prices = new ArrayList<>();
        for (WebElement element : priceElements) {
            prices.add(element.getText());
        }
        return prices;
    }

    public void addProduct(String productName) {
        String xpath = "//div[@class='inventory_item'][.//div[contains(text(),'" + productName + "')]]";
        WebElement productCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

        WebElement button = productCard.findElement(By.tagName("button"));
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();

        By removeButtonLocator = By.xpath(xpath + "//button[text()='Remove']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeButtonLocator));
    }

    public void clickCartIcon() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

}

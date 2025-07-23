package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class productDetailPage extends basePage{

    public boolean isDisplayed() {
        return driver.getCurrentUrl().contains("/inventory-item.html");
    }

    public String getProductTitle() {
        return driver.findElement(By.className("inventory_details_name")).getText();
    }

    public boolean isDescriptionVisible() {
        return driver.findElement(By.className("inventory_details_desc")).isDisplayed();
    }

    public boolean isPriceVisible() {
        return driver.findElement(By.className("inventory_details_price")).isDisplayed();
    }
}

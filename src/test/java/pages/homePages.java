
// PENERAPAN POM (PAGE OBJECT MODELLING)

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePages {
    WebDriver driver;

    public homePages(WebDriver driver) {
        this.driver=driver;
    }

    //locator dari register button
    By RegisterButton = By.xpath("//*[@id='loginPanel']/p[2]/a");

    public void clickRegister() {
        driver.findElement(RegisterButton).click();
    }

}

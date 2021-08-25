import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Form {

    private final WebDriver driver;

    public Form (WebDriver driver) {
        this.driver = driver;
        driver.get("https://d1iw6mb9di5l9r.cloudfront.net/#/forms");
    }

    public WebElement getCard() {
        WebElement card = this.driver.findElement(By.className("v-card__text"));
        return card;
    }

    public void clickSubmitButton(WebElement element) {
        element.findElement(By.tagName("button")).click();
    }

    public void wait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    public boolean foundErrorMsg(WebDriver driver) {
        if(driver.findElement(By.id("name-err")).isDisplayed()
            && driver.findElement(By.id("email-err")).isDisplayed()
            && driver.findElement(By.id("agree-err")).isDisplayed()) {
            return true;
        }
        else {
            return false;
        }

    }
}

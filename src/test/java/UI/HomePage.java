package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        var loginButtons = driver.findElements(By.id("loginButton"));

        for(var button : loginButtons) {
            if(button.isDisplayed()) {
                button.click();
                break;
            }
        }
    }

    public void clickProfileButton() {
        driver.findElement(By.cssSelector("[aria-label=users]")).click();
    }
    public void clickProfileFormLoginButton() {
        WebElement card = driver.findElement(By.className("v-card__actions"));
        card.findElement(By.id("loginButton")).click();
    }

    public WebElement getAlertMsgElement() {
        return driver.findElement(By.className("alert-message"));
    }

    public void waitUntilAlertMsgVisible() {
        new WebDriverWait(driver, 2);
    }
}

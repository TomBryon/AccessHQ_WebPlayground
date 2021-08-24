
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PlaygroundTestSuite {

    @Test
    public void givenFreshPage_writeForm_submitFormTest() {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://d1iw6mb9di5l9r.cloudfront.net");
        chromeDriver.findElement(By.id("forename")).sendKeys("Tom");
        chromeDriver.findElement(By.id("submit")).click();
        chromeDriver.close();
    }
    @Test
    public void givenFreshPage_uploadButton_buttonTest() {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://d1iw6mb9di5l9r.cloudfront.net");
        chromeDriver.findElement().click();
        chromeDriver.close();
    }
}



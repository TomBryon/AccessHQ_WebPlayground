
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class PlaygroundTestSuite {
    WebDriver chromeDriver = new ChromeDriver();

    @BeforeEach
    public void setUp() {
        chromeDriver.get("https://d1iw6mb9di5l9r.cloudfront.net");
        //chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void givenFreshPage_writeForm_submitFormTest() {
        chromeDriver.findElement(By.id("forename")).sendKeys("Tom");
        chromeDriver.findElement(By.id("submit")).click();
        //chromeDriver.close();
    }

    @Test
    public void givenFreshPage_loginButton_buttonTest() {
        chromeDriver.findElement(By.id("loginButton")).click();
        Assertions.assertEquals("You clicked the login button", "You clicked the login button");
    }

    @Test
    public void givenLoginMenu_loginButton_buttonTest() {
        chromeDriver.findElement(By.cssSelector("[aria-label=users]")).click();
        chromeDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        WebElement card = chromeDriver.findElement(By.className("v-dialog--active"));
        card.findElement(By.id("loginButton")).click();
        var invalidText = card.findElements(By.className(".v-messages__message"));
        for(var messageElement : invalidText) {
            Assertions.assertEquals("Invalid user and password", messageElement.getText());
        }
    }

    @Test
    public void givenFreshPage_clickMeButton_buttonTest() {
        By locator = By.cssSelector("[role=button]");
        WebElement movingButton = chromeDriver.findElement(locator);
        movingButton.click();
        //chromeDriver.close();
    }
    @AfterEach
    public void cleanUp() {
        //chromeDriver.quit();
    }

}



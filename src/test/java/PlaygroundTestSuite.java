import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class PlaygroundTestSuite {

    private WebDriver chromeDriver;

    @BeforeEach
    public void setUp() {
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://d1iw6mb9di5l9r.cloudfront.net");
        chromeDriver.manage().window().setSize(new Dimension(560, 720));
        chromeDriver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void givenFreshPage_writeForm_submitFormTest() {
        chromeDriver.findElement(By.id("forename")).sendKeys("Tom");
        chromeDriver.findElement(By.id("submit")).click();
    }

    @Test
    public void givenFreshPage_loginButton_buttonTest() {
        chromeDriver.findElement(By.id("loginButton")).click();
        WebElement popup = chromeDriver.findElement(By.className("alert-message"));
        chromeDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        //Assertions.assertEquals("You clicked the login button", popup.getText());
    }

    @Test
    public void clickOnProfile_attemptLogin_blankCredentialsTest() {
        chromeDriver.findElement(By.cssSelector("[aria-label=users]")).click();
        WebElement card = chromeDriver.findElement(By.className("v-dialog--active"));
        card.findElement(By.id("loginButton")).click();
        var invalidText = card.findElements(By.className(".v-messages__message"));
        for (WebElement i : invalidText) {
            Assertions.assertEquals("Invalid user and password", invalidText.toString());
        }
    }

    @Test
    public void formPage_fillInForm_checkCredentialsTest() {
        chromeDriver.get("https://d1iw6mb9di5l9r.cloudfront.net/#/forms");

        WebElement nameField = chromeDriver.findElement(By.id("name"));
        nameField.sendKeys("Thomas Bryon");

        WebElement emailField = chromeDriver.findElement(By.id("email"));
        emailField.sendKeys("t.j.bryon@gmail.com");

        WebElement stateField = chromeDriver.findElement(By.id("state"));
        stateField.sendKeys("QLD");
        chromeDriver.findElement(By.className("v-input--selection-controls__ripple")).click();

        WebElement card = chromeDriver.findElement(By.className("v-card__text"));
        card.findElement(By.tagName("button")).click();

        chromeDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        //Assert: check if error msgs are not present
        Assertions.assertEquals(0, chromeDriver.findElements(By.id("name-err")).size());
        Assertions.assertEquals(0, chromeDriver.findElements(By.id("email-err")).size());
        Assertions.assertEquals(0, chromeDriver.findElements(By.id("agree-err")).size());
        //Check popup has appeared
        //WebElement response = chromeDriver.findElement(By.className("snackbar popup-message mr-auto"));
        //Assertions.assertEquals("Thanks for your feedback Thomas Bryon", response.getText());

    }

    @Test
    public void formPage_blankForm_checkErrorMsgTest() {
        //arrange
        Form f = new Form(chromeDriver);
        WebElement card = f.getCard();
        //act
        f.clickSubmitButton(card);
        f.wait(chromeDriver);
        //assert
        Assertions.assertTrue(f.foundErrorMsg(chromeDriver));
    }

    @Test
    public void givenFreshPage_clickMeButton_innerTextTest() {
        By locator = By.cssSelector("[role=button]");
        WebElement movingButton = chromeDriver.findElement(locator);
        movingButton.click();
        Assertions.assertEquals("CLICK ME DOWN!", movingButton.getText());
    }

    @Test
    public void clickOnProfile_attemptLogin_loginCredentialsTest() {
        //arrange
        HomePage hp = new HomePage(chromeDriver);
        hp.clickProfileButton();
        //act
        hp.clickProfileFormLoginButton();
        hp.waitUntilAlertMsgVisible();
        //assert
        Assertions.assertTrue(chromeDriver.findElements(By.className("v-messages__message")).size() == 2);
    }

    @AfterEach
    public void cleanUp() {
        chromeDriver.quit();
    }

}
package tests;

import UI.PlanetTile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import strategies.MatchRadius;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class PlanetTestSuite {

    private WebDriver chromeDriver;

    @BeforeEach
    public void setUp() {
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://d21vtxezke9qd9.cloudfront.net");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        chromeDriver.findElement(By.cssSelector("[aria-label=planets]")).click();
    }

    @Test
    public void givenPlanetsPage_checkHeader() {
        //arrange
        String titleText = chromeDriver.findElement(By.tagName("h1")).getText();
        //assert
        Assertions.assertEquals("Planets", titleText);
    }

    @Test
    public void givenPlanetsPage_getPlanetName_checkPlanetName() {
        //arrange
        PlanetTile planetTile = new PlanetTile(chromeDriver);
        //act
        String planetName = planetTile.getPlanetName();
        //assert
        Assertions.assertEquals("Mercury", planetName);
    }

    public String getPopUpMessage() {
        WebElement snackbarPopUp = chromeDriver.findElement(By.className("v-snack__content"));
        String popUpText = chromeDriver.findElement(By.className("popup-message")).getText();
        return popUpText;
    }
    @Test
    public void givenPlanetsPage_getPlanetTile_checkPopupText() {
        //arrange
        PlanetTile planetTile = new PlanetTile(chromeDriver);

        //act
        planetTile.clickPlanetButton();
        String popUpText = getPopUpMessage();

        //assert
        Assertions.assertEquals("Exploring Mercury", popUpText);
    }

    @Test
    public void givenPlanetsPage_getPlanetRadius_explorePlanetBasedOnRadius() {
        //arrange
        PlanetTile planetTile = new PlanetTile(chromeDriver);
        MatchRadius planetRadius = new MatchRadius();
        var planetListElms = planetTile.getPlanetList();
        //act
        for (var planet : planetListElms) {
            if(planetRadius.match(planet, 4000)) {
                planetTile.clickPlanetButton();
                String popUpText = getPopUpMessage();
                //assert
                Assertions.assertEquals("Exploring" + planet.getName(), popUpText);
            }
        }
    }

    @AfterEach
    public void cleanUp() {
        chromeDriver.quit();
    }
}

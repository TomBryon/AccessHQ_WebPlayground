package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PlanetTile {

    private WebDriver driver;

    public PlanetTile (WebDriver driver) {
        this.driver = driver;
    }

    public String getPlanetName() {
        return driver.findElement(By.tagName("h2")).getText();
    }

    public void clickPlanetButton() {
        WebElement tile = driver.findElement(By.className("planets"));
        tile.findElement(By.tagName("button")).click();
    }

    public ArrayList<Planet> getPlanetList() {
        var planetList = new ArrayList<Planet>();
        for (var planet : planetList ){
            new Planet(driver.findElement(By.className("name headline primary--text")).getText());
        }
        return planetList;
    }

    public float getRadius(Planet planet) {
        String radiusString = driver.findElement(By.className("radius")).getText();
        radiusString = radiusString.split(" ")[0];
        return Float.parseFloat(radiusString);
    }
}
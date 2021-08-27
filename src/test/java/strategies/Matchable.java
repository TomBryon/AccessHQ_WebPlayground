package strategies;

import UI.Planet;
import org.openqa.selenium.WebElement;

public interface Matchable {

    public static boolean match(Planet planet) {
        return false;
    }
}
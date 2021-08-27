package strategies;
import UI.Planet;

public class MatchRadius implements Matchable{

    public static boolean match(Planet planet, float radiusSize){

        if(planet.getRadius() > radiusSize) {
            return true;
        } else {
            return false;
        }
    }
}

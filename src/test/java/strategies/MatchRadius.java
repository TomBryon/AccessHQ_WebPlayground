package strategies;
import UI.Planet;
import UI.PlanetTile;

public class MatchRadius implements Matchable{

    public static boolean match(PlanetTile planet, Planet p, float radiusSize){

        if(planet.getRadius(p) > radiusSize) {
            return true;
        } else {
            return false;
        }
    }
}

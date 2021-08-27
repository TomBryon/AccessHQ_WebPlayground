package strategies;
import UI.Planet;

public class DistanceComparison implements Matchable{

    public static boolean match(Planet targetPlanet, Planet comparePlanet){

        if(targetPlanet.getDistanceFrmSun() > comparePlanet.getDistanceFrmSun()) {
            return true;
        } else {
            return false;
        }
    }
}
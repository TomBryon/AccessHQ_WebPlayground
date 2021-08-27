package UI;

public class Planet {

    private String name;
    private long distance;
    private float radius;

    public Planet(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public long getDistanceFrmSun() {
        return this.distance;
    }

    public float getRadiusOfPlanet() {
        return this.radius;
    }

    public void setDistance(long newDistance) {
        distance = newDistance;
    }

    public void setRadius(long newRadius) {
        radius = newRadius;
    }

}

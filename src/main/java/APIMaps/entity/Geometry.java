package APIMaps.entity;

public class Geometry {

    private double[][] coordinates;
    private String type;

    public Geometry(double[][] coordinates, String type) {
        this.coordinates = coordinates;
        this.type = type;
    }

    public double[][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[][] coordinates) {
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

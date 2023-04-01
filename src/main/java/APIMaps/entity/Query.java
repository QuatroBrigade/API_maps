package APIMaps.entity;

public class Query {
    private double[][] coordinates;
    private String profile;
    private String format;

    public Query(double[][] coordinates, String profile, String format) {
        this.coordinates = coordinates;
        this.profile = profile;
        this.format = format;
    }

    public double[][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[][] coordinates) {
        this.coordinates = coordinates;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}

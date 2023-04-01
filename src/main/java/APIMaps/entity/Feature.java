package APIMaps.entity;

public class Feature {
    private double[] bbox;
    private String type;
    private Properties properties;
    private Geometry geometry;

    public Feature(double[] bbox, String type, Properties properties, Geometry geometry) {
        this.bbox = bbox;
        this.type = type;
        this.properties = properties;
        this.geometry = geometry;
    }

    public double[] getBbox() {
        return bbox;
    }

    public void setBbox(double[] bbox) {
        this.bbox = bbox;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}

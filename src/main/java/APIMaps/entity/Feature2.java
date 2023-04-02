package APIMaps.entity;

public class Feature2 {
    private String type;
    private Properties2 properties;
    private Geometry2 geometry;

    public Feature2(String type, Properties2 properties, Geometry2 geometry) {
        this.type = type;
        this.properties = properties;
        this.geometry = geometry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Properties2 getProperties() {
        return properties;
    }

    public void setProperties(Properties2 properties) {
        this.properties = properties;
    }

    public Geometry2 getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry2 geometry) {
        this.geometry = geometry;
    }
}

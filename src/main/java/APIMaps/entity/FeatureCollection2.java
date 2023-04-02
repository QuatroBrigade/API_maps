package APIMaps.entity;

public class FeatureCollection2 {
    private String type;
    private double[] bbox;
    private Feature2[] features;

    public FeatureCollection2(String type, double[] bbox, Feature2[] features) {
        this.type = type;
        this.bbox = bbox;
        this.features = features;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double[] getBbox() {
        return bbox;
    }

    public void setBbox(double[] bbox) {
        this.bbox = bbox;
    }

    public Feature2[] getFeatures() {
        return features;
    }

    public void setFeatures(Feature2[] features) {
        this.features = features;
    }
}

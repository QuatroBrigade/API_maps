package APIMaps.entity;

public class FeatureCollection {
    private String type;
    private Feature[] features;
    private double[] bbox;
    private Metadata metadata;

    public FeatureCollection(String type, Feature[] features, double[] bbox, Metadata metadata) {
        this.type = type;
        this.features = features;
        this.bbox = bbox;
        this.metadata = metadata;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Feature[] getFeatures() {
        return features;
    }

    public void setFeatures(Feature[] features) {
        this.features = features;
    }

    public double[] getBbox() {
        return bbox;
    }

    public void setBbox(double[] bbox) {
        this.bbox = bbox;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}

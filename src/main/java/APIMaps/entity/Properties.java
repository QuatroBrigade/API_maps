package APIMaps.entity;

public class Properties {
    private Segment[] segments;
    private Summary summary;
    private int[] way_points;

    public Properties(Segment[] segments, Summary summary, int[] way_points) {
        this.segments = segments;
        this.summary = summary;
        this.way_points = way_points;
    }

    public Segment[] getSegments() {
        return segments;
    }

    public void setSegments(Segment[] segments) {
        this.segments = segments;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public int[] getWay_points() {
        return way_points;
    }

    public void setWay_points(int[] way_points) {
        this.way_points = way_points;
    }
}

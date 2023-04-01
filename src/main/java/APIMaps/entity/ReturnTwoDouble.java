package APIMaps.entity;

public class ReturnTwoDouble {

    private double duration;
    private double distance;

    public ReturnTwoDouble(double duration, double distance) {
        this.duration = duration;
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}

package APIMaps.entity;

public class Segment {

    private double distance;
    private double duration;
    private Step[] steps;


    public Segment(double distance, double duration, Step[] steps) {
        this.distance = distance;
        this.duration = duration;
        this.steps = steps;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Step[] getSteps() {
        return steps;
    }

    public void setSteps(Step[] steps) {
        this.steps = steps;
    }
}


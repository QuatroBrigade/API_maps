package APIMaps.entity;

public class Properties2 {
    private int group_index;
    private double value;
    private double[] center;
    private double total_pop;

    public Properties2(int group_index, double value, double[] center, double total_pop) {
        this.group_index = group_index;
        this.value = value;
        this.center = center;
        this.total_pop = total_pop;
    }

    public int getGroup_index() {
        return group_index;
    }

    public void setGroup_index(int group_index) {
        this.group_index = group_index;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double[] getCenter() {
        return center;
    }

    public void setCenter(double[] center) {
        this.center = center;
    }

    public double getTotal_pop() {
        return total_pop;
    }

    public void setTotal_pop(double total_pop) {
        this.total_pop = total_pop;
    }
}

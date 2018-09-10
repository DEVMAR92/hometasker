package hometaskerzadanie.hometasker;

public class Person {

    private String name;
    private double points;

    public Person(String name) {
        this.name = name;
    }
    public Person(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return name + ", pkt: " + points ;
    }


}

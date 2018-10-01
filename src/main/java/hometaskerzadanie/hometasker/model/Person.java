package hometaskerzadanie.hometasker.model;

import java.util.Objects;

public class Person implements Comparable {

    private String name;
    private int points;


    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass() || o == null) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public int compareTo(Object o) {

        if (this.getPoints() > ((Person) o).getPoints()) {
            return 1;
        } else if (this.getPoints() < ((Person) o).getPoints()) {
            return -1;
        } else {
            return 0;

        }
    }
}
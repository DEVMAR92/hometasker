package hometaskerzadanie.hometasker;

import java.util.Date;

public class Task {

    private String description;
    private double value;
    private Date date;


    public Task(String description, double value) {
        this.description = description;
        this.value = value;


    }
    public Task(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return description + ", pkt:  " + value;
    }
}

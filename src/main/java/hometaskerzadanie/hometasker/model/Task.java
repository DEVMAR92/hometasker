package hometaskerzadanie.hometasker.model;

import hometaskerzadanie.hometasker.model.Person;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {

    private String description;
    private int value;
    private Person person;
    @DateTimeFormat(pattern ="yyyy-MM-dd'T'HH:mm")
    private LocalDateTime localDateTime;

    public Task(String description, int value, Person person, int ye, int mo, int day, int h, int m) {
        this.description = description;
        this.value = value;
        this.person = person;
        this.localDateTime = localDateTime.of(ye, mo, day, h, m);
    }

    public Task(String description, int value, Person person, LocalDateTime localDateTime) {
        this.description = description;
        this.value = value;
        this.person = person;
        this.localDateTime = localDateTime;
    }

    public Task(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "# " + description + " " + person + ": " + value + " pkt " + localDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass() || o == null) return false;
        Task task = (Task) o;
        return getValue() == task.getValue() &&
                Objects.equals(getDescription(), task.getDescription()) &&
                Objects.equals(getPerson(), task.getPerson()) &&
                Objects.equals(getLocalDateTime(), task.getLocalDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getValue(), getPerson(), getLocalDateTime());
    }
}

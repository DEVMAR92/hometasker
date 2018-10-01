package hometaskerzadanie.hometasker;

import hometaskerzadanie.hometasker.model.Person;
import hometaskerzadanie.hometasker.model.Task;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    
    private List<Task> tasks;
    private List<Task> archives;
    private List<Person> persons;
    private int editTask;
    private int editPerson;

    public TaskRepository() {
        tasks = new ArrayList<>();
        archives = new ArrayList<>();
        persons = new ArrayList<>();

        persons.add(new Person("Mama"));
        persons.add(new Person("Tato"));
        persons.add(new Person("Jasio"));

        tasks.add(new Task("skosić trawnik", 7, persons.get(1), 2018, 9, 30, 18, 00));
        tasks.add(new Task("umyć podłogę", 4, persons.get(2), 2018, 9, 30, 19, 30));
        tasks.add(new Task("zmyć naczynia", 5, persons.get(0), 2018, 9, 01, 8, 00));
        tasks.add(new Task("wynieść śmieci", 2, persons.get(2), 2018, 10, 01, 14, 00));
        tasks.add(new Task("naprawić kran", 10, persons.get(1), 2018, 10, 01, 17, 10));
        tasks.add(new Task("umyć samochód", 9, persons.get(2), 2018, 10, 02, 15, 00));
        tasks.add(new Task("wytrzepać dywan", 6, persons.get(1), 2018, 10, 02, 16, 20));
        tasks.add(new Task("wykąpać psa", 5, persons.get(0), 2018, 10, 02, 18, 30));


    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Task> getArchives() {
        return archives;
    }

    public List<Person> getPersons() {
        return persons;
    }


    public void addPerson(Person person){
        if(!checkAddPerson(person)) {
            persons.add(person);
        }
    }

    private boolean checkAddPerson(Person person){
        for (Person p : persons){
            if(p.equals(person)){
                return true;
            }
        }
        return false;
    }

    public void addTask(Task task){
        if(!checkAddTask(task)) {
            tasks.add(task);
        }
    }

    private boolean checkAddTask(Task task){
        for(Task t : tasks){
            if(t.equals(task)){
                return true;
            }
        }
        return false;
    }


    private LocalDateTime getAktualTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime;
    }

    public Person find(String name) {
        Person person = new Person(name);
        for (Person p : persons){
            if(p.equals(person)){
                return p;
            }
        }
        return null;
    }

    public Person findByPerson(Person person){
        if(checkList(person)) {
            for (Task task : tasks) {
                if (task.getPerson().equals(person)) {
                    return task.getPerson();
                }
            }
        } else {
            for(Task task : archives){
                if (task.getPerson().equals(person)) {
                    return task.getPerson();
                }
            }
        }
        return null;
    }

    private boolean checkList(Person person){
        for(Task task : tasks){
            if(task.getPerson().equals(person)){
                return true;
            }
        }
        return false;
    }

    public void addScore(String description, int value, Person person, LocalDateTime localDateTime){
        for(Task task : tasks){
            if(task.equals(createTask(description, value, person, localDateTime))){
                addArchives(task);
            }
        }
    }
    private void addArchives(Task task){
        if(task.getLocalDateTime().isAfter(getAktualTime())){
            archives.add(task);
            addPersonPoints(task);
        }
    }

    private void addPersonPoints(Task task){
        task.getPerson().addPoints(task.getValue());
    }

    private Task createTask(String description, int value, Person person, LocalDateTime localDateTime){
        return new Task(description, value, person, localDateTime);
    }

    public Task selectTask(String description, int value, Person person, LocalDateTime localDateTime){
        Task task = new Task(description, value, person, localDateTime);
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).equals(task)){
                editTask = i;
                return task;
            }
        }
        return null;
    }

    public void deleteTask(String description, int value, Person person, LocalDateTime localDateTime) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).equals(createTask(description, value, person, localDateTime))) {
                tasks.remove(tasks.get(i));
            }
        }
    }

    public void editTask(Task task){
        tasks.set(editTask, task);
    }


    public Person selectPerson(String name, int points){
        Person person = new Person(name, points);
        for(int i = 0; i < persons.size(); i++){
            if(persons.get(i).equals(person)){
                editPerson = i;
                return person;
            }
        }
        return null;
    }

    public void deletePerson(String name) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).equals(new Person(name))) {
                persons.remove(persons.get(i));

            }
        }
    }

    public void editPerson(Person person){
        persons.set(editPerson, person);
    }


    public int sumAllPoints(List<Person> persons){
        int sum = 0;
        for (int i = 0; i < persons.size() ; i++) {
            sum += persons.get(i).getPoints();
        }
        return sum;
    }
}
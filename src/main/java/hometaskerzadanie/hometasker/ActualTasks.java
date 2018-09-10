package hometaskerzadanie.hometasker;

import hometaskerzadanie.hometasker.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActualTasks {

    private List<Task> tasks;

    public ActualTasks() {
        tasks = new ArrayList<>();
        tasks.add(new Task("Zmywanie podłogi", 4));
        tasks.add(new Task("Zmywanie naczyń", 6));
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task){
        tasks.add(task);
    }

}

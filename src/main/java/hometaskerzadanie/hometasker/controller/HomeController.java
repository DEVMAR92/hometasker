package hometaskerzadanie.hometasker.controller;

import hometaskerzadanie.hometasker.TaskRepository;
import hometaskerzadanie.hometasker.model.Person;
import hometaskerzadanie.hometasker.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {

    TaskRepository taskRepository;


    public HomeController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String homepage(Model model) {
        List<Task> taskList = taskRepository.getTasks();
        model.addAttribute("tasks", taskList);

        return "homepage";
    }

    @GetMapping("/archives")
    public String archives(Model model){
        List<Task> archives = taskRepository.getArchives();
        model.addAttribute("archives", archives);
        return "archives-task";
    }

    @GetMapping("/ranking")
    public String ranking(Model model){
        List<Person> persons = taskRepository.getPersons();
        int sum = taskRepository.sumAllPoints(persons);

        Collections.sort(persons);

        model.addAttribute("persons", persons);
        model.addAttribute("sum", sum);

        return "ranking-person";
    }

}

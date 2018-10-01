package hometaskerzadanie.hometasker.controller;

import hometaskerzadanie.hometasker.TaskRepository;
import hometaskerzadanie.hometasker.model.Person;
import hometaskerzadanie.hometasker.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PersonController {

    private TaskRepository taskRepository;

    public PersonController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/person")
    public String infoPerson(Model model,
                             @RequestParam Person person) {
        Person paramPerson = taskRepository.findByPerson(person);
        model.addAttribute("person", paramPerson);
        return "person";
    }

    @GetMapping("/person/add")
    public String addPerson(Model model) {
        model.addAttribute("newPerson", new Person());
        return "add-person";
    }

    @PostMapping("/person/add")
    public String addPerson(Person person) {
        taskRepository.addPerson(person);
        return "redirect:/";
    }

    @GetMapping("/person/add/points")
    public String addScore(@RequestParam String description,
                           @RequestParam int value,
                           @RequestParam Person person,
                           @RequestParam String localDateTime) {
        LocalDateTime dateTime = LocalDateTime.parse(localDateTime);
        taskRepository.addScore(description, value, person, dateTime);
        taskRepository.deleteTask(description, value, person, dateTime);
        return "redirect:/";
    }

    @GetMapping("/person/edit")
    public String editPerson(Model model,
                             @RequestParam String name,
                             @RequestParam int points) {
        Person person = taskRepository.selectPerson(name, points);
        model.addAttribute("editPerson", person);

        return "edit-person";
    }

    @PostMapping("/person/edit")
    public String editTask(Person person) {
        taskRepository.editPerson(person);
        return "redirect:/ranking";
    }

    @GetMapping("/person/remove")
    public String delete(@RequestParam String name) {

        taskRepository.deletePerson(name);
        return "redirect:/ranking";
    }
}

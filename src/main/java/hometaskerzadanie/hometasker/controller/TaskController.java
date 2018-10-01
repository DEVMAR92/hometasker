package hometaskerzadanie.hometasker.controller;
import hometaskerzadanie.hometasker.TaskRepository;
import hometaskerzadanie.hometasker.model.Person;
import hometaskerzadanie.hometasker.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/task/add")
    public String showAddForm(Model model) {
        List<Person> personList = taskRepository.getPersons();

        model.addAttribute("newTask", new Task());
        model.addAttribute("person", personList);

        return "/add-task";
    }

    @PostMapping("/task/add")
    public String addTask(Task task) {
        taskRepository.addTask(task);

        return "redirect:/";
    }

    @GetMapping("/task/edit")
    public String editPerson(Model model,
                             @RequestParam String description,
                             @RequestParam int value,
                             @RequestParam Person person,
                             @RequestParam String localDateTime){
        LocalDateTime localDateTime1 = LocalDateTime.parse(localDateTime);
        Task task = taskRepository.selectTask(description, value, person, localDateTime1);
        List<Person> persons = taskRepository.getPersons();

        model.addAttribute("editTask", task);
        model.addAttribute("editPerson", persons);

        return "edit-task";
    }

    @PostMapping("/task/edit")
    public String editTask(Task task){
        taskRepository.editTask(task);
        return "redirect:/";
    }

    @GetMapping("/task/remove")
    public String delete(@RequestParam String description,
                         @RequestParam int value,
                         @RequestParam Person person,
                         @RequestParam String localDateTime){
        LocalDateTime dateTime = LocalDateTime.parse(localDateTime);
        taskRepository.deleteTask(description , value, person, dateTime);
        return "redirect:/";
    }




}

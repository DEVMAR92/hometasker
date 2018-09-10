package hometaskerzadanie.hometasker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TaskController {

    ActualTasks actualTasks;

    public TaskController(ActualTasks actualTasks) {
        this.actualTasks = actualTasks;
    }

    @GetMapping("/dodaj-zadanie")
    public String showAddForm(Model model) {
        model.addAttribute("newTask", new Task());
        return "/add-task";
    }
    @PostMapping("/dodaj-zadanie")
    public String addTask(Task task) {
        actualTasks.addTask(task);
        return "redirect:/";
    }
}

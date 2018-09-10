package hometaskerzadanie.hometasker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    ActualTasks actualTasks;
    PersonRepository personRepository;

    public HomeController(ActualTasks actualTasks, PersonRepository personRepository) {
        this.actualTasks = actualTasks;
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    public String listOfTasks(Model model) {

        List<Task> taskList = actualTasks.getTasks();
        List<Person> personList = personRepository.getPesrons();

        model.addAttribute("persons", personList);
        model.addAttribute("tasks", taskList);

        return "homepage";
    }
}

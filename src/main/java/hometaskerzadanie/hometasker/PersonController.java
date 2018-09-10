package hometaskerzadanie.hometasker;

import hometaskerzadanie.hometasker.Person;
import hometaskerzadanie.hometasker.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PersonController {

    PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/dodaj-osobe")
    public String showAddForm(Model model) {
        model.addAttribute("newPerson", new Person());
        return "/add-person";
    }
    @PostMapping("/dodaj-osobe")
    public String addTask(Person person) {
        personRepository.addPerson(person);
        return "redirect:/";
    }
}

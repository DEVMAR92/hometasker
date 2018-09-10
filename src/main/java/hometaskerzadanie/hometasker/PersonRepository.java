package hometaskerzadanie.hometasker;

import hometaskerzadanie.hometasker.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    private List<Person> persons;

    public PersonRepository() {
        persons = new ArrayList<>();
        persons.add(new Person("Mama"));
        persons.add(new Person("Tata"));
        persons.add(new Person("Zosia"));

    }

    public List<Person> getPesrons() {
        return persons;
    }

    public void addPerson(Person person){
        persons.add(person);
    }


    public Person findByName(String name) {
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
}



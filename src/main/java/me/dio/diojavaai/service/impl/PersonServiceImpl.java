package me.dio.diojavaai.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import me.dio.diojavaai.model.Person;
import me.dio.diojavaai.repository.PersonRepository;
import me.dio.diojavaai.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService{

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public Person create(Person personToCreate) {
        return personRepository.save(personToCreate);
    }
    
}

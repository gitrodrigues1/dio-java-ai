package me.dio.diojavaai.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

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
        return personRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Person create(Person personToCreate) {
        if(personRepository.existsByAccountNumber(personToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This account number already exists");
        }
        return personRepository.save(personToCreate);
    }
    
}

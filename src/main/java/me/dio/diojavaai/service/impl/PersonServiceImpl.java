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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Person findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Person create(Person personToCreate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    
}

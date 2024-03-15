package me.dio.diojavaai.service;

import java.util.List;

import me.dio.diojavaai.model.Person;

public interface IPersonService {
    
    public List<Person> findAll();

    public Person findById(Long id);

    Person create(Person personToCreate);
}

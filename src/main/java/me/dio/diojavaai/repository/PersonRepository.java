package me.dio.diojavaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.diojavaai.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
    
}

package me.dio.diojavaai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import me.dio.diojavaai.model.Person;
import me.dio.diojavaai.service.IPersonService;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/person")
public class PersonController {
    
    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @Operation(summary = "Create a new user", description = "Create a new user and return created user's data.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "User created successfully"),
        @ApiResponse(responseCode = "404", description = "Invalid user data provided")
    })
    public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person) {
        var createdPerson = personService.create(person);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdPerson)
                .toUri();
        return ResponseEntity.created(location).body(createdPerson);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        var foundPerson = personService.findById(id);
        return ResponseEntity.ok(foundPerson);
    }
    

    
}

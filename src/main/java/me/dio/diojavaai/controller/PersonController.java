package me.dio.diojavaai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import me.dio.diojavaai.controller.exceptions.dto.PersonDto;
import me.dio.diojavaai.model.Person;
import me.dio.diojavaai.service.IPersonService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/person")
@Tag(name = "Person Controller", description = "Restful API for managing users")
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
    @Operation(summary = "Get Person by Id", description = "Retrieve a specific user based on its ID")
    @ApiResponses( value = {
        @ApiResponse(responseCode = "200", description = "Operation successful"),
        @ApiResponse(responseCode = "404", description = "Person not found")
    })
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        var foundPerson = personService.findById(id);
        return ResponseEntity.ok(foundPerson);
    }

    @GetMapping
    @Operation(summary = "Get all Person", description = "Retrieve all person")
    @ApiResponses( value = {
        @ApiResponse(responseCode = "200", description = "Operation successful"),
        @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<List<PersonDto>> findAll() {
        var person = personService.findAll();
        var personDto = person.stream()
                .map(PersonDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(personDto);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update a Person", description = "Update the data of an existing person based on its ID")
    @ApiResponses( value = {
        @ApiResponse(responseCode = "200", description = "User updated successfully"),
        @ApiResponse(responseCode = "404", description = "Not found"),
        @ApiResponse(responseCode = "422", description = "Invalid user data provided")
    })
    public ResponseEntity<PersonDto> updatePerson(@Valid @RequestBody PersonDto personDto, 
            @PathVariable Long id) {
        var person = personService.update(personDto.toModel(), id);
        return ResponseEntity.ok(new PersonDto(person));
    }

    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Person", description = "Delete an existing person based on its ID")
    @ApiResponses( value = {
        @ApiResponse(responseCode = "204", description = "User deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}

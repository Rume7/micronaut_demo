package com.codehacks.controller;

import com.codehacks.model.Message;
import com.codehacks.model.Person;
import com.codehacks.repository.PersonRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;

import javax.inject.Inject;
import javax.validation.Valid;

@Validated
@Controller("/persons")
public class PersonController {

    @Inject
    private PersonRepository personRepository;

    @Post(value = "/save", consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML},
    produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public HttpResponse<?> savePerson(@Body @Valid Person person) {
        this.personRepository.save(person);
        return HttpResponse.status(HttpStatus.CREATED)
                .body(new Message(HttpStatus.CREATED.getCode(), "Saved successfully!"));
    }

    @Get()
    public HttpResponse<?> getPersons() {
        return HttpResponse.status(HttpStatus.OK).body(this.personRepository.findAll());
    }
}

package com.mjtoolbox.newdvdrental.actor;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class ActorController {

    @Resource
    ActorRepository actorRepository;

    @GetMapping("/actors")
    public List<Actor> retrieveAllActors() {
        return StreamSupport.stream(actorRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/actors/{id}")
    public Actor findById(@PathVariable long id) {
        return actorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Actor not found with ID " + id));
    }

    @PostMapping("/actors")
    public Actor createActor(@Valid @RequestBody Actor actor) { // @Valid and @RequestBody passes through what's in the body
        return actorRepository.save(actor);
    }

    @PutMapping("/actors/{id}")
    public Actor updateActor( @PathVariable long id, @Valid @RequestBody Actor actor) {
        Actor actorFromDB = actorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Actor not found with ID: " + id));
        actorFromDB.setFirstName (actor.getFirstName());
        actorFromDB.setLastName(actor.getLastName());
        return actorRepository.save(actorFromDB);
    }

    @DeleteMapping("/actors/{id}")
    public void delete(@PathVariable long id) {
        actorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Actor not found with ID: " + id));
        actorRepository.deleteById(id);
    }
}

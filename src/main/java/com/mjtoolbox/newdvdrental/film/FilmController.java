package com.mjtoolbox.newdvdrental.film;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FilmController {
    @Resource
    FilmRepository filmRepository;

    @GetMapping("/films")
    public List<Film> retrieveAllFilms() {
        return StreamSupport.stream(filmRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}

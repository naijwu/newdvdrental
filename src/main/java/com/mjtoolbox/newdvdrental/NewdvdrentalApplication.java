package com.mjtoolbox.newdvdrental;

import com.mjtoolbox.newdvdrental.actor.Actor;
import com.mjtoolbox.newdvdrental.actor.ActorRepository;
import com.mjtoolbox.newdvdrental.film.Film;
import com.mjtoolbox.newdvdrental.film.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class NewdvdrentalApplication implements CommandLineRunner {

	@Resource
	private ActorRepository actorRepository;

	@Resource
	private FilmRepository filmRepository;

	public static void main(String[] args) {
		SpringApplication.run(NewdvdrentalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Film film = new Film();
		film.setTitle("Zootopia 2");
		film.setDescription("long movie");
		film.setRelease_year(1949);
		film.setLanguage_id(2);
		film.setRental_duration(5);
		film.setRental_rate(4.99);
		film.setReplacement_cost(300);

		Actor actor1 = new Actor();
		actor1.setFirstName("Blark");
		actor1.setLastName("Bable");

		Actor actor2 = new Actor();
		actor2.setFirstName("Livien");
		actor2.setLastName("Veigh");

		film.getActors().add(actor1);
		film.getActors().add(actor2);

		actor1.getFilms().add(film);
		actor2.getFilms().add(film);

		filmRepository.save(film);
	}

}

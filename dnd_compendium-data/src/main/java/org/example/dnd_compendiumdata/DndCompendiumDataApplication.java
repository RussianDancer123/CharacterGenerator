package org.example.dnd_compendiumdata;

import org.example.dnd_compendiumdata.repositories.RaceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DndCompendiumDataApplication implements CommandLineRunner {
	private final RaceRepository raceRepository;

    public DndCompendiumDataApplication(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(DndCompendiumDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		raceRepository.flush();
	}

}

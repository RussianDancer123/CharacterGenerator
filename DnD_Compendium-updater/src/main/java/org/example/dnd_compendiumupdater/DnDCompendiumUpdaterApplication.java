package org.example.dnd_compendiumupdater;

import org.example.dnd_compendiumupdater.updater.ICompendiumUpdater;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "org.example.dnd_compendiumdata.repositories")
@SpringBootApplication(scanBasePackages = "org.example")
public class DnDCompendiumUpdaterApplication implements CommandLineRunner {

    private final ICompendiumUpdater compendiumUpdater;

    public DnDCompendiumUpdaterApplication(ICompendiumUpdater compendiumUpdater) {
        this.compendiumUpdater = compendiumUpdater;
    }

    public static void main(String[] args) {
        SpringApplication.run(DnDCompendiumUpdaterApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        compendiumUpdater.updateCompendium();
    }
}

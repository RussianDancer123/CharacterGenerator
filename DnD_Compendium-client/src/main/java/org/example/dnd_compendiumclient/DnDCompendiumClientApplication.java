package org.example.dnd_compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.CompendiumClient;
import org.example.dnd_compendiumclient.compendiumclient.ICompendiumClient;
import org.example.dnd_compendiumclient.compendiumclient.ISpellsClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.example.dnd_compendiumclient.compendiumclient")
public class DnDCompendiumClientApplication implements CommandLineRunner {

	ICompendiumClient compendiumClient;

	public DnDCompendiumClientApplication(ICompendiumClient compendiumClient) {
		this.compendiumClient = compendiumClient;
	}

    public static void main(String[] args) {
		SpringApplication.run(DnDCompendiumClientApplication.class, args);
	}

	/**-----------------------TEST----------------------**/
	@Override
	public void run(String... args) throws Exception {
//		Main.test(compendiumClient);
	}
}

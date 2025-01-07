package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.DndCompendiumClientUriBuilderProvider;
import org.example.dnd_compendiumclient.compendiumclient.contract.IDndCompendiumClientUriBuilderProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CompendiumClientConfig {

    @Bean
    public IDndCompendiumClientUriBuilderProvider provider(@Value("${dnd5eapi.host}") String host){
        return new DndCompendiumClientUriBuilderProvider(host);
    }

    @Bean
    public ISpellsClient spellsClient(IDndCompendiumClientUriBuilderProvider uriBuilderProvider){
        return new SpellsClient(uriBuilderProvider);
    }

    @Bean IRaceClient raceClient(IDndCompendiumClientUriBuilderProvider uriBuilderProvider){
        return new RaceClient(uriBuilderProvider);
    }

    @Bean
    @Scope("prototype")
    public ICompendiumClient compendiumClient(IDndCompendiumClientUriBuilderProvider provider, ISpellsClient spellsClient, IRaceClient raceClient) {
        return new CompendiumClient(provider, spellsClient, raceClient);
    }
}

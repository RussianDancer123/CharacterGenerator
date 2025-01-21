package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.DndCompendiumClientUriBuilderProvider;
import org.example.dnd_compendiumclient.compendiumclient.contract.IDndCompendiumClientUriBuilderProvider;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.CompendiumEntryDetailsDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

public class SpellsClient implements ISpellsClient{

    RestTemplate restTemplate;
    IDndCompendiumClientUriBuilderProvider provider;

    public SpellsClient(IDndCompendiumClientUriBuilderProvider provider) {
        this.restTemplate = new RestTemplate();
        this.provider = provider;
    }

    @Override
    public CompendiumEntryResultDto getSpells() {
        var uri = provider.builder().pathSegment("spells").toUriString();
        return restTemplate.getForEntity(uri, CompendiumEntryResultDto.class).getBody();
    }

    @Override
    public CompendiumEntryDetailsDto getSpellDetails(String entityIndex) {
        var uri = provider.builder().pathSegment("spells", entityIndex).toUriString();
        return restTemplate.getForEntity(uri, CompendiumEntryDetailsDto.class).getBody();
    }
}

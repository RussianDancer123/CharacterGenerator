package org.example.dnd_compendiumclient.compendiumclient.client;

import org.example.dnd_compendiumclient.compendiumclient.contract.IDndCompendiumClientUriBuilderProvider;
import org.example.dnd_compendiumclient.compendiumclient.contract.SpellResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.CompendiumEntryDetailsDto;
import org.springframework.web.client.RestTemplate;

public class SpellsClient implements ISpellsClient{

    RestTemplate restTemplate;
    IDndCompendiumClientUriBuilderProvider provider;

    public SpellsClient(IDndCompendiumClientUriBuilderProvider provider) {
        this.restTemplate = new RestTemplate();
        this.provider = provider;
    }

    @Override
    public SpellResultDto getSpells() {
        var uri = provider.builder().pathSegment("spells").toUriString();
        return restTemplate.getForEntity(uri, SpellResultDto.class).getBody();
    }

    @Override
    public CompendiumEntryDetailsDto getSpellDetails(String entityIndex) {
        var uri = provider.builder().pathSegment("spells", entityIndex).toUriString();
        return restTemplate.getForEntity(uri, CompendiumEntryDetailsDto.class).getBody();
    }
}

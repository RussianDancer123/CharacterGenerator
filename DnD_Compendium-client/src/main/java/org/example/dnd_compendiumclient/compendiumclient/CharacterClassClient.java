package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.IDndCompendiumClientUriBuilderProvider;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.CharacterClassDetailsDto;
import org.springframework.web.client.RestTemplate;

public class CharacterClassClient implements ICharacterClassClient{
    RestTemplate restTemplate;
    IDndCompendiumClientUriBuilderProvider provider;

    public CharacterClassClient(IDndCompendiumClientUriBuilderProvider provider) {
        this.provider = provider;
        restTemplate = new RestTemplate();
    }

    @Override
    public CompendiumEntryResultDto getCharacterClasses() {
        var uri = provider.builder().pathSegment("classes").toUriString();
        return restTemplate.getForEntity(uri, CompendiumEntryResultDto.class).getBody();
    }

    @Override
    public int getCharacterClassHitDie(String entityIndex) {
        var uri = provider.builder().pathSegment("classes", entityIndex).toUriString();
        return restTemplate.getForEntity(uri, CharacterClassDetailsDto.class).getBody().hitDie();
    }
}

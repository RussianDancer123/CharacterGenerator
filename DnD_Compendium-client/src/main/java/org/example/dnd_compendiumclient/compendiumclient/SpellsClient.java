package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.SpellResultDto;
import org.springframework.web.client.RestTemplate;

public class SpellsClient implements ISpellsClient{

    RestTemplate restTemplate;

    public SpellsClient() {
        restTemplate = new RestTemplate();
    }

    @Override
    public SpellResultDto getSpells() {
        String uri = "https://www.dnd5eapi.co/api/spells";
        return restTemplate.getForEntity(uri, SpellResultDto.class).getBody();
    }
}

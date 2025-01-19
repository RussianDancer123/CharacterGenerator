package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.IDndCompendiumClientUriBuilderProvider;
import org.springframework.web.client.RestTemplate;

public class SubRaceClient implements ISubRaceClient {

    private final IDndCompendiumClientUriBuilderProvider provider;
    private final RestTemplate restTemplate = new RestTemplate();

    public SubRaceClient(IDndCompendiumClientUriBuilderProvider provider) {
        this.provider = provider;
    }

    @Override
    public CompendiumEntryResultDto getSubRaces() {
        var uri = provider.builder().pathSegment("subraces").toUriString();
        return restTemplate.getForEntity(uri, CompendiumEntryResultDto.class).getBody();
    }
}

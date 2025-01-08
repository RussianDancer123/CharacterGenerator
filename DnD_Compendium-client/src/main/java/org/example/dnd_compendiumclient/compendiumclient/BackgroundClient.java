package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.IDndCompendiumClientUriBuilderProvider;
import org.springframework.web.client.RestTemplate;

public class BackgroundClient implements IBackgroundClient {
    RestTemplate restTemplate;
    IDndCompendiumClientUriBuilderProvider provider;

    public BackgroundClient(IDndCompendiumClientUriBuilderProvider provider) {
        restTemplate = new RestTemplate();
        this.provider = provider;
    }

    @Override
    public CompendiumEntryResultDto getBackgrounds() {
        var uri = provider.builder().pathSegment("backgrounds").toUriString();
        return restTemplate.getForEntity(uri, CompendiumEntryResultDto.class).getBody();
    }
}

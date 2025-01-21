package org.example.dnd_compendiumclient.compendiumclient.client;

import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.IDndCompendiumClientUriBuilderProvider;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.AlignmentetailsDto;
import org.springframework.web.client.RestTemplate;

public class AlignmentClient implements IAlignmentClient {
    RestTemplate restTemplate;
    IDndCompendiumClientUriBuilderProvider provider;

    public AlignmentClient(IDndCompendiumClientUriBuilderProvider provider) {
        this.restTemplate = new RestTemplate();
        this.provider = provider;
    }

    @Override
    public CompendiumEntryResultDto getAlignments() {
        var uri = provider.builder().pathSegment("alignments").toUriString();
        return restTemplate.getForEntity(uri, CompendiumEntryResultDto.class).getBody();
    }

    @Override
    public String getAlignmentDetails(String index) {
        var uri = provider.builder().pathSegment("alignments", index).toUriString();
        return restTemplate.getForEntity(uri, AlignmentetailsDto.class).getBody().desc();
    }
}

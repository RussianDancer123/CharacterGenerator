package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.AlignmentResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.IDndCompendiumClientUriBuilderProvider;
import org.springframework.web.client.RestTemplate;

public class AlignmentClient implements IAlignmentClient {
    RestTemplate restTemplate;
    IDndCompendiumClientUriBuilderProvider provider;

    public AlignmentClient(IDndCompendiumClientUriBuilderProvider provider) {
        this.restTemplate = new RestTemplate();
        this.provider = provider;
    }

    @Override
    public AlignmentResultDto getAlignments() {
        var uri = provider.builder().pathSegment("alignments").toUriString();
        return restTemplate.getForEntity(uri, AlignmentResultDto.class).getBody();
    }
}
package org.example.dnd_compendiumclient.compendiumclient.client;

import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.IDndCompendiumClientUriBuilderProvider;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.CompendiumEntryDetailsDto;
import org.springframework.web.client.RestTemplate;

public class SkillClient implements ISkillClient {
    private final IDndCompendiumClientUriBuilderProvider provider;
    private final RestTemplate restTemplate = new RestTemplate();

    public SkillClient(IDndCompendiumClientUriBuilderProvider provider) {
        this.provider = provider;
    }

    @Override
    public CompendiumEntryResultDto getSkillls() {
        var uri = provider.builder().pathSegment("skills").toUriString();
        return restTemplate.getForEntity(uri, CompendiumEntryResultDto.class).getBody();
    }

    @Override
    public CompendiumEntryDetailsDto getSkillDetails(String entityIndex) {
        var uri = provider.builder().pathSegment("skills", entityIndex).toUriString();
        return restTemplate.getForEntity(uri, CompendiumEntryDetailsDto.class).getBody();
    }
}

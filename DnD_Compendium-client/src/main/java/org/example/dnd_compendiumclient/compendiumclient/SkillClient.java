package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.IDndCompendiumClientUriBuilderProvider;
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
}

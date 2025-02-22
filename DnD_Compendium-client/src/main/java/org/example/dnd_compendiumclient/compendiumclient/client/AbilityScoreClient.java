package org.example.dnd_compendiumclient.compendiumclient.client;

import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.IDndCompendiumClientUriBuilderProvider;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.AbilityScoreDetailsDto;
import org.springframework.web.client.RestTemplate;

public class AbilityScoreClient implements IAbilityScoreClient {
    RestTemplate restTemplate;
    IDndCompendiumClientUriBuilderProvider provider;

    public AbilityScoreClient(IDndCompendiumClientUriBuilderProvider provider) {
        this.provider = provider;
        restTemplate = new RestTemplate();
    }

    @Override
    public CompendiumEntryResultDto getAbilityScore() {
        var uri = provider.builder().pathSegment("ability-scores").toUriString();
        return restTemplate.getForEntity(uri, CompendiumEntryResultDto.class).getBody();
    }

    @Override
    public AbilityScoreDetailsDto getAbilityScoreDetails(String entityIndex) {
        var uri = provider.builder().pathSegment("ability-scores", entityIndex).toUriString();
        return restTemplate.getForEntity(uri, AbilityScoreDetailsDto.class).getBody();
    }
}

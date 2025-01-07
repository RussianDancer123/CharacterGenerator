package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.AbilityScoreDetailDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.AbilityScoreResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.IDndCompendiumClientUriBuilderProvider;
import org.springframework.web.client.RestTemplate;

public class AbilityScoreClient implements IAbilityScoreClient {
    RestTemplate restTemplate;
    IDndCompendiumClientUriBuilderProvider provider;

    public AbilityScoreClient(IDndCompendiumClientUriBuilderProvider provider) {
        this.provider = provider;
        restTemplate = new RestTemplate();
    }

    @Override
    public AbilityScoreResultDto getAbilityScore() {
        var uri = provider.builder().pathSegment("ability-scores").toUriString();
        return restTemplate.getForEntity(uri, AbilityScoreResultDto.class).getBody();
    }

    @Override
    public AbilityScoreDetailDto getAbilityScoreDetail(String index){
        var uri = provider.builder().pathSegment("ability-scores").pathSegment(index).toUriString();
        return restTemplate.getForEntity(uri, AbilityScoreDetailDto.class).getBody();
    }
}

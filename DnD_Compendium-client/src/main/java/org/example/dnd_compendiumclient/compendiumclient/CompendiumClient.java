package org.example.dnd_compendiumclient.compendiumclient;

import lombok.Getter;
import org.example.dnd_compendiumclient.compendiumclient.contract.AbilityScoreResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.IDndCompendiumClientUriBuilderProvider;
import org.springframework.web.client.RestTemplate;

@Getter
public class CompendiumClient implements ICompendiumClient{
    private final IDndCompendiumClientUriBuilderProvider provider;
    private final RestTemplate restTemplate;

    private final ISpellsClient spellsClient;
    private final IRaceClient raceClient;


    public CompendiumClient(IDndCompendiumClientUriBuilderProvider provider, ISpellsClient spellsClient, IRaceClient raceClient) {
        this.provider = provider;
        restTemplate = new RestTemplate();

        this.spellsClient = spellsClient;
        this.raceClient = raceClient;
    }

    @Override
    public AbilityScoreResultDto getAbilityScore() {
        var uri = provider.builder().pathSegment("ability-scores").toUriString();
        return restTemplate.getForEntity(uri, AbilityScoreResultDto.class).getBody();
    }

}

package org.example.dnd_compendiumclient.compendiumclient;

import lombok.Getter;
import org.example.dnd_compendiumclient.compendiumclient.contract.IDndCompendiumClientUriBuilderProvider;
import org.springframework.web.client.RestTemplate;

@Getter
public class CompendiumClient implements ICompendiumClient{
    private final IDndCompendiumClientUriBuilderProvider provider;
    private final RestTemplate restTemplate;

    private final IAbilityScoreClient abilityScoreClient;
    private final IAlignmentClient alignmentClient;
    private final IBackgroundClient backgroundClient;
    private final ICharacterClassClient characterClassClient;
    private final ISpellsClient spellsClient;
    private final ISkillClient skillClient;
    private final IRaceClient raceClient;


    public CompendiumClient(IDndCompendiumClientUriBuilderProvider provider, IAbilityScoreClient abilityScoreClient, IAlignmentClient alignmentClient, IBackgroundClient backgroundClient, ICharacterClassClient characterClassClient, ISpellsClient spellsClient, ISkillClient skillClient, IRaceClient raceClient) {
        this.provider = provider;
        this.skillClient = skillClient;
        restTemplate = new RestTemplate();

        this.abilityScoreClient = abilityScoreClient;
        this.alignmentClient = alignmentClient;
        this.backgroundClient = backgroundClient;
        this.characterClassClient = characterClassClient;
        this.spellsClient = spellsClient;
        this.raceClient = raceClient;
    }

}

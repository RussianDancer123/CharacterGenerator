package org.example.dnd_compendiumclient.compendiumclient.client;

import org.example.dnd_compendiumclient.compendiumclient.contract.DndCompendiumClientUriBuilderProvider;
import org.example.dnd_compendiumclient.compendiumclient.contract.IDndCompendiumClientUriBuilderProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CompendiumClientConfig {

    @Bean
    public IDndCompendiumClientUriBuilderProvider provider(@Value("${dnd5eapi.host}") String host){
        return new DndCompendiumClientUriBuilderProvider(host);
    }

    @Bean
    public IAbilityScoreClient abilityScoreClient(IDndCompendiumClientUriBuilderProvider uriBuilderProvider){
        return new AbilityScoreClient(uriBuilderProvider);
    }

    @Bean
    public IAlignmentClient alignmentClient(IDndCompendiumClientUriBuilderProvider uriBuilderProvider){
        return new AlignmentClient(uriBuilderProvider);
    }

    @Bean
    public IBackgroundClient backgroundClient(IDndCompendiumClientUriBuilderProvider uriBuilderProvider){
        return new BackgroundClient(uriBuilderProvider);
    }

    @Bean
    public ICharacterClassClient characterClassClient(IDndCompendiumClientUriBuilderProvider uriBuilderProvider){
        return new CharacterClassClient(uriBuilderProvider);
    }

    @Bean
    public ISpellsClient spellsClient(IDndCompendiumClientUriBuilderProvider uriBuilderProvider){
        return new SpellsClient(uriBuilderProvider);
    }

    @Bean
    public ISkillClient skillClient(IDndCompendiumClientUriBuilderProvider uriBuilderProvider){
        return new SkillClient(uriBuilderProvider);
    }

    @Bean
    public IRaceClient raceClient(IDndCompendiumClientUriBuilderProvider uriBuilderProvider){
        return new RaceClient(uriBuilderProvider);
    }

    @Bean
    @Scope("prototype")
    public ICompendiumClient compendiumClient(IDndCompendiumClientUriBuilderProvider provider
            , IAbilityScoreClient abilityScoreClient
            , IAlignmentClient alignmentClient
            , IBackgroundClient backgroundClient
            , ICharacterClassClient characterClassClient
            , ISpellsClient spellsClient
            , ISkillClient skillClient
            , IRaceClient raceClient) {
        return new CompendiumClient(provider
                , abilityScoreClient
                , alignmentClient
                , backgroundClient
                , characterClassClient
                , spellsClient
                , skillClient
                , raceClient);
    }
}

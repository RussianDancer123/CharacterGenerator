package org.example.dnd_compendiumdata.repositories;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AllRepositories {
    private final AbilityScoreRepository abilityScoreRepository;
    private final AlignmentRepository alignmentRepository;
    private final BackgroundRepository backgroundRepository;
    private final CharacterClassRepository characterClassRepository;
    private final PlayerCharacterRepository playerCharacterRepository;
    private final SpellRepository spellRepository;
    private final SpellDetailsRepository spellDetailsRepository;
    SubRaceRepository subRaceRepository;
    private final RaceDetailsRepository raceDetailsRepository;
    private final RaceRepository raceRepository;

    public AllRepositories(AbilityScoreRepository abilityScoreRepository, AlignmentRepository alignmentRepository, BackgroundRepository backgroundRepository, CharacterClassRepository characterClassRepository, PlayerCharacterRepository playerCharacterRepository, SpellRepository spellRepository, SpellDetailsRepository spellDetailsRepository, RaceDetailsRepository raceDetailsRepository, RaceRepository raceRepository) {
        this.abilityScoreRepository = abilityScoreRepository;
        this.alignmentRepository = alignmentRepository;
        this.backgroundRepository = backgroundRepository;
        this.characterClassRepository = characterClassRepository;
        this.playerCharacterRepository = playerCharacterRepository;
        this.spellRepository = spellRepository;
        this.spellDetailsRepository = spellDetailsRepository;
        this.raceDetailsRepository = raceDetailsRepository;
        this.raceRepository = raceRepository;
    }
}

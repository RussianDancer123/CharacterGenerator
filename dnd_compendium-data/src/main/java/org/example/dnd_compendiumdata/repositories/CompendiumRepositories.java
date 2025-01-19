package org.example.dnd_compendiumdata.repositories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class CompendiumRepositories {
    private final AbilityScore_ValueRepository abilityScore_ValueRepository;
    private final AbilityScoreRepository abilityScoreRepository;
    private final AlignmentRepository alignmentRepository;
    private final CharacterClassRepository characterClassRepository;
    private final PlayerCharacterRepository playerCharacterRepository;
    private final RaceDetailsRepository raceDetailsRepository;
    private final RaceRepository raceRepository;
    private final SkillDetailsRepository skillDetailsRepository;
    private final SkillRepository skillRepository;
    private final SpellDetailsRepository spellDetailsRepository;
    private final SpellRepository spellRepository;
    private final SubRaceRepository subRaceRepository;

}

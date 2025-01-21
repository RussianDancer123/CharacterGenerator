package org.example.dnd_compendiumwebapi.contract;

import org.example.dnd_compendiumdata.model.AbilityScore_Value;
import org.example.dnd_compendiumdata.model.CharacterClass;

import java.util.List;

public record PlayerCharacterDto(String playerName,
                                 String name,
                                 String gender,
                                 int level,
                                 CharacterClassDto characterClassDto,
                                 SubRaceDto subRaceDto,
                                 AlignmentDto alignmentDto,
                                 int experience,
                                 RaceDto raceDto,
                                 List<AbilityScore_ValueDto> abilityScoreValueDto,
                                 List<SpellDto> spellDto,
                                 List<SkillDto> skillDto) {

}

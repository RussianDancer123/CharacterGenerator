package org.example.dnd_compendiumwebapi.contract;

import org.example.dnd_compendiumdata.model.AbilityScore_Value;
import org.example.dnd_compendiumdata.model.CharacterClass;

import java.util.List;

public record PlayerCharacterDto(String playerName,
                                 String name,
                                 CharacterClassDto characterClassDto,
                                 int classLevel,
                                 BackgroundDto backgroundDto,
                                 SubRaceDto subRaceDto,
                                 AlignmentDto alignmentDto,
                                 int experience,
                                 RaceDto raceDto,
                                 List<AbilityScore_Value> abilityScoreValues,
                                 List<SpellDto> spellDto) {

}

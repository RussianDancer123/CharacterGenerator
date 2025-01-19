package org.example.dnd_compendiumwebapi.mapper;

import org.example.dnd_compendiumdata.model.*;
import org.example.dnd_compendiumwebapi.contract.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Optional;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApiGenericMapper {

    PlayerCharacterDto toPlayerCharacterDto(PlayerCharacter playercharacter);
    PlayerCharacter toPlayerCharacter(PlayerCharacterDto playerCharacterDto);
    CharacterClassDto toCharacterClassDto(CharacterClass characterclass);
    BackgroundDto toBackgroundDto(Background background);
    SubRaceDto toSubRaceDto(SubRace subrace);
    AlignmentDto toAlignmentDto(Alignment alignment);
    RaceDto toRaceDto(Race race);
    SpellDto toSpellDto(Spell spell);
    SkillDto toSkillDto(Skill skill);
}

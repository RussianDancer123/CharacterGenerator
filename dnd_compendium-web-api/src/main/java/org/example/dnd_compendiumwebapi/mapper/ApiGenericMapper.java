package org.example.dnd_compendiumwebapi.mapper;

import org.example.dnd_compendiumdata.model.*;
import org.example.dnd_compendiumwebapi.contract.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Optional;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApiGenericMapper {

    PlayerCharacterDto toPlayerCharacterDto(PlayerCharacter playercharacter);
    PlayerCharacter toPlayerCharacter(PlayerCharacterDto playerCharacterDto);
    CharacterClassDto toCharacterClassDto(CharacterClass characterclass);
    SubRaceDto toSubRaceDto(SubRace subrace);
    AlignmentDto toAlignmentDto(Alignment alignment);
    RaceDto toRaceDto(Race race);
    @Mapping(target = "index", source = "entityIndex")
    SpellDto toSpellDto(Spell spell);
    SpellDetailsDto toSpellDetailsDto(Spell spell);
    @Mapping(target = "index", source = "entityIndex")
    SkillDto toSkillDto(Skill skill);
    SkillDetailsDto toSkillDetailsDto(Skill skill);
}

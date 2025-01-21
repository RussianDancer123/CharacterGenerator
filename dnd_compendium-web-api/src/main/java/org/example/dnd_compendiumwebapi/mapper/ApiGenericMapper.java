package org.example.dnd_compendiumwebapi.mapper;

import org.example.dnd_compendiumdata.model.*;
import org.example.dnd_compendiumwebapi.contract.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Optional;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApiGenericMapper {

    @Mapping(target = "index", source = "entityIndex")
    CharacterClassDto toCharacterClassDto(CharacterClass characterclass);
    @Mapping(target = "index", source = "entityIndex")
    SubRaceDto toSubRaceDto(SubRace subrace);
    @Mapping(target = "index", source = "entityIndex")
    AlignmentDto toAlignmentDto(Alignment alignment);
    @Mapping(target = "index", source = "entityIndex")
    RaceDto toRaceDto(Race race);
    @Mapping(target = "index", source = "entityIndex")
    SpellDto toSpellDto(Spell spell);
    SpellDetailsDto toSpellDetailsDto(Spell spell);
    @Mapping(target = "index", source = "entityIndex")
    SkillDto toSkillDto(Skill skill);
    SkillDetailsDto toSkillDetailsDto(Skill skill);
}

package org.example.dnd_compendiumupdater.mapper;

import jakarta.persistence.ManyToOne;
import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.SpellDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.CompendiumEntryDetailsDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.RaceDetailDto;
import org.example.dnd_compendiumdata.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GenericMapper {
    @Mapping(target = "entityIndex", source = "index")
    Race toRace(CompendiumEntryDto entry);

    @Mapping(target = "entityIndex", source = "index")
    RaceDetails toRaceDetails(RaceDetailDto entry);

    @Mapping(target = "entityIndex", source = "index")
    AbilityScore toAbilityScore(CompendiumEntryDto entry);

    @Mapping(target = "entityIndex", source = "index")
    Spell toSpell(CompendiumEntryDto entry);

    @Mapping(target = "entityIndex", source = "index")
    SubRace toSubRace(CompendiumEntryDto entry);

    @Mapping(target = "entityIndex", source = "index")
    @Mapping(target = "description", ignore = true)
    SpellDetails toSpellDetails(CompendiumEntryDetailsDto spellDetailsDto);

    @Mapping(target = "entityIndex", source = "index")
    @Mapping(target = "description", ignore = true)
    SkillDetails toSkillDetails(CompendiumEntryDetailsDto skillDetailsDto);

    @Mapping(target = "entityIndex", source = "index")
    Skill toSkill(CompendiumEntryDto entryDto);

    @Mapping(target = "entityIndex", source = "index")
    Alignment toAlignment(CompendiumEntryDto entryDto);
}

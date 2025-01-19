package org.example.dnd_compendiumupdater.mapper;

import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.SpellDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.RaceDetailDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.SpellDetailDto;
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
    Background toBackground(CompendiumEntryDto entry);

    @Mapping(target = "entityIndex", source = "index")
    Spell toSpell(SpellDto entry);

    @Mapping(target = "entityIndex", source = "index")
    SubRace toSubRace(CompendiumEntryDto entry);

    @Mapping(target = "entityIndex", source = "index")
    SpellDetails toSpellDetails(SpellDetailDto spellDetailsDto);

    @Mapping(target = "entityIndex", source = "index")
    Skill toSkill(CompendiumEntryDto entryDto);
}

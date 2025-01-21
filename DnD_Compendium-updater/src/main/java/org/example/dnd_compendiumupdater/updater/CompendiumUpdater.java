package org.example.dnd_compendiumupdater.updater;

import jakarta.transaction.Transactional;
import org.example.dnd_compendiumclient.compendiumclient.*;
import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.AbilityScoreDetailsDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.CompendiumEntryDetailsDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.RaceDetailDto;
import org.example.dnd_compendiumdata.model.*;
import org.example.dnd_compendiumdata.repositories.*;
import org.example.dnd_compendiumupdater.mapper.GenericMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CompendiumUpdater implements ICompendiumUpdater {

    private final ICompendiumClient compendiumClient;
    private final CompendiumRepositories compendiumRepositories;
    private final GenericMapper genericMapper;

    public CompendiumUpdater(ICompendiumClient compendiumClient, CompendiumRepositories compendiumRepositories, GenericMapper genericMapper){
        this.compendiumClient = compendiumClient;
        this.compendiumRepositories = compendiumRepositories;
        this.genericMapper = genericMapper;
    }

    @Override
    public void updateCompendium() {
        updateAbilityScore();
        updateAlignment();
        updateCharacterClass();
        updateRace();
        updateSkill();
        updateSpell();
        updateSubRace();
    }

    private void updateAlignment(){
        IAlignmentClient client = compendiumClient.getAlignmentClient();
        AlignmentRepository repo = compendiumRepositories.getAlignmentRepository();

        List<CompendiumEntryDto> alignmentDto = client.getAlignments().results();
        List<Alignment> alignments = alignmentDto.stream().map(genericMapper::toAlignment).toList();

        List<String> duplicateIndex = repo
                .findAll().stream()
                .map(Alignment::getEntityIndex).toList();
        alignments = alignments.stream().filter(a -> !duplicateIndex.contains(a.getEntityIndex())).toList();

        alignments.forEach(this::updateAlignmentDescription);

        repo.saveAll(alignments);
    }

    private void updateAlignmentDescription(Alignment alignment){
        IAlignmentClient client = compendiumClient.getAlignmentClient();
        AlignmentRepository repo = compendiumRepositories.getAlignmentRepository();

        String alignmentDetails = client.getAlignmentDetails(alignment.getEntityIndex());
        alignment.setDescription(alignmentDetails);
    }

    private void updateRace(){
        IRaceClient client = compendiumClient.getRaceClient();
        RaceRepository repo = compendiumRepositories.getRaceRepository();

        List<CompendiumEntryDto> raceDto = client.getRaces().results();
        List<Race> races = raceDto.stream().map(genericMapper::toRace).toList();

        List<String> duplicateIndex = repo
                .findAll().stream()
                .map(Race::getEntityIndex).toList();
        races = races.stream().filter(r -> !duplicateIndex.contains(r.getEntityIndex())).toList();

        races.forEach(this::updateRaceDetails);

        repo.saveAll(races);
    }

    private void updateRaceDetails(Race race) {
        IRaceClient client = compendiumClient.getRaceClient();
        RaceDetailsRepository repo = compendiumRepositories.getRaceDetailsRepository();

        RaceDetailDto raceDetailsDto = client.getRaceDetailByIndex(race.getEntityIndex());
        RaceDetails raceDetails = genericMapper.toRaceDetails(raceDetailsDto);
        race.setRaceDetails(raceDetails);
        repo.save(raceDetails);
    }

    private void updateAbilityScore() {
        IAbilityScoreClient client = compendiumClient.getAbilityScoreClient();
        AbilityScoreRepository repo = compendiumRepositories.getAbilityScoreRepository();

        List<CompendiumEntryDto> abilityScoreDto = client.getAbilityScore().results();
        List<AbilityScore> abilityScores = abilityScoreDto.stream().map(genericMapper::toAbilityScore).toList();

        List<String> duplicates = repo
                .findAll().stream()
                .map(AbilityScore::getEntityIndex).toList();
        abilityScores = abilityScores.stream().filter(as -> !duplicates.contains(as.getEntityIndex())).toList();

        abilityScores.forEach(as -> {
            AbilityScoreDetailsDto abilityScoreDetailDto = client.getAbilityScoreDetails(as.getEntityIndex());
            as.setDescription(String.join(" ", abilityScoreDetailDto.description()));
            as.setFullName(abilityScoreDetailDto.fullName());
        });

        repo.saveAll(abilityScores);
    }

    private void updateCharacterClass(){

    }

    private void updateSpell(){
        ISpellsClient client = compendiumClient.getSpellsClient();
        SpellRepository repo = compendiumRepositories.getSpellRepository();

        List<CompendiumEntryDto> spellDto = client.getSpells().results();
        List<Spell> spells = spellDto.stream().map(genericMapper::toSpell).toList();

        List<String> duplicates = repo
                .findAll().stream()
                .map(Spell::getEntityIndex).toList();
        spells = spells.stream().filter(as -> !duplicates.contains(as.getEntityIndex())).toList();

        spells.forEach(this::updateSpellDetail);

        repo.saveAll(spells);
    }

    private void updateSpellDetail(Spell spell){
        ISpellsClient client = compendiumClient.getSpellsClient();
        SpellDetailsRepository repo = compendiumRepositories.getSpellDetailsRepository();

        CompendiumEntryDetailsDto spellDetailsDto = client.getSpellDetails(spell.getEntityIndex());
        SpellDetails spellDetails = genericMapper.toSpellDetails(spellDetailsDto);
        spellDetails.setDescription(String.join(" ", spellDetailsDto.description()));
        spell.setDetails(spellDetails);
        repo.save(spellDetails);
    }

    private void updateSkill(){
        ISkillClient client = compendiumClient.getSkillClient();
        SkillRepository repo = compendiumRepositories.getSkillRepository();

        List<CompendiumEntryDto> spellDto = client.getSkillls().results();
        List<Skill> skills = spellDto.stream().map(genericMapper::toSkill).toList();

        List<String> duplicates = repo
                .findAll().stream()
                .map(Skill::getEntityIndex).toList();
        skills = skills.stream().filter(as -> !duplicates.contains(as.getEntityIndex())).toList();

        skills.forEach(this::updateSkillDetails);

        repo.saveAll(skills);
    }

    private void updateSkillDetails(Skill skill){
        ISkillClient client = compendiumClient.getSkillClient();
        SkillDetailsRepository repo = compendiumRepositories.getSkillDetailsRepository();

        CompendiumEntryDetailsDto skillDetailsDto = client.getSkillDetails(skill.getEntityIndex());
        SkillDetails skillDetails = genericMapper.toSkillDetails(skillDetailsDto);
        skillDetails.setDescription(String.join(" ", skillDetailsDto.description()));
        skill.setDetails(skillDetails);
        repo.save(skillDetails);
    }

    private void updateSubRace(){
        IRaceClient client = compendiumClient.getRaceClient();
        SubRaceRepository repo = compendiumRepositories.getSubRaceRepository();

        List<CompendiumEntryDto> subRaceDto = client.getSubRaces().results();
        List<SubRace> races = subRaceDto.stream().map(genericMapper::toSubRace).toList();

        List<String> duplicates = repo
                .findAll().stream()
                .map(SubRace::getEntityIndex).toList();
        races = races.stream().filter(r -> !duplicates.contains(r.getEntityIndex())).toList();

        repo.saveAll(races);
    }

}

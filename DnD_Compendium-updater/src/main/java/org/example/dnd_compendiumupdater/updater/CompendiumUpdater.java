package org.example.dnd_compendiumupdater.updater;

import jakarta.transaction.Transactional;
import org.example.dnd_compendiumclient.compendiumclient.*;
import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.SpellDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.AbilityScoreDetailDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.RaceDetailDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.SpellDetailDto;
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

    private void deleteAll(){
        compendiumRepositories.getRaceRepository().deleteAll();
        compendiumRepositories.getRaceDetailsRepository().deleteAll();
        compendiumRepositories.getAbilityScoreRepository().deleteAll();
    }

    @Override
    public void updateCompendium() {
//        deleteAll();

        updateRace();
        updateRaceDetails();
        updateAbilityScore();
        updateCharacterClass();
        updateSpell();
        updateSkill();
        updateSubRace();
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

        repo.saveAll(races);
    }

    private void updateRaceDetails() {
        IRaceClient client = compendiumClient.getRaceClient();
        RaceRepository repo = compendiumRepositories.getRaceRepository();
        RaceDetailsRepository detailRepo = compendiumRepositories.getRaceDetailsRepository();

        List<Race> races = repo.findAll();
        for (Race race : races) {
            List<String> duplicate = detailRepo.findAll().stream().map(RaceDetails::getEntityIndex).toList();
            if(duplicate.contains(race.getEntityIndex()))   continue;

            RaceDetailDto raceDetailDto = client.getRaceDetailByIndex(race.getEntityIndex());
            RaceDetails raceDetails = genericMapper.toRaceDetails(raceDetailDto);
            race.setRaceDetails(raceDetails);
            detailRepo.save(raceDetails);
        }
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
            AbilityScoreDetailDto abilityScoreDetailDto = client.getAbilityScoreDetail(as.getEntityIndex());
            as.setDescription(String.join(" ", abilityScoreDetailDto.desc()));
            as.setFullName(abilityScoreDetailDto.fullName());
        });

        repo.saveAll(abilityScores);
    }

    private void updateCharacterClass(){

    }

    private void updateSpell(){
        ISpellsClient client = compendiumClient.getSpellsClient();
        SpellRepository repo = compendiumRepositories.getSpellRepository();

        List<SpellDto> spellDto = client.getSpells().results();
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

        SpellDetailDto spellDetailsDto = client.getSpellDetails(spell.getEntityIndex());
        SpellDetails spellDetails = genericMapper.toSpellDetails(spellDetailsDto);
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
        /*to do skillDetail model*/
//        skills.forEach(this::updateSkillDetails);

        repo.saveAll(skills);
    }

    private void updateSkillDetail(Skill skill){
//        ISkillClient client = compendiumClient.getSkillClient();
//        SpellDetailsRepository repo = compendiumRepositories.getSpellDetailsRepository();
//
//        SpellDetailDto spellDetailsDto = client.getSkillDetails(skill.getEntityIndex());
//        SpellDetails spellDetails = genericMapper.toSpellDetails(spellDetailsDto);
//        skill.setDetails(spellDetails);
//        repo.save(spellDetails);
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

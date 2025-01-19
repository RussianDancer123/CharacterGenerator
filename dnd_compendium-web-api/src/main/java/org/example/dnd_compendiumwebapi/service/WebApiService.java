package org.example.dnd_compendiumwebapi.service;

import jakarta.transaction.Transactional;
import org.example.dnd_compendiumdata.model.*;
import org.example.dnd_compendiumdata.repositories.CompendiumRepositories;
import org.example.dnd_compendiumupdater.updater.ICompendiumUpdater;
import org.example.dnd_compendiumwebapi.contract.*;
import org.example.dnd_compendiumwebapi.mapper.ApiGenericMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class WebApiService {

    private final CompendiumRepositories compendiumRepositories;
    private final ApiGenericMapper genericMapper;
    private final ICompendiumUpdater compendiumUpdater;

    public WebApiService(CompendiumRepositories compendiumRepositories, ApiGenericMapper genericMapper, ICompendiumUpdater compendiumUpdater) {
        this.compendiumRepositories = compendiumRepositories;
        this.genericMapper = genericMapper;
        this.compendiumUpdater = compendiumUpdater;
    }

    public void update(){
        compendiumUpdater.updateCompendium();
    }

    /**
     * test
     */
//    public ResponseEntity<PlayerCharacterDto> generatePlayerCharacter() {
//        PlayerCharacterDto playerCharacterDto = new PlayerCharacterDto();
//
//        return ResponseEntity.ok(playerCharacterDto);
//    }

    public ResponseEntity<PlayerCharacterDto> getCharacterById(int id){
        PlayerCharacter playercharacter = compendiumRepositories.getPlayerCharacterRepository().findById(id).orElse(null);
        return ResponseEntity.ok(genericMapper.toPlayerCharacterDto(playercharacter));
    }

    public ResponseEntity<Boolean> deleteCharacterById(int id){
        compendiumRepositories.getPlayerCharacterRepository().deleteById(id);
        return ResponseEntity.ok(true);
    }

    public ResponseEntity<PlayerCharacterDto> saveCharacter(PlayerCharacterDto playerCharacterDto){
        PlayerCharacter playerCharacter = genericMapper.toPlayerCharacter(playerCharacterDto);
        PlayerCharacter result = compendiumRepositories.getPlayerCharacterRepository().save(playerCharacter);
        return ResponseEntity.ok(genericMapper.toPlayerCharacterDto(result));
    }

    public ResponseEntity<List<CharacterClassDto>> getClasses(){
        List<CharacterClass> characterClasses = compendiumRepositories.getCharacterClassRepository().findAll();
        List<CharacterClassDto> characterClassDto = characterClasses.stream().map(genericMapper::toCharacterClassDto).toList();
        return ResponseEntity.ok(characterClassDto);
    }

    public ResponseEntity<List<BackgroundDto>> getBackgrounds(){
        List<Background> backgrounds = compendiumRepositories.getBackgroundRepository().findAll();
        List<BackgroundDto> backgroundDto = backgrounds.stream().map(genericMapper::toBackgroundDto).toList();
        return ResponseEntity.ok(backgroundDto);
    }

    public ResponseEntity<List<SubRaceDto>> getSubRaces(){
        List<SubRace> subRaces = compendiumRepositories.getSubRaceRepository().findAll();
        List<SubRaceDto> subRaceDto = subRaces.stream().map(genericMapper::toSubRaceDto).toList();
        return ResponseEntity.ok(subRaceDto);
    }

    public ResponseEntity<List<AlignmentDto>> getAlignments(){
        List<Alignment> alignments = compendiumRepositories.getAlignmentRepository().findAll();
        List<AlignmentDto> alignmentDto = alignments.stream().map(genericMapper::toAlignmentDto).toList();
        return ResponseEntity.ok(alignmentDto);
    }

    public ResponseEntity<List<RaceDto>> getRaces(){
        List<Race> races = compendiumRepositories.getRaceRepository().findAll();
        List<RaceDto> raceDto = races.stream().map(genericMapper::toRaceDto).toList();
        return ResponseEntity.ok(raceDto);
    }

    public ResponseEntity<List<SpellDto>> getSpells(){
        List<Spell> spells = compendiumRepositories.getSpellRepository().findAll();
        List<SpellDto> spellDto = spells.stream().map(genericMapper::toSpellDto).toList();
        return ResponseEntity.ok(spellDto);
    }

    public ResponseEntity<List<SkillDto>> getSkills() {
        List<Skill> skills = compendiumRepositories.getSkillRepository().findAll();
        List<SkillDto> skillDto = skills.stream().map(genericMapper::toSkillDto).toList();
        return ResponseEntity.ok(skillDto);
    }

}
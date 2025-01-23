package org.example.dnd_compendiumwebapi.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.dnd_compendiumdata.model.*;
import org.example.dnd_compendiumdata.repositories.CompendiumRepositories;
import org.example.dnd_compendiumupdater.updater.ICompendiumUpdater;
import org.example.dnd_compendiumwebapi.contract.*;
import org.example.dnd_compendiumwebapi.mapper.ApiGenericMapper;
import org.example.dnd_compendiumwebapi.mapper.PlayerCharacterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class WebApiService {

    private final CompendiumRepositories compendiumRepositories;
    private final ApiGenericMapper genericMapper;
    private final ICompendiumUpdater compendiumUpdater;
    private final PlayerCharacterMapper playerCharacterMapper;

    public void update(){
        compendiumUpdater.updateCompendium();
    }

    public ResponseEntity<List<PlayerCharacterDto>> getCharacters() {
        List<PlayerCharacter> characters = compendiumRepositories.getPlayerCharacterRepository().findAll();
        List<PlayerCharacterDto> charactersDto = characters.stream().map(playerCharacterMapper::toPlayerCharacterDto).toList();
        return ResponseEntity.ok(charactersDto);
    }

    public ResponseEntity<PlayerCharacterDto> getCharacterByName(String name) throws Exception {
        PlayerCharacter playercharacter = compendiumRepositories.getPlayerCharacterRepository().findByName(name);
        if(playercharacter == null) throw new Exception("Character "+name+" not found");
        return ResponseEntity.ok(playerCharacterMapper.toPlayerCharacterDto(playercharacter));
    }

    public ResponseEntity<String> deleteCharacterByName(String name) throws Exception {
        if(compendiumRepositories.getPlayerCharacterRepository().findByName(name) == null) throw new Exception("Character "+name+" not found");
        compendiumRepositories.getAbilityScore_ValueRepository().deleteAllByPlayerCharacterName(name);
        compendiumRepositories.getPlayerCharacterRepository().deleteByName(name);
        return ResponseEntity.ok("deleted");
    }

    public ResponseEntity<PlayerCharacterDto> saveCharacter(PlayerCharacterDto playerCharacterDto) {
        PlayerCharacter playerCharacter = playerCharacterMapper.toPlayerCharacter(playerCharacterDto);
        compendiumRepositories.getPlayerCharacterRepository().save(playerCharacter);
        compendiumRepositories.getAbilityScore_ValueRepository().saveAll(playerCharacter.getAbilityScoreValues());
        return ResponseEntity.ok(playerCharacterDto);
    }

    public ResponseEntity<List<CharacterClassDto>> getClasses(){
        List<CharacterClass> characterClasses = compendiumRepositories.getCharacterClassRepository().findAll();
        List<CharacterClassDto> characterClassDto = characterClasses.stream().map(genericMapper::toCharacterClassDto).toList();
        return ResponseEntity.ok(characterClassDto);
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

    public ResponseEntity<SpellDetailsDto> getSpellDetails(String index){
        Spell spell = compendiumRepositories.getSpellRepository().findByEntityIndex(index);
        if(spell == null){
            SpellDetailsDto spellDetailsDto = new SpellDetailsDto();
            spellDetailsDto.setName("invalid index");
            return ResponseEntity.ok(spellDetailsDto);
        }

        SpellDetailsDto spellDetailsDto = genericMapper.toSpellDetailsDto(spell);
        SpellDetails spellDetails = compendiumRepositories.getSpellDetailsRepository().findByEntityIndex(index);
        spellDetailsDto.setDescription(spellDetails.getDescription());
        return ResponseEntity.ok(spellDetailsDto);
    }

    public ResponseEntity<List<SkillDto>> getSkills() {
        List<Skill> skills = compendiumRepositories.getSkillRepository().findAll();
        List<SkillDto> skillDto = skills.stream().map(genericMapper::toSkillDto).toList();
        return ResponseEntity.ok(skillDto);
    }

    public ResponseEntity<SkillDetailsDto> getSkilletails(String index){
        Skill skill = compendiumRepositories.getSkillRepository().findByEntityIndex(index);
        if(skill == null){
            SkillDetailsDto skillDetailsDto = new SkillDetailsDto();
            skillDetailsDto.setName("invalid index");
            return ResponseEntity.ok(skillDetailsDto);
        }

        SkillDetailsDto skillDetailsDto = genericMapper.toSkillDetailsDto(skill);
        SkillDetails skillDetails = compendiumRepositories.getSkillDetailsRepository().findByEntityIndex(index);
        skillDetailsDto.setDescription(skillDetails.getDescription());
        return ResponseEntity.ok(skillDetailsDto);
    }


}
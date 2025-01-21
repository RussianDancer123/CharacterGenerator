package org.example.dnd_compendiumwebapi.mapper;

import lombok.AllArgsConstructor;
import org.example.dnd_compendiumdata.model.*;
import org.example.dnd_compendiumdata.repositories.CompendiumRepositories;
import org.example.dnd_compendiumwebapi.contract.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PlayerCharacterMapper {
    private final CompendiumRepositories repo;
    private final CompendiumRepositories compendiumRepositories;
    private final ApiGenericMapper genericMapper;

    public PlayerCharacter toPlayerCharacter(PlayerCharacterDto playerCharacterDto) {
        PlayerCharacter playerCharacter = new PlayerCharacter();

        playerCharacter.setPlayerName(playerCharacterDto.playerName());
        playerCharacter.setName(playerCharacterDto.name());
        playerCharacter.setGender(playerCharacterDto.gender());
        playerCharacter.setLevel(playerCharacterDto.level());
        playerCharacter.setExperience(playerCharacterDto.experience());

        CharacterClass characterClass = repo.getCharacterClassRepository().findByEntityIndex(playerCharacterDto.characterClassDto().index());
        playerCharacter.setCharacterClass(characterClass);

        SubRace subRace = repo.getSubRaceRepository().findByEntityIndex(playerCharacterDto.subRaceDto().index());
        playerCharacter.setSubRace(subRace);

        Alignment alignment = repo.getAlignmentRepository().findByEntityIndex(playerCharacterDto.alignmentDto().index());
        playerCharacter.setAlignment(alignment);

        Race race = repo.getRaceRepository().findByEntityIndex(playerCharacterDto.raceDto().index());
        playerCharacter.setRace(race);

        List<AbilityScore_Value> abilityScoreValues = playerCharacterDto.abilityScoreValueDto().stream().map(this::toAbilityScoreValue).toList();
        abilityScoreValues.forEach(as -> as.setPlayerCharacter(playerCharacter));
        playerCharacter.setAbilityScoreValues(abilityScoreValues);


        List<Spell> spells = playerCharacterDto.spellDto().stream().map(s -> repo.getSpellRepository().findByEntityIndex(s.index())).toList();
        playerCharacter.setSpells(spells);

        List<Skill> skills = playerCharacterDto.skillDto().stream().map(s -> repo.getSkillRepository().findByEntityIndex(s.index())).toList();
        playerCharacter.setSkills(skills);

        return playerCharacter;
    }

    private AbilityScore_Value toAbilityScoreValue(AbilityScore_ValueDto abilityScoreValueDto) {
        AbilityScore_Value abilityScoreValue = new AbilityScore_Value();
        abilityScoreValue.setValue(abilityScoreValueDto.value());
        abilityScoreValue.setAbilityScore(compendiumRepositories.getAbilityScoreRepository().findByEntityIndex(abilityScoreValueDto.index()));
        return abilityScoreValue;
    }

    public PlayerCharacterDto toPlayerCharacterDto(PlayerCharacter playerCharacter) {
        CharacterClassDto characterClassDto = genericMapper.toCharacterClassDto(playerCharacter.getCharacterClass());
        SubRaceDto subRaceDto = genericMapper.toSubRaceDto(playerCharacter.getSubRace());
        AlignmentDto alignmentDto = genericMapper.toAlignmentDto(playerCharacter.getAlignment());
        RaceDto raceDto = genericMapper.toRaceDto(playerCharacter.getRace());
        List<AbilityScore_ValueDto> abilityScoreValueDto = playerCharacter.getAbilityScoreValues().stream().map(this::toAbilityScoreValueDto).toList();
        List<SpellDto> spellDto = playerCharacter.getSpells().stream().map(genericMapper::toSpellDto).toList();
        List<SkillDto> skillDto = playerCharacter.getSkills().stream().map(genericMapper::toSkillDto).toList();

        return new PlayerCharacterDto(
                playerCharacter.getPlayerName(),
                playerCharacter.getName(),
                playerCharacter.getGender(),
                playerCharacter.getLevel(),
                characterClassDto,
                subRaceDto,
                alignmentDto,
                playerCharacter.getExperience(),
                raceDto,
                abilityScoreValueDto,
                spellDto,
                skillDto
        );
    }

    private AbilityScore_ValueDto toAbilityScoreValueDto(AbilityScore_Value abilityScoreValue) {
        return new AbilityScore_ValueDto(abilityScoreValue.getAbilityScore().getEntityIndex(), abilityScoreValue.getValue());
    }
}

package org.example.dnd_compendiumwebapi;

import org.assertj.core.api.Assertions;
import org.example.dnd_compendiumdata.model.*;
import org.example.dnd_compendiumdata.repositories.*;
import org.example.dnd_compendiumwebapi.contract.*;
import org.example.dnd_compendiumwebapi.mapper.ApiGenericMapper;
import org.example.dnd_compendiumwebapi.mapper.PlayerCharacterMapper;
import org.example.dnd_compendiumwebapi.service.WebApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DndCompendiumWebApiApplicationTests {

    @Mock private SkillRepository skillRepository;
    @Mock private PlayerCharacterRepository playerCharacterRepository;
    @Mock private CharacterClassRepository characterClassRepository;
    @Mock private AbilityScore_ValueRepository abilityScoreValueRepository;
    @Mock private AbilityScoreRepository abilityScoreRepository;
    @Mock private AlignmentRepository alignmentRepository;
    @Mock private RaceDetailsRepository raceDetailsRepository;
    @Mock private RaceRepository raceRepository;
    @Mock private SkillDetailsRepository skillDetailsRepository;
    @Mock private SpellDetailsRepository spellDetailsRepository;
    @Mock private SpellRepository spellRepository;
    @Mock private SubRaceRepository subRaceRepository;

    @Autowired
    private ApiGenericMapper mapper;

    private WebApiService webApiService;

    private PlayerCharacter playerCharacter = new PlayerCharacter()
            .setCharacterClass(new CharacterClass().setName("A"))
            .setSkills(new ArrayList<Skill>())
            .setPlayerName("awd")
            .setGender("awd")
            .setAbilityScoreValues(new ArrayList<AbilityScore_Value>())
            .setAlignment(new Alignment().setName("alignment"))
            .setExperience(0)
            .setLevel(1)
            .setName("name")
            .setRace(new Race().setName("race"))
            .setSpells(new ArrayList<Spell>())
            .setSubRace(new SubRace().setName("subrace"));

    private PlayerCharacterDto playerCharacterDto = new PlayerCharacterDto(
            "awd"
            , "name"
            , "awd"
            , 1
            , new CharacterClassDto("bard", "A", 2)
            , new SubRaceDto("high-elf", "subrace", "url")
            , new AlignmentDto("neutral", "alignment", "url")
            , 0
            , new RaceDto("dwarf", "race", "url")
            , List.of(new AbilityScore_ValueDto("cha", 2))
            , List.of(new SpellDto("acid-arrow", "w", 2, "url"))
            , List.of(new SkillDto("arcana", "a", "url")));

    Skill skill = new Skill().setEntityIndex("awd").setName("A W D").setUrl("url").setDetails(null);
    Spell spell = new Spell().setEntityIndex("awd").setName("A W D").setUrl("url").setLevel(2).setDetails(null);

    @BeforeEach
    void setUp() {
        CompendiumRepositories compendiumRepositories = new CompendiumRepositories(
                abilityScoreValueRepository, abilityScoreRepository, alignmentRepository,
                characterClassRepository, playerCharacterRepository, raceDetailsRepository,
                raceRepository, skillDetailsRepository, skillRepository, spellDetailsRepository,
                spellRepository, subRaceRepository
        );

        PlayerCharacterMapper playerCharacterMapper = new PlayerCharacterMapper(compendiumRepositories, mapper);

        webApiService = new WebApiService(compendiumRepositories, mapper, null, playerCharacterMapper);
    }


    @Test
    public void skillSaveTest() throws Exception {

        when(skillRepository.save(Mockito.any(Skill.class))).thenReturn(skill);

        Skill savedSkill = skillRepository.save(skill);

        Assertions.assertThat(savedSkill).isNotNull();
        Assertions.assertThat(savedSkill.getName()).isEqualTo("A W D");
        Assertions.assertThat(savedSkill.getUrl()).isEqualTo("url");
    }

    @Test
    public void skillGetTest() throws Exception {

        when(skillRepository.findAll()).thenReturn(Collections.singletonList(skill));

        List<Skill> skills = skillRepository.findAll();

        Assertions.assertThat(skills).isNotNull();
        Assertions.assertThat(skills.size()).isEqualTo(1);
        Assertions.assertThat(skills.get(0).getEntityIndex()).isEqualTo("awd");
    }

    @Test
    public void spellSaveTest() throws Exception {

        when(spellRepository.save(Mockito.any())).thenReturn(spell);

        Spell savedSpell = spellRepository.save(spell);

        Assertions.assertThat(savedSpell).isNotNull();
        Assertions.assertThat(savedSpell.getEntityIndex()).isEqualTo("awd");
        Assertions.assertThat(savedSpell.getLevel()).isEqualTo(2);
    }

    @Test
    public void spellGetTest() throws Exception {
        when(spellRepository.findAll()).thenReturn(Collections.singletonList(spell));

        List<Spell> spells = spellRepository.findAll();

        Assertions.assertThat(spells).isNotNull();
        Assertions.assertThat(spells.size()).isEqualTo(1);
        Assertions.assertThat(spells.get(0).getEntityIndex()).isEqualTo("awd");
    }

    @Test
    public void CharacterCreateTest() throws Exception {
        when(playerCharacterRepository.save(Mockito.any(PlayerCharacter.class))).thenReturn(playerCharacter);

        PlayerCharacterDto savedPlayerCharacter = webApiService.saveCharacter(playerCharacterDto).getBody();

        Assertions.assertThat(savedPlayerCharacter).isNotNull();
        Assertions.assertThat(savedPlayerCharacter.characterClassDto().name()).isEqualTo("A");
        Assertions.assertThat(savedPlayerCharacter.playerName()).isEqualTo("awd");
    }

    @Test
    public void CharacterGetTest() throws Exception {
        when(playerCharacterRepository.findAll()).thenReturn(List.of(playerCharacter));

        List<PlayerCharacterDto> readCharacterDto = webApiService.getCharacters().getBody();

        Assertions.assertThat(readCharacterDto).isNotNull();
        Assertions.assertThat(readCharacterDto.size()).isEqualTo(1);
        Assertions.assertThat(readCharacterDto.get(0).characterClassDto().name()).isEqualTo("A");
        Assertions.assertThat(readCharacterDto.get(0).playerName()).isEqualTo("awd");
    }

}
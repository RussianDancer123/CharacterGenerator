package org.example.dnd_compendiumwebapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.example.dnd_compendiumdata.model.Skill;
import org.example.dnd_compendiumdata.model.Spell;
import org.example.dnd_compendiumdata.repositories.CompendiumRepositories;
import org.example.dnd_compendiumwebapi.contract.*;
import org.example.dnd_compendiumwebapi.mapper.ApiGenericMapper;
import org.example.dnd_compendiumwebapi.service.WebApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class LeafController {
    private final WebApiService service;
    private final CompendiumRepositories compendiumRepositories;
    private final ApiGenericMapper mapper;

    @RequestMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("classes", service.getClasses().getBody());
        model.addAttribute("subRaces", service.getSubRaces().getBody());
        model.addAttribute("alignments", service.getAlignments().getBody());
        model.addAttribute("races", service.getRaces().getBody());
        model.addAttribute("spells", service.getSpells().getBody());
        model.addAttribute("skills", service.getSkills().getBody());
        model.addAttribute("characterForm", new PlayerCharacterForm());
        return "index.html";
    }

    @PostMapping("/leaf/character/save")
    public String savePlayerCharacter(PlayerCharacterForm form, Model model) throws JsonProcessingException {

        List<Spell> spells = form.getSpellIndices().stream().map(s->compendiumRepositories.getSpellRepository().findByEntityIndex(s)).toList();
        List<Skill> skills = form.getSkillIndices().stream().map(s->compendiumRepositories.getSkillRepository().findByEntityIndex(s)).toList();


        CharacterClassDto characterClassDto = mapper.toCharacterClassDto(compendiumRepositories.getCharacterClassRepository().findByEntityIndex(form.getCharacterClassIndex()));
        SubRaceDto subRaceDto = mapper.toSubRaceDto(compendiumRepositories.getSubRaceRepository().findByEntityIndex(form.getSubRaceIndex()));
        AlignmentDto alignmentDto = mapper.toAlignmentDto(compendiumRepositories.getAlignmentRepository().findByEntityIndex(form.getAlignmentIndex()));
        RaceDto raceDto = mapper.toRaceDto(compendiumRepositories.getRaceRepository().findByEntityIndex(form.getRaceIndex()));
        List<SpellDto> spellDtos = spells.stream().map(mapper::toSpellDto).toList();
        List<SkillDto> skillDtos = skills.stream().map(mapper::toSkillDto).toList();


        List<AbilityScore_ValueDto> abilityScore_value = List.of(
                new AbilityScore_ValueDto("cha", form.getCha()),
                new AbilityScore_ValueDto("con", form.getCon()),
                new AbilityScore_ValueDto("dex", form.getDex()),
                new AbilityScore_ValueDto("int", form.getInte()),
                new AbilityScore_ValueDto("str", form.getStr()),
                new AbilityScore_ValueDto("wis", form.getWis())

        );

        PlayerCharacterDto playerCharacterDto = new PlayerCharacterDto(form.getPlayerName(),
                form.getName(),
                form.getGender(),
                form.getLevel(),
                characterClassDto,
                subRaceDto,
                alignmentDto,
                form.getExperience(),
                raceDto,
                abilityScore_value,
                spellDtos,
                skillDtos);

        service.saveCharacter(playerCharacterDto);


        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(playerCharacterDto);

        model.addAttribute("playerCharacter", json);

        return "save.html";
    }
}

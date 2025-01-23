package org.example.dnd_compendiumwebapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.example.dnd_compendiumdata.model.PlayerCharacter;
import org.example.dnd_compendiumdata.model.Skill;
import org.example.dnd_compendiumdata.model.Spell;
import org.example.dnd_compendiumdata.repositories.CompendiumRepositories;
import org.example.dnd_compendiumdata.repositories.PlayerCharacterRepository;
import org.example.dnd_compendiumwebapi.contract.PlayerCharacterDto;
import org.example.dnd_compendiumwebapi.contract.SkillDto;
import org.example.dnd_compendiumwebapi.service.WebApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class LeafController {
    private final WebApiService service;
    private final PlayerCharacterRepository playerCharacterRepository;
    private final CompendiumRepositories compendiumRepositories;

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
        // Map form to entity
        List<Spell> spells = form.getSpellIndices().stream().map(s->compendiumRepositories.getSpellRepository().findByEntityIndex(s)).toList();
        List<Skill> skills = form.getSkillIndices().stream().map(s->compendiumRepositories.getSkillRepository().findByEntityIndex(s)).toList();

        PlayerCharacter playerCharacter = new PlayerCharacter()
                .setName(form.getName())
                .setPlayerName(form.getPlayerName())
                .setGender(form.getGender())
                .setLevel(form.getLevel())
                .setExperience(form.getExperience())
                .setCharacterClass(compendiumRepositories.getCharacterClassRepository().findByEntityIndex(form.getCharacterClassIndex()))
                .setSubRace(compendiumRepositories.getSubRaceRepository().findByEntityIndex(form.getSubRaceIndex()))
                .setAlignment(compendiumRepositories.getAlignmentRepository().findByEntityIndex(form.getAlignmentIndex()))
                .setRace(compendiumRepositories.getRaceRepository().findByEntityIndex(form.getRaceIndex()))
                .setSpells(spells)
                .setSkills(skills);

        playerCharacterRepository.save(playerCharacter);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(playerCharacter);

        model.addAttribute("playerCharacter", json);

        return "save.html";
    }
}

package org.example.dnd_compendiumwebapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.dnd_compendiumdata.model.PlayerCharacter;
import org.example.dnd_compendiumwebapi.contract.*;
import org.example.dnd_compendiumwebapi.service.WebApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class WebApiController {
    private final WebApiService service;

    public WebApiController(WebApiService service) {
        this.service = service;
    }

    @GetMapping("update")
    public ResponseEntity<String> update(){
        service.update();
        return ResponseEntity.ok("updated");
    }

    @GetMapping("character")
    public ResponseEntity<List<PlayerCharacterDto>> getCharacters(){
        return service.getCharacters();
    }

    @GetMapping("character/{name}")
    public ResponseEntity<?> getCharacterByName(@PathVariable String name) {
        try {
            return service.getCharacterByName(name);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("character/{name}")
    public ResponseEntity<?> deleteCharacterByName(@PathVariable String name) {
        try {
            return service.deleteCharacterByName(name);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("character")
    public ResponseEntity<?> addCharacter(@RequestBody PlayerCharacterDto dto) {
        try {
            return service.saveCharacter(dto);
        }catch (Exception e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }

    @GetMapping("classes")
    public ResponseEntity<List<CharacterClassDto>> getClasses(){
        return service.getClasses();
    }

    @GetMapping("subraces")
    public ResponseEntity<List<SubRaceDto>> getSubRaces(){
        return service.getSubRaces();
    }

    @GetMapping("alignments")
    public ResponseEntity<List<AlignmentDto>> getAlignments(){
        return service.getAlignments();
    }

    @GetMapping("races")
    public ResponseEntity<List<RaceDto>> getRaces(){
        return service.getRaces();
    }

    @GetMapping("spells")
    public ResponseEntity<List<SpellDto>> getSpells(){
        return service.getSpells();
    }

    @GetMapping("spells/{index}")
    public ResponseEntity<SpellDetailsDto> getSpellDetails(@PathVariable String index) {
        return service.getSpellDetails(index);
    }

    @GetMapping("skills")
    public ResponseEntity<List<SkillDto>> getSkills(){
        return service.getSkills();
    }

    @GetMapping("skills/{index}")
    public ResponseEntity<SkillDetailsDto> getSkillDetails(@PathVariable String index){
        return service.getSkilletails(index);
    }

}

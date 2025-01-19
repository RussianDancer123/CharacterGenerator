package org.example.dnd_compendiumwebapi.controller;

import org.example.dnd_compendiumwebapi.contract.*;
import org.example.dnd_compendiumwebapi.service.WebApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebApiController {
    private final WebApiService service;

    public WebApiController(WebApiService service) {
        this.service = service;
    }

//    @GetMapping("character/generate")
//    public ResponseEntity<PlayerCharacterDto> generateCharacter() {
//        return service.generatePlayerCharacter();
//    }

    @GetMapping("update")
    public ResponseEntity<String> update(){
        service.update();
        return ResponseEntity.ok("updated");
    }

    @GetMapping("character/{id}")
    public ResponseEntity<PlayerCharacterDto> getCharacterById(@PathVariable int id) {
        return service.getCharacterById(id);
    }

    @DeleteMapping("character/{id}")
    public ResponseEntity<Boolean> deleteCharacterById(@PathVariable int id) {
        return service.deleteCharacterById(id);
    }

    @PostMapping("character")
    public ResponseEntity<PlayerCharacterDto> addCharacter(@RequestBody PlayerCharacterDto dto) {
        return service.saveCharacter(dto);
    }

    @GetMapping("classes")
    public ResponseEntity<List<CharacterClassDto>> getClasses(){
        return service.getClasses();
    }

    @GetMapping("backgrounds")
    public ResponseEntity<List<BackgroundDto>> getBackgrounds(){
        return service.getBackgrounds();
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

    @GetMapping("skills")
    public ResponseEntity<List<SkillDto>> getSkills(){
        return service.getSkills();
    }

}

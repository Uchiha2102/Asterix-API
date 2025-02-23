package org.example.asterixapi;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/characters")

public class AsterixController {

    private final CharacterService characterService;

    public AsterixController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }
    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable String id) {
        return characterService.getCharacterById(id);
    }



    @PostMapping
    public Character addCharacter(@RequestBody CharacterDTO characterDTO) {
        return characterService.addCharacter(characterDTO);
    }

    @PostMapping("/{id}")
    public Character updateCharacter(@PathVariable String id, @RequestBody Character updatedCharacter) {
return characterService.updateCharacter(id, updatedCharacter);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable String id) {
        characterService.deleteCharacter(id);

    }

}

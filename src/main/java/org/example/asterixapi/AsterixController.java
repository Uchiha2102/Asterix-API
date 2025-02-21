package org.example.asterixapi;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/characters")

public class AsterixController {

    private final CharacterRepo characterRepo;

    public AsterixController(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        return characterRepo.findAll();
    }


    @PostMapping
    public Character addCharacter(@RequestBody Character character) {
        return characterRepo.save(character);
    }

    @PostMapping("/{id}")
    public Character updateCharacter(@PathVariable String id, @RequestBody Character updatedCharacter) {

        Optional<Character> optionalCharacter = characterRepo.findById(id);

        if (optionalCharacter.isPresent()) {
            Character existingCharacter = optionalCharacter.get();
            Character newCharacter = new Character(
                    existingCharacter.id(),
                    updatedCharacter.name(),
                    updatedCharacter.age(),
                    updatedCharacter.profession()
            );
            return characterRepo.save(newCharacter);
        } else {
            throw new IllegalArgumentException("Character with ID " + id + " not found");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable String id) {
        characterRepo.deleteById(id);

    }

    @PostMapping("/bulk")
    public List<Character> addCharacters(@RequestBody List<Character> characters) {
        return characterRepo.saveAll(characters);
    }


}

package org.example.asterixapi;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class CharacterService {

    private final CharacterRepo characterRepo;

    public CharacterService(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;
    }

    public List<Character> getAllCharacters() {
        return characterRepo.findAll();
    }
    public Character getCharacterById(String id) {
        return characterRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Character with ID " + id + " not found"));
    }


    public Character addCharacter(CharacterDTO characterDTO) {
        String generatedId = UUID.randomUUID().toString();
        Character newCharacter = new Character(
                generatedId,
                characterDTO.name(),
                characterDTO.age(),
                characterDTO.profession()
        );
        return characterRepo.save(newCharacter);
    }

    public Character updateCharacter(String id, Character updatedCharacter) {
        Optional<Character> optionalCharacter = characterRepo.findById(id);

        if (optionalCharacter.isPresent()) {
            Character newCharacter = new Character(
                    id,
                    updatedCharacter.name(),
                    updatedCharacter.age(),
                    updatedCharacter.profession()
            );
            return characterRepo.save(newCharacter);
        } else {
            throw new IllegalArgumentException("Character with ID " + id + " not found");
        }
    }

    public void deleteCharacter(String id) {
        characterRepo.deleteById(id);
    }

}

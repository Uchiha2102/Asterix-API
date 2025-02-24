package org.example.asterixapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class AsterixIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    CharacterRepo characterRepo;

    @Test
    void getAllCharacters() throws Exception {

        mockMvc.perform(get("/api/characters")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
  

    @Test
    void getCharacterById() {
    }

    @Test
    void addCharacter() {
    }

    @Test
    void updateCharacter() {
    }

    @Test
    void deleteCharacter() {
    }
}

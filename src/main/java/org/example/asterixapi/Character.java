package org.example.asterixapi;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("characters")
public record Character(
        int id,
        String name,
        int age,
        String profession
) {
}

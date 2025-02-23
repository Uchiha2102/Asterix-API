package org.example.asterixapi;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("characters")
public record Character(
        String id,
        String name,
        int age,
        String profession
) {
}

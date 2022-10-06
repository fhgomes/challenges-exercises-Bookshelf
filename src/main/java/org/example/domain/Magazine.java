package org.example.domain;

import java.time.LocalDate;
import java.util.Map;

public class Magazine extends TextPageableItem {

    private String name;
    private LocalDate publicationDate;

    public Magazine(Map<Integer, String> content, String id) {
        super(content, id);
    }

    public String getName() {
        return name;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }
}

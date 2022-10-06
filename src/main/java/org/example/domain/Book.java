package org.example.domain;

import java.util.Map;

public class Book extends TextPageableItem {

    private String tittle;
    private String author;

    public Book(Map<Integer, String> content, String id) {
        super(content, id);
    }

    public String getTittle() {
        return tittle;
    }

    public String getAuthor() {
        return author;
    }
}

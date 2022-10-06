package org.example.domain;

import java.util.Map;

public class Notebook extends TextPageableItem {

    private String owner;

    public Notebook(Map<Integer, String> content, String id) {
        super(content, id);
    }

    public String getOwner() {
        return owner;
    }
}

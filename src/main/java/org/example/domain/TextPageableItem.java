package org.example.domain;

import static java.lang.String.format;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.example.usecase.IBookshelfItem;

public abstract class TextPageableItem implements IBookshelfItem {
    private Map<Integer, String> content;
    private String id;

    public TextPageableItem(Map<Integer, String> content, String id) {
        this.content = content;
        this.id = id;
    }

    @Override
    public String getPageContent(int page) {
        return Optional.ofNullable(content.get(page)).orElse(format("page [%s] not found", page));
    }

    @Override
    public String getContent() {
        return content.values()
                .parallelStream()
                .collect(Collectors.joining(" "));
    }

    public String getId() {
        return id;
    }


}

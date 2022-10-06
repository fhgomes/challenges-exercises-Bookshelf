package org.example.usecase;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

import org.example.domain.TextPageableItem;

public class BookshelfRepository {

    //simulate database
    private final List<TextPageableItem> currentItems;

    public BookshelfRepository() {
        this.currentItems = new ArrayList<>();
    }

    public void saveReadableItem(TextPageableItem newItem) {
        currentItems.add(newItem);
    }

    public TextPageableItem removeItemById(String id) {
        TextPageableItem itemFoundById = findItemById(id);
        currentItems.remove(itemFoundById);
        return itemFoundById;
    }

    public TextPageableItem findItemById(String id) {
        return currentItems.stream()
                .filter(searchItem -> id.equals(searchItem.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(format("item [%s] not found", id)));
    }

    public TextPageableItem findItemByText(String searchText) {
        return currentItems.stream()
                .filter(searchItem -> searchItem.getContent().toLowerCase().contains(searchText.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(format("item not found with text [%s]", searchText)));
    }

    public int countItems() {
        return currentItems.size();
    }
}

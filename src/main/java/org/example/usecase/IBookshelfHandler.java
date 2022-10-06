package org.example.usecase;

import org.example.domain.TextPageableItem;

public interface IBookshelfHandler {

    void storeReadableItem(TextPageableItem page);
    TextPageableItem retrieveItem(String id);
    String readPageOfItem(String id, int page);
    TextPageableItem findItemByText(String searchText);
}

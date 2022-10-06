package org.example.usecase;

import static java.lang.String.format;

import org.example.domain.BookShelfStatusDTO;
import org.example.domain.TextPageableItem;

public class BookshelfService implements IBookshelfHandler, IBookshelfStatusHandler {

    private static final Integer BOOKSHELF_MAX_SIZE = 100;

    //simulate database
    private final BookshelfRepository bookshelfRepository;

    public BookshelfService(BookshelfRepository bookshelfRepository) {
        this.bookshelfRepository = bookshelfRepository;
    }

    @Override
    public void storeReadableItem(TextPageableItem newItem) {
        int currentSize = bookshelfRepository.countItems();
        if (currentSize == BOOKSHELF_MAX_SIZE) {
            throw new RuntimeException(format("cant store, it´s full. Capacity: %s", BOOKSHELF_MAX_SIZE));
        }
        bookshelfRepository.saveReadableItem(newItem);
    }

    @Override
    public TextPageableItem retrieveItem(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new RuntimeException("cant retrieve empty id");
        }

        return bookshelfRepository.removeItemById(id);
    }

    @Override
    public String readPageOfItem(String id, int page) {
        return bookshelfRepository.findItemById(id).getPageContent(page);
    }

    @Override
    public TextPageableItem findItemByText(String searchText) {
        if (searchText == null || searchText.trim().isEmpty()) {
            throw new RuntimeException("cant search empty");
        }

        return bookshelfRepository.findItemByText(searchText);
    }

    @Override
    public BookShelfStatusDTO getCurrentStatus() {
        int currentSize = bookshelfRepository.countItems();
        return new BookShelfStatusDTO(currentSize, BOOKSHELF_MAX_SIZE, BOOKSHELF_MAX_SIZE-currentSize);
    }
}

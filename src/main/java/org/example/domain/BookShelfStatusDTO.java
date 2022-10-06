package org.example.domain;

public class BookShelfStatusDTO {

    private Integer currentStore;
    private Integer maxHold;
    private Integer spaceLeft;

    public BookShelfStatusDTO(Integer currentStore, Integer maxHold, Integer spaceLeft) {
        this.currentStore = currentStore;
        this.maxHold = maxHold;
        this.spaceLeft = spaceLeft;
    }

    public Integer getCurrentStore() {
        return currentStore;
    }

    public Integer getMaxHold() {
        return maxHold;
    }

    public Integer getSpaceLeft() {
        return spaceLeft;
    }
}

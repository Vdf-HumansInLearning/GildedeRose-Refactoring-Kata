package com.gildedrose;

public enum ItemCategory {

    AGED_BRIE ("Aged Brie"),
    SULFURAS ("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_PASSES ("Backstage passes to a TAFKAL80ETC concert");

    private final String name;

    private ItemCategory(String name) {
       this.name = name;
    }

    public String getName() {
        return name;
    }
}

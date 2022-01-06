package com.gildedrose;

class GildedRose {
    Item[] items;

    private static final int MAX_QUALITY = 50;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (Item item : items) {
            updatequality(item);

            updateSellIn(item);

            if (item.sellIn < 0) {
                if (!item.name.equals(ItemCategory.AGED_BRIE.getName())) {
                    if (!item.name.equals(ItemCategory.BACKSTAGE_PASSES.getName())) {
                        if (item.quality > 0 && !item.name.equals(ItemCategory.SULFURAS.getName())) {
                            item.quality = item.quality - 1;
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    updateBrieQuality(item);
                }
            }
        }
    }

    private void updateBrieQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    private void updateSellIn(Item item) {
        if (!item.name.equals(ItemCategory.SULFURAS.getName())) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updatequality(Item item) {
        if (!item.name.equals(ItemCategory.SULFURAS.getName())) {
            if (!item.name.equals(ItemCategory.AGED_BRIE.getName())
                && !item.name.equals(ItemCategory.BACKSTAGE_PASSES.getName())) {
                if (item.quality > 0) {
                        item.quality = item.quality - 1;
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    if (item.name.equals(ItemCategory.BACKSTAGE_PASSES.getName())) {
                           updateQualityForBackstageItem(item);
                        } else {
                           item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    private void updateQualityForBackstageItem(Item item) {
            if(item.sellIn <= 5) {
                item.quality+= 3;
            } else if (item.sellIn <= 10) {
                item.quality+= 2;
            } else {
                item.quality+= 1;
            }
        if(item.quality > MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        }
    }

}

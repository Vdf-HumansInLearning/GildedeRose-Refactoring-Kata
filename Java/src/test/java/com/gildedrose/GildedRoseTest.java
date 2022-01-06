package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        String itemName = "foo";
        int sellIn = 0;
        int quality = 0;
        Item[] items = new Item[] { new Item(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(itemName, app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality, app.items[0].quality);
    }

    @Test
    void fooWithPositiveSellIn() {
        String itemName = "foo";
        int sellIn = 10;
        int quality = 0;
        Item[] items = new Item[] { new Item(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(itemName, app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality, app.items[0].quality);
    }

    @Test
    void fooWithNegativeSellIn() {
        String itemName = "foo";
        int sellIn = -1;
        int quality = 10;
        Item[] items = new Item[] { new Item(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(itemName, app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality - 2, app.items[0].quality);
    }

    @Test
    void fooWithPositiveAndqualitySellIn() {
        String itemName = "foo";
        int sellIn = 10;
        int quality = 10;
        Item[] items = new Item[] { new Item(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(itemName, app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality - 1, app.items[0].quality);
    }

    @Test
    void agedBrieWithPositiveAndqualitySellIn() {
        String itemName = ItemCategory.AGED_BRIE.getName();
        int sellIn = 10;
        int quality = 10;
        Item[] items = new Item[] { new Item(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(itemName, app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality + 1, app.items[0].quality);
    }

    @Test
    void agedBrieWithPositiveAndMaxqualitySellIn() {
        String itemName = ItemCategory.AGED_BRIE.getName();
        int sellIn = 10;
        int quality = 50;
        Item[] items = new Item[] { new Item(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(itemName, app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality , app.items[0].quality);
    }

    @Test
    void sulfurasWithPositiveAndqualitySellIn() {
        String itemName = ItemCategory.SULFURAS.getName();
        int sellIn = 10;
        int quality = 10;
        Item[] items = new Item[] { new Item(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(itemName, app.items[0].name);
        assertEquals(sellIn, app.items[0].sellIn);
        assertEquals(quality, app.items[0].quality);
    }

    @Test
    void backstagePassesWithMoreThan10DaysSellIn() {
        String itemName = ItemCategory.BACKSTAGE_PASSES.getName();
        int sellIn = 20;
        int quality = 10;
        Item[] items = new Item[] { new Item(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(itemName, app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality + 1, app.items[0].quality);
    }

    @Test
    void backstagePassesWith2DaysSellInWithquality48() {
        String itemName = ItemCategory.BACKSTAGE_PASSES.getName();
        int sellIn = 2;
        int quality = 48;
        Item[] items = new Item[] { new Item(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(itemName, app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void backstagePassesWithSixDaysSellIn() {
        String itemName = ItemCategory.BACKSTAGE_PASSES.getName();
        int sellIn = 6;
        int quality = 10;
        Item[] items = new Item[] { new Item(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(itemName, app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality + 2, app.items[0].quality);
    }


    @Test
    void backstagePassesWithTwoDaysSellIn() {
        String itemName = ItemCategory.BACKSTAGE_PASSES.getName();
        int sellIn = 2;
        int quality = 10;
        Item[] items = new Item[] { new Item(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(itemName, app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality + 3, app.items[0].quality);
    }

    @Test
    void backstagePassesWithOneDaySellIn() {
        String itemName = ItemCategory.BACKSTAGE_PASSES.getName();
        int sellIn = 0;
        int quality = 10;
        Item[] items = new Item[] { new Item(itemName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(itemName, app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}

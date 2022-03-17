package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    // Each Test case checks the Quality of an Item after 3 days processing
    @Test
    void AgedBrieItemQuality(){
        Item[] items = new Item[] {
            new Item("Aged Brie", 2, 48)};
        int days =3;
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(50, app.items[0].quality);

    }

    @Test
    void SulfurusItemQuality(){
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        int days =3;
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(80, app.items[0].quality);
    }
    @Test
    void SulfurusItemQualityWhenExpired(){
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", -1, 80)};
        int days =3;
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(80, app.items[0].quality);
    }
    @Test
    void BackstageItemQuality(){
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        int days =3;
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(23, app.items[0].quality);

    }
    @Test
    void BackStageItemQualityWhenSellInIsLesserThanOrEqualToTen(){
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49)};
        int days =3;
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(50, app.items[0].quality);

    }
    @Test
    void BackStageItemQualityWhenSellInIsLesserThanOrEqualToFive(){
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
        int days =3;
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(50, app.items[0].quality);

    }
    @Test
    void BackStageItemQualityWhenExpired(){
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 15)};
        int days =3;
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void ConjuredItemQuality(){
        Item[] items = new Item[] {
            new Item("Conjured Mana Cake", 5, 10)};
        int days =3;
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(4, app.items[0].quality);
    }
    @Test
    void ConjuredItemQualityWhenExpired(){
        Item[] items = new Item[] {
            new Item("Conjured Mana Cake", 1, 5)};
        int days =3;
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void OtherItemsQuality(){
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20)};
        int days =3;
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(17, app.items[0].quality);
    }
    @Test
    void OtherItemQualityWhenExpired(){
        Item[] items = new Item[] {
            new Item("Elixir of the Mongoose", 1, 5)};
        int days =3;
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(1, app.items[0].quality);
    }
}

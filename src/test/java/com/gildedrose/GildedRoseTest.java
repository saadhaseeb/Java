package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void TestGildedRose() {
        Item[] items = new Item[] {                      //Initialized Item array
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 48),
            new Item("Elixir of the Mongoose", 1, 5),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 15),
            new Item("Conjured Mana Cake", 1, 5),
            new Item("Conjured Mana Cake", 5, 10)};

        int days =3;                            // Process the updateQuality for 3 days
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {        // Calling updateQuality and displaying all Items state for each day
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
        System.out.println("-------- day " + days + " --------");
        System.out.println("name, sellIn, quality");
        for (Item item : items) {
            System.out.println(item);
        }


        //Checking Each Items Quality Value on 3rd day
        assertEquals(17, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
        assertEquals(1, app.items[2].quality);
        assertEquals(80, app.items[3].quality);
        assertEquals(80, app.items[4].quality);
        assertEquals(23, app.items[5].quality);
        assertEquals(50, app.items[6].quality);
        assertEquals(50, app.items[7].quality);
        assertEquals(0, app.items[8].quality);
        assertEquals(0, app.items[9].quality);
        assertEquals(4, app.items[10].quality);
    }

}

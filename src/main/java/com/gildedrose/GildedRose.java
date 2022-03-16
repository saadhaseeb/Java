package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {		//Sulfuras is a legendary item it's sell in and quality will remain same

                if(items[i].name.equals("Aged Brie") ) {					// Aged Brie item quality will only increase with time
                    if(items[i].quality < 50) {
                        items[i].quality++;
                    }
                }else if(items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if(items[i].sellIn < 0 && items[i].quality != 0) {		// When expiration date is passed the quality for Backstage item will be zero
                        items[i].quality = 0;
                    }else {
                        if(items[i].quality < 50) {							// Once quality reaches 50 we don't need to change it
                            if (items[i].sellIn < 6) {						// If Backstage item sell in time is less than or equal to 5 its quality will increase by three times
                                items[i].quality += 3;
                            }else if (items[i].sellIn < 11) {				// If Backstage item sell in time is less than or equal to 10 its quality will increase by two times
                                items[i].quality += 2;
                            }else {
                                items[i].quality++;							// Else its quality will increase at normal pace
                            }
                            if(items[i].quality > 50) {						// Boundary condition it will never let quality increase more than 50
                                items[i].quality = 50;
                            }
                        }
                    }
                }else {														// for rest of the items the quality will be graded as day goes by
                    if (items[i].quality > 0 ) {								// Once quality reaches 0 we don't need to change it
                        if (items[i].sellIn < 0 ) {
                            if(items[i].name.equals("Conjured Mana Cake")) {			// If sell by date has passed for the Conjured Item quality will be degraded 4 times faster
                                items[i].quality -= 4;
                            }else {
                                items[i].quality -= 2;						// For other items If sell by date has passed their quality will be degraded twice as fast
                            }
                        }else {
                            if(items[i].name.equals("Conjured Mana Cake")) {			// If it is Conjured Item than its quality will be degraded in 2 times faster
                                items[i].quality -= 2;
                            }else {
                                items[i].quality--;							// For other items their quality will be degraded at normal pace
                            }
                        }
                        if(items[i].quality < 0) {							// Boundary condition it will never let quality decrease less than zero
                            items[i].quality = 0;
                        }
                    }
                }
                items[i].sellIn--;											// At every day end the Sell in value decreases
            }
        }
    }
}

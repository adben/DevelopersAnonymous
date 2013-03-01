package org.joyofcoding.objectcalisthenics;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    public static void main(String[] args) {
        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(gildedRose.makeItems());
    }

    public List<Item> makeItems() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
        return items;
    }

    public void updateQuality(List<Item> list) {
        List<Item> items = list;
        for (int i = 0; i < items.size(); i++) {
            if (!"Aged Brie".equals(items.get(i).getName())
                    && !"Backstage passes to a TAFKAL80ETC concert".equals(items
                    .get(i)
                    .getName())) {
                if (items.get(i).getQuality() > 0) {
                    if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
                        Item.decreaseItemQuality(items, i);
                    }
                }
            } else {
                if (items.get(i).getQuality() < 50) {
                    Item.increaseItemQuality(items, i);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(items
                            .get(i)
                            .getName())) {
                        if (items.get(i).getSellIn() < 11) {
                            Item.sellInItemsQualityIncrease(items, i);
                        }

                        if (items.get(i).getSellIn() < 6) {
                            Item.sellInItemsQualityIncrease(items, i);
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
                items.get(i).setSellIn(items.get(i).getSellIn() - 1);
            }

            if (items.get(i).getSellIn() < 0) {
                if (!items.get(i).getName().equals("Aged Brie")) {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(items
                            .get(i)
                            .getName())) {
                        if (items.get(i).getQuality() > 0) {
                            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
                                Item.decreaseItemQuality(items, i);
                            }
                        }
                    } else {
                        items.get(i).setQuality(
                                items.get(i).getQuality()
                                        - items.get(i).getQuality());
                    }
                } else {
                    Item.sellInItemsQualityIncrease(items, i);
                }
            }
        }
    }

}

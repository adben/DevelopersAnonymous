package org.joyofcoding.objectcalisthenics;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
    private static final String DEXTERITY_VEST = "+5 Dexterity Vest";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";

    public static void main(String[] args) {
        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(gildedRose.makeItems());
    }

    public List<Item> makeItems() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item(DEXTERITY_VEST, 10, 20));
        items.add(new Item(AGED_BRIE, 2, 0));
        items.add(new Item(ELIXIR_OF_THE_MONGOOSE, 5, 7));
        items.add(new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80));
        items.add(new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 15, 20));
        items.add(new Item(CONJURED_MANA_CAKE, 3, 6));
        return items;
    }

    public void updateQuality(List<Item> list) {
        for (Item item : list) {
            if (!AGED_BRIE.equals(item.getName())
                    && !BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT.equals(item.getName())) {
                if (item.getQuality() > 0) {
                    if (!SULFURAS_HAND_OF_RAGNAROS.equals(item.getName())) {
                        Item.decreaseItemQuality(item);
                    }
                }
            } else {
                if (item.getQuality() < 50) {
                    Item.increaseItemQuality(item);

                    if (BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT.equals(item.getName())) {
                        if (item.getSellIn() < 11) {
                            Item.sellInItemsQualityIncrease(item);
                        }

                        if (item.getSellIn() < 6) {
                            Item.sellInItemsQualityIncrease(item);
                        }
                    }
                }
            }

            if (!SULFURAS_HAND_OF_RAGNAROS.equals(item.getName())) {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0) {
                if (!item.getName().equals(AGED_BRIE)) {
                    if (!BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT.equals(item.getName())) {
                        if (item.getQuality() > 0) {
                            if (!SULFURAS_HAND_OF_RAGNAROS.equals(item.getName())) {
                                Item.decreaseItemQuality(item);
                            }
                        }
                    } else {
                        item.setQuality(
                                item.getQuality()
                                        - item.getQuality());
                    }
                } else {
                    Item.sellInItemsQualityIncrease(item);
                }
            }
        }
    }

}

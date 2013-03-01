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
        List<Item> items = list;
        for (int i = 0; i < items.size(); i++) {
            if (!AGED_BRIE.equals(items.get(i).getName())
                    && !BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT.equals(items
                    .get(i)
                    .getName())) {
                if (items.get(i).getQuality() > 0) {
                    if (!SULFURAS_HAND_OF_RAGNAROS.equals(items.get(i).getName())) {
                        Item.decreaseItemQuality(items, i);
                    }
                }
            } else {
                if (items.get(i).getQuality() < 50) {
                    Item.increaseItemQuality(items, i);

                    if (BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT.equals(items
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

            if (!SULFURAS_HAND_OF_RAGNAROS.equals(items.get(i).getName())) {
                items.get(i).setSellIn(items.get(i).getSellIn() - 1);
            }

            if (items.get(i).getSellIn() < 0) {
                if (!items.get(i).getName().equals(AGED_BRIE)) {
                    if (!BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT.equals(items
                            .get(i)
                            .getName())) {
                        if (items.get(i).getQuality() > 0) {
                            if (!SULFURAS_HAND_OF_RAGNAROS.equals(items.get(i).getName())) {
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

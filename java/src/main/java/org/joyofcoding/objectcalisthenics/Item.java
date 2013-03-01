package org.joyofcoding.objectcalisthenics;

import java.util.List;

public class Item {
    private String name;
    private int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
    }

    static void decreaseItemQuality(List<Item> items, int i) {
        items.get(i).setQuality(items.get(i).getQuality() - 1);
    }

    static void increaseItemQuality(List<Item> items, int i) {
        items.get(i).setQuality(items.get(i).getQuality() + 1);
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}

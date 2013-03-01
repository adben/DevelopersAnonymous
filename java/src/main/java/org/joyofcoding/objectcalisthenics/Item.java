package org.joyofcoding.objectcalisthenics;

public class Item {
    private String name;
    private int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
    }

    static void decreaseItemQuality(Item item) {
        item.setQuality(item.getQuality() - 1);
    }

    static void increaseItemQuality(Item item) {
        item.setQuality(item.getQuality() + 1);
    }

    static void sellInItemsQualityIncrease(Item item) {
        if (item.getQuality() < 50) {
            increaseItemQuality(item);
        }
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

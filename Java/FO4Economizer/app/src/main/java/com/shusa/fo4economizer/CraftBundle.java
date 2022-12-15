package com.shusa.fo4economizer;

public class CraftBundle {
    private Item item = new Item();
    private int count = 0;

    public CraftBundle(final Item _ITEM, final int _COUNT) {
        item = _ITEM;
        count = _COUNT;
    }

    public CraftBundle() {

    }

    public Item getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }
}

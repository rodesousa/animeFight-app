package fr.android.animefight.bean.inventory;

import fr.android.animefight.bean.Item;

/**
 * Created by rodesousa on 15/03/16.
 */
public class CaseInventory {
    private int count;
    private Item item;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}

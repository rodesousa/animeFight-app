package fr.android.animefight.bean.inventory;

import fr.android.animefight.bean.Item;

import java.io.Serializable;

/**
 * Created by rodesousa on 15/03/16.
 */
public class CaseInventory implements Serializable{
    private int count;
    private Item item;

    public CaseInventory(int count, Item item) {
        this.count = count;
        this.item = item;
    }

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

package fr.android.animefight.bean.inventory;

import fr.android.animefight.bean.items.Item;

import java.io.Serializable;

/**
 * Created by rodesousa on 15/03/16.
 */
public class CaseInventory implements Serializable{
    private Item item;

    public CaseInventory(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}

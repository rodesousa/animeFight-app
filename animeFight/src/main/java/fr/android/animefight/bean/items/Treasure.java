package fr.android.animefight.bean.items;

import fr.android.animefight.bean.Item;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rodesousa on 07/04/16.
 */
public class Treasure implements Serializable {
    private boolean isOpenned = false;
    private int xp;
    private List<Item> itemList;

    public Treasure(int xp, List<Item> itemList) {
        this.xp = xp;
        this.itemList = itemList;
    }

    public boolean isOpenned() {
        return isOpenned;
    }

    public void setOpenned(boolean openned) {
        isOpenned = openned;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}

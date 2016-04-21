package fr.android.animefight.bean.items.treasure;

import fr.android.animefight.R;
import fr.android.animefight.bean.items.Item;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rodesousa on 07/04/16.
 */
public class Treasure extends Item implements Serializable {
    private boolean isOpenned = false;
    private int xp;
    private List<Item> itemList;

    public Treasure(int xp, List<Item> itemList) {
        super(R.drawable.dbzicon, "Tresor", "Ceci est un trésor");
        this.xp = xp;
        this.itemList = itemList;
    }

    public Treasure(int imagePath, String name, String description) {
        super(imagePath, name, description);
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

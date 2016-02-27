package fr.android.animefight.bean.items;

import fr.android.animefight.bean.Item;

/**
 * Created by rohamdi on 17/02/2016.
 */
public class Consumable implements Item {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getImagePath() {
        return "consumable_" + this.getName();
    }
}

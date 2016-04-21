package fr.android.animefight.bean.items;

import java.io.Serializable;

/**
 * Created by rohamdi on 17/02/2016.
 */
public abstract class Item implements Serializable {
    private int imagePath;
    private String name;
    private String description;
    private int count;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getImagePath() {
        return imagePath;
    }

    public Item(int imagePath, String name, String description) {
        this.imagePath = imagePath;
        this.name = name;
        this.description = description;
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

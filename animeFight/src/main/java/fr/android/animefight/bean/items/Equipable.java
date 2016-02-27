package fr.android.animefight.bean.items;

import fr.android.animefight.bean.Item;

/**
 * Created by rohamdi on 17/02/2016.
 */
public abstract class Equipable implements Item {
    private String name;
    private String description;
    private int baseValue;
    private int rarity;
    private int level;


    public Equipable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(int baseValue) {
        this.baseValue = baseValue;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

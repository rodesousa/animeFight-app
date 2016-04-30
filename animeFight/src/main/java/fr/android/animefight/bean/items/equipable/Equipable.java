package fr.android.animefight.bean.items.equipable;

import fr.android.animefight.bean.items.Item;

/**
 * Created by rohamdi on 17/02/2016.
 */
public abstract class Equipable extends Item {
    private int baseValue;
    private int rarity;
    private int level;

    public Equipable(int imagePath, String name, String description, TypeEquip typeEquip) {
        super(imagePath, name, description, typeEquip);
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

    public enum TypeEquip implements TypeItem{
        Weapon("Weapon"),
        Armor("Armor");

        private String value;

        TypeEquip(String v) {
           value = v;
        }

        @Override
        public String get() {
            return value;
        }
    }
}

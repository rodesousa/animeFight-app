package fr.android.animefight.bean.items.consumable;

import fr.android.animefight.bean.items.Item;

/**
 * Created by rohamdi on 17/02/2016.
 */
public abstract class Consumable extends Item {
    public Consumable(int imagePath, String name, String description, TypeItem type) {
        super(imagePath, name, description, type);
    }

    public enum TypeConso implements TypeItem{
        ORB("Orb");

        private String value;

        TypeConso(String v) {
           value = v;
        }

        @Override
        public String get() {
            return value;
        }
    }
}

package fr.android.animefight.bean.items.equipable;

/**
 * Created by rohamdi on 17/02/2016.
 */
public class Weapon extends Equipable {

    public Weapon(int imagePath, String name, String description) {
        super(imagePath, name, description, TypeEquip.Weapon);
    }
}

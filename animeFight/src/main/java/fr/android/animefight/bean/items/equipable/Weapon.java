package fr.android.animefight.bean.items.equipable;

import fr.android.animefight.bean.items.Equipable;

/**
 * Created by rohamdi on 17/02/2016.
 */
public class Weapon extends Equipable {
    public Weapon(String name) {
        super(name);
    }
    @Override
    public String getImagePath() {
        return "weapon_"+this.getName();
    }
}

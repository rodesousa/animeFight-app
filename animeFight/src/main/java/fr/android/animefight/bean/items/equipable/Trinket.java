package fr.android.animefight.bean.items.equipable;

import fr.android.animefight.bean.items.Equipable;

/**
 * Created by rohamdi on 17/02/2016.
 */
public class Trinket extends Equipable {
    public Trinket(String name) {
        super(name);
    }

    @Override
    public String getImagePath() {
        return "trinket_"+this.getName();
    }
}

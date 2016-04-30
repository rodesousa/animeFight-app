package fr.android.animefight.bean.items.orb;

import fr.android.animefight.bean.items.consumable.Consumable;

/**
 * Created by rodesousa on 08/04/16.
 */
public class Orb extends Consumable {
    public Orb(int imagePath, String name, String description) {
        super(imagePath, name, description, TypeConso.ORB);
    }
}

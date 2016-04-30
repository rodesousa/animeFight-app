package fr.android.animefight.mock;

import fr.android.animefight.R;
import fr.android.animefight.bean.items.equipable.Armor;
import fr.android.animefight.bean.items.equipable.Weapon;
import fr.android.animefight.bean.items.orb.Orb;

/**
 * Created by rodesousa on 16/04/16.
 */
public class MockItem {

    public static Orb orb() {
        return new Orb(
                R.drawable.orb,
                "Blue Orb",
                "Orb qui sert a lvl up les persos");
    }

    public static Armor armor() {
        return new Armor(R.drawable.armor,
                "SImple Armor",
                "Une simple armure");
    }

    public static Weapon weapon() {
        return new Weapon(R.drawable.sword,
                "Simple Epee",
                "Une simple epée");
    }
}


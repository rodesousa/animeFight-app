package fr.android.animefight.mock;

import fr.android.animefight.R;
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
}

package fr.android.animefight.model;

import fr.android.animefight.bean.Item;
import fr.android.animefight.bean.items.Orb;
import fr.android.animefight.bean.items.Treasure;
import fr.android.animefight.fight.Fight;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodesousa on 08/04/16.
 */
public class GiverTreasures {

    public static Treasure give(Fight fight) {
        Treasure treasure = null;
        List<Item> itemList = new ArrayList<>();
        int xp = 0;
        if (fight.getLvl() == 1) {
            xp = 10;
            itemList.add(new Orb());
            treasure = new Treasure(xp, itemList);
        }
        return treasure;
    }

}

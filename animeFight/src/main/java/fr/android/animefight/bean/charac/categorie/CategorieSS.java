package fr.android.animefight.bean.charac.categorie;

import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.charac.Categorie;

/**
 * Created by rodesousa on 01/03/16.
 */
public class CategorieSS extends Categorie {
    public CategorieSS() {
        super("SS");
    }

    public static Character init(String name) {
        Character tmp = new Character(name);
        tmp.setLife(100);
        tmp.setLifeCurrent(100);
        tmp.setVitesse(50);
        tmp.setAttack(10);
        tmp.setDefense(2);
        tmp.setCategorie(new CategorieSS());
        return tmp;
    }

}

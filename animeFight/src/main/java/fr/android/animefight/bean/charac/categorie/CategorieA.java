package fr.android.animefight.bean.charac.categorie;

import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.charac.Categorie;

/**
 * Created by rodesousa on 01/03/16.
 */
public class CategorieA extends Categorie {

    public CategorieA() {
        super("A");
    }

    public static Character init(String name) {
        Character tmp = new Character(name);
        tmp.setLife(100);
        tmp.setVitesse(50);
        tmp.setCategorie(new CategorieA());
        return tmp;
    }

}

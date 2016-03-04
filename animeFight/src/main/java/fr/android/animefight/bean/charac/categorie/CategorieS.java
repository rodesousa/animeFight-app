package fr.android.animefight.bean.charac.categorie;

import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.charac.Categorie;

/**
 * Created by rodesousa on 01/03/16.
 */
public class CategorieS extends Categorie {
    public CategorieS() {
        super("S");
    }

    public static Character init() {
        Character tmp = new Character("todo");
        tmp.setLife(130);
        tmp.setLifeCurrent(130);
        tmp.setVitesse(70);
        tmp.setCategorie(new CategorieB());
        return tmp;
    }
}

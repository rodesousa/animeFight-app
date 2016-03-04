package fr.android.animefight.bean.charac.categorie;

import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.charac.Categorie;

/**
 * Created by rodesousa on 01/03/16.
 */
public class CategorieC extends Categorie {
    public CategorieC() {
        super("C");
    }

    public static Character init() {
        Character tmp = new Character("todo");
        tmp.setLife(60);
        tmp.setLifeCurrent(60);
        tmp.setVitesse(15);
        tmp.setCategorie(new CategorieB());
        return tmp;
    }
}

package fr.android.animefight.bean.charac.categorie;

import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.charac.Categorie;

/**
 * Created by rodesousa on 01/03/16.
 */
public class CategorieB extends Categorie {
    public CategorieB() {
        super("B");
    }

    public static Character init(String name) {
        Character tmp = new Character("todo");
        tmp.setLife(80);
        tmp.setVitesse(30);
        tmp.setCategorie(new CategorieB());
        return tmp;
    }
}

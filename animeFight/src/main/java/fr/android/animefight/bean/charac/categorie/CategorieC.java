package fr.android.animefight.bean.charac.categorie;

import fr.android.animefight.bean.charac.Character;
import fr.android.animefight.bean.perso.Perso;

/**
 * Created by rodesousa on 01/03/16.
 */
public class CategorieC extends Categorie {
    public CategorieC() {
        super("C");
    }

    @Override
    public Character init(Perso perso) {
        return declareCharacter(perso, 100, 50, 10, 2);
    }

}

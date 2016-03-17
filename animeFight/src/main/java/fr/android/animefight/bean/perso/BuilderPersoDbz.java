package fr.android.animefight.bean.perso;

import fr.android.animefight.R;
import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.Perso;
import fr.android.animefight.bean.charac.categorie.CategorieA;
import fr.android.animefight.bean.charac.categorie.CategorieSS;

/**
 * Created by rodesousa on 17/03/16.
 */
public class BuilderPersoDbz {

    public static Character goku() {
        return new Perso(new CategorieSS(), R.drawable.char_goku, R.drawable.naru, "Goku").init();
    }

    public static Character krilin() {
        return new Perso(new CategorieA(), R.drawable.char_unknown, R.drawable.naru, "Krilin").init();
    }

    public static Character bulma() {
        return new Perso(new CategorieA(), R.drawable.char_unknown, R.drawable.naru, "Bulma").init();
    }

    public static Character ptero() {
        return new Perso(new CategorieA(), R.drawable.char_unknown, R.drawable.naru, "Ptero").init();
    }
}

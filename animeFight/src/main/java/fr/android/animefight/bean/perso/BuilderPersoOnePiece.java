package fr.android.animefight.bean.perso;

import fr.android.animefight.R;
import fr.android.animefight.bean.charac.Character;
import fr.android.animefight.bean.charac.categorie.CategorieB;
import fr.android.animefight.bean.charac.categorie.CategorieSS;

/**
 * Created by rodesousa on 17/03/16.
 */
public class BuilderPersoOnePiece {

    public static Character luffy() {
        return new Perso(new CategorieSS(), R.drawable.char_luffy, R.drawable.naru, "Luffy").init();
    }

    public static Character baggy() {
        return new Perso(new CategorieB(), R.drawable.char_unknown, R.drawable.naru, "Baggy").init();
    }

    public static Character morgan() {
        return new Perso(new CategorieB(), R.drawable.char_unknown, R.drawable.naru, "Morgan").init();
    }

    public static Character hermep() {
        return new Perso(new CategorieB(), R.drawable.char_unknown, R.drawable.naru, "Hermep").init();
    }

    public static Character zorro() {
        return new Perso(new CategorieB(), R.drawable.char_unknown, R.drawable.naru, "Zorro").init();
    }

    public static Character alvida() {
        return new Perso(new CategorieB(), R.drawable.char_unknown, R.drawable.naru, "Alvida").init();
    }
}

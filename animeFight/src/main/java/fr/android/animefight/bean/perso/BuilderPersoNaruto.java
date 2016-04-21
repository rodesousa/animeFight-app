package fr.android.animefight.bean.perso;

import fr.android.animefight.R;
import fr.android.animefight.bean.charac.Character;
import fr.android.animefight.bean.charac.categorie.CategorieB;
import fr.android.animefight.bean.charac.categorie.CategorieSS;

/**
 * Created by rodesousa on 17/03/16.
 */
public class BuilderPersoNaruto {

    public static Character naruto() {
        return new Perso(new CategorieSS(), R.drawable.char_naruto, R.drawable.naru, "Naruto").init();
    }

    public static Character sasuke() {
        return new Perso(new CategorieSS(), R.drawable.char_unknown, R.drawable.naru, "Sasuke").init();
    }

    public static Character misuki() {
        return new Perso(new CategorieB(), R.drawable.char_unknown, R.drawable.naru, "Misuki").init();
    }

    public static Character iruka() {
        return new Perso(new CategorieB(), R.drawable.char_unknown, R.drawable.naru, "iruka").init();
    }
}

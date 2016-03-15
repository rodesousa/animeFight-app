package fr.android.animefight.bean.team;

import fr.android.animefight.bean.Character;
import fr.android.animefight.utils.Option;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Soit A=Ataquant et V=Vide
 * on peut voir une formation comme ça
 * V A V A
 * A V A A
 * <p/>
 * vs
 * <p/>
 * V A A A
 * A V V V
 * <p/>
 * Une ligne de formation est une List de CHaracter. Or les casses d'une formation peuvent être vide. Parce que null
 * c'est pour les nuls, on utilise un Option. Pour savoir si il y a un character, Option<Character>, ou vide, None
 * Comme dans une formation on peut avoir plusieurs ligne du coup, List<List<Option<Character>>>
 * Created by rodesousa on 23/02/16.
 */
public class Formation implements Serializable, Cloneable {
    private List<List<Option<Character>>> listCharacters;

    public void setCharacters(List<Option<Character>> characters, int i) {
        listCharacters.set(i, characters);
    }

    public List<List<Option<Character>>> getListCharacters() {
        return listCharacters;
    }

    public void setListCharacters(List<List<Option<Character>>> listCharacters) {
        this.listCharacters = listCharacters;
    }

    public Formation(List<List<Option<Character>>> listCharacters) {
        this.listCharacters = listCharacters;
    }

    /**
     * inspiré de la fonction flatten/flat de scala, on casse la 2eme diemnsion pour construire une list d'un seul
     * dimension. C'est utile pour le TeamManagement pour faciliter l'accès au personnage de la formation sans que la
     * position soit necessaire.
     *
     * @return
     */
    public List<Option<Character>> flat() {
        List<Option<Character>> list = new ArrayList<>();
        for (List<Option<Character>> character : listCharacters) {
            for (Option<Character> characterOption : character) {
                list.add(characterOption);
            }
        }
        return list;
    }

}

package fr.android.animefight.bean.perso.team;

import fr.android.animefight.bean.Character;
import fr.android.animefight.utils.Option;
import fr.android.animefight.utils.Some;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * L'objet formation est un poil compliqué, on passe par le design pattern builder pour construire notre objet.
 * Il y a plusieurs paramètre d'entré pour avoir une fléxibilité.
 * Created by rodesousa on 23/02/16.
 */
public class FormationBuilder {

    public static Formation FormationWithCharacter(Character charac) {
        return FormationWithCharacters(Collections.singletonList(charac));
    }

    public static Formation FormationWithListCharacters(List<List<Option<Character>>> lists) {
        return new Formation(lists);

    }

    public static Formation FormationWithCharacters(List<Character> character) {
        List<Option<Character>> tmp = new ArrayList<>();
        for (Character character1 : character) {
            tmp.add(new Some<Character>(character1));
        }
        return FormationWithOptionCharacters(tmp);
    }

    public static Formation FormationWithOptionCharacters(List<Option<Character>> characters) {
        return new Formation(Collections.singletonList(characters));
    }

}

package fr.android.animefight.bean.team;

import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.Tacticien;
import fr.android.animefight.utils.None;
import fr.android.animefight.utils.Option;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohamdi on 17/02/2016.
 * <p/>
 * Tout ce qui compose une team.
 */
public class Team implements Serializable {
    private Tacticien tacticien;
    private Formation formation;

    public Team(Formation characters, Tacticien tacticien) {
        this.formation = characters;
        initFormation(tacticien);
    }

    public Team(Tacticien tacticien) {
        initFormation(tacticien);
    }

    /**
     * On créer la formation para rapport au tacticien
     *
     * @param tacticien
     */
    private void initFormation(Tacticien tacticien) {
        this.tacticien = tacticien;
        List<List<Option<Character>>> listCharacters = new ArrayList<>();

        for (int i = 0; i < tacticien.getRaw(); i++) {
            List<Option<Character>> characters = new ArrayList<>();
            for (int i1 = 0; i1 < tacticien.getColumn(); i1++) {
                characters.add(new None<Character>());
            }
            listCharacters.add(characters);
        }

        this.formation = new Formation(listCharacters);
    }


    public Tacticien getTacticien() {
        return tacticien;
    }

    public Formation getFormation() {
        return formation;
    }

    // pour faciliter l'accès aux données
    public List<Option<Character>> flat() {
        return formation.flat();
    }

    // pour faciliter l'accès aux données
    public Character getFlatCharacter(int i) {
        return flat().get(i).get();
    }
}

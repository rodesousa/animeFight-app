package fr.android.animefight.bean.team;

import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.Tacticien;
import fr.android.animefight.utils.Option;

import java.io.Serializable;
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
        this.tacticien = tacticien;
    }

    public Team(Tacticien tacticien) {
        this.tacticien = tacticien;
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

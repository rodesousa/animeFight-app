package com.example.animeFight_app.bean.team;

import com.example.animeFight_app.utils.Option;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rohamdi on 17/02/2016.
 * <p>
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
    public List<Option<Character>> getCharacters() {
        return formation.flat();
    }

    // pour faciliter l'accès aux données
    public Character getCharacter(int i) {
        return getCharacters().get(i).get();
    }
}

package fr.android.animefight.bean.perso;

import fr.android.animefight.bean.charac.Character;
import fr.android.animefight.bean.charac.Tacticien;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohamdi on 17/02/2016.
 * <p>
 * Tout ce qui compose une team.
 */
public class Team implements Serializable {
    private Tacticien tacticien;
    private List<Character> characters;

    public Team(List<Character> characters, Tacticien tacticien) {
        this.characters = characters;
        initFormation(tacticien);
    }

    /**
     * On créer la formation para rapport au tacticien
     *
     * @param tacticien
     */
    private void initFormation(Tacticien tacticien) {
        this.tacticien = tacticien;
    }

    public void setTacticien(Tacticien tacticien) {
        this.tacticien = tacticien;
    }

    public Tacticien getTacticien() {
        return tacticien;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public List<Character> copy() {
        List<Character> charactersCopy = new ArrayList<>();
        for (Character character : characters) {
            charactersCopy.add(character);
        }
        return charactersCopy;
    }

    public boolean isFightable() {
        if (characters.size() > 0)
            return true;
        return false;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}

package fr.android.animefight.model;

import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.Inventory;
import fr.android.animefight.bean.Tacticien;
import fr.android.animefight.bean.perso.Team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Le joueur
 * <p/>
 * Created by rodesousa on 14/03/16.
 */
public class Player implements Serializable {
    private Team team;
    private final Inventory inventory;
    private List<Character> characters;
    private List<Tacticien> tacticiens;


    public Player() {
        this.inventory = new Inventory();
        this.team = null;
        this.tacticiens = new ArrayList<>();
        this.characters = new ArrayList<>();
    }

    public List<Character> copy() {
        List<Character> charactersCopy = new ArrayList<>();
        for (Character character : characters) {
            charactersCopy.add(character);
        }
        return charactersCopy;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Team getTeam() {
        return team;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public List<Tacticien> getTacticiens() {
        return tacticiens;
    }

    public void setTacticiens(List<Tacticien> tacticiens) {
        this.tacticiens = tacticiens;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean fintTacticien(Tacticien tacticien) {
        for (Tacticien tacticien1 : tacticiens) {
            if (tacticien1 == tacticien)
                return true;
        }
        return false;
    }

}

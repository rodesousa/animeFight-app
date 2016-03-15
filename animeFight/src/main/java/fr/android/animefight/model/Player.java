package fr.android.animefight.model;

import fr.android.animefight.bean.Inventory;
import fr.android.animefight.bean.team.Team;

import java.io.Serializable;

/**
 * Le joueur
 * <p/>
 * Created by rodesousa on 14/03/16.
 */
public class Player implements Serializable {
    private Team team;
    private final Inventory inventory;

    public Player() {
        this.inventory = new Inventory();
        this.team = null;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

package fr.android.animefight.model;

import fr.android.animefight.bean.team.Team;

import java.io.Serializable;

/**
 * Le joueur
 *
 * Created by rodesousa on 14/03/16.
 */
public class Player implements Serializable {
    private Team team;

    public Player() {
        this.team = null;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

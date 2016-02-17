package com.example.animeFight_app.model;

import com.example.animeFight_app.bean.team.Team;

import java.io.Serializable;

/**
 * Created by rodesousa on 17/02/16.
 */
public class Model implements Serializable {

    private Team team;

    public Model() {
        team = new Team();
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

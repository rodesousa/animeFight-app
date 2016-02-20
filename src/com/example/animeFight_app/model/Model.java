package com.example.animeFight_app.model;

import com.example.animeFight_app.bean.team.Team;
import com.example.animeFight_app.model.world.World;

import java.io.Serializable;

/**
 * Created by rodesousa on 17/02/16.
 */
public class Model implements Serializable {
    private final Team team;
    private final State state;
    private World world;

    public Model() {
        team = new Team();
        state = new State();
        world = new World();
    }

    public Team getTeam() {
        return team;
    }

    public State getState() {
        return state;
    }

    public World getWorld() {
        return world;
    }
}

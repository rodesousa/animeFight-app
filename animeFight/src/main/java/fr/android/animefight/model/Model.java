package fr.android.animefight.model;

import fr.android.animefight.bean.team.Team;
import fr.android.animefight.model.world.World;

import java.io.Serializable;

/**
 * Created by rodesousa on 17/02/16.
 */
public class Model implements Serializable {
    private Team team;
    private final State state;
    private World world;

    public Model() {
        team = null;
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

    public void setTeam(Team t) {
        this.team = t;
    }
}

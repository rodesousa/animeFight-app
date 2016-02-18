package com.example.animeFight_app.model;

import com.example.animeFight_app.model.world.World;

import java.io.Serializable;

/**
 * Created by rodesousa on 18/02/16.
 */
public class State implements Serializable {
    private boolean begining;
    private World world;

    public State() {
        this.begining = true;
        world = new World();
    }

    public boolean isBegining() {
        return begining;
    }

    public void setBegining(boolean begining) {
        this.begining = begining;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}

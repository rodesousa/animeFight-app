package com.example.animeFight_app.model.world;

import java.io.Serializable;

/**
 * Created by rodesousa on 18/02/16.
 */
public class World implements Serializable {
    private String world;

    @Override
    public String toString() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }
}

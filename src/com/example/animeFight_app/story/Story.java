package com.example.animeFight_app.story;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rodesousa on 19/02/16.
 */
public abstract class Story implements Serializable {
    private List<Arc> arcList;
    private String name;

    public Story(final String name, final List<Arc> arcList) {
        this.name = name;
        this.arcList = arcList;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Arc> getArcList() {
        return arcList;
    }
}
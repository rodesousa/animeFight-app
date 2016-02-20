package com.example.animeFight_app.story;

import com.example.animeFight_app.fight.Fight;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rodesousa on 18/02/16.
 */
public class Arc implements Serializable {

    private String name;
    private List<Fight> fightList;

    public Arc(String name, List<Fight> fightList) {
        this.name = name;
        this.fightList = fightList;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Fight> getFightList() {
        return fightList;
    }
}
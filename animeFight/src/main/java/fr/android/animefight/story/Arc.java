package fr.android.animefight.story;

import fr.android.animefight.fight.Fight;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rodesousa on 18/02/16.
 * COntient la list des fight d'un arc
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
package fr.android.animefight.model.story;

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
    private boolean state;

    public Arc(String name, List<Fight> fightList) {
        this.name = name;
        this.fightList = fightList;
        state = false;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public List<Fight> getFightList() {
        return fightList;
    }
}

package fr.android.animefight.model;

import java.io.Serializable;

/**
 * Created by rodesousa on 18/02/16.
 * <p/>
 * L'etat du jeu
 */
public class State implements Serializable {
    private boolean begining;

    public State() {
        this.begining = true;
    }

    public boolean isBegining() {
        return begining;
    }

    public void setBegining(boolean begining) {
        this.begining = begining;
    }

}

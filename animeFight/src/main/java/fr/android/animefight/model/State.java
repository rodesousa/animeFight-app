package fr.android.animefight.model;

import java.io.Serializable;

/**
 * Created by rodesousa on 18/02/16.
 *
 * Tout ce qui est model pour l'etat du jeu
 */
public class State implements Serializable {
    private boolean begining;
    private int step;

    public State() {
        this.begining = true;
    }

    public boolean isBegining() {
        return begining;
    }

    public void setBegining(boolean begining) {
        this.begining = begining;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public final int CORE = 1;
    public final int STORIES = 2;
    public final int ARCS = 3;
}

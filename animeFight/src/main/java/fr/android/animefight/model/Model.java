package fr.android.animefight.model;

import java.io.Serializable;

/**
 * UN model comporte:
 * l'état du jeu @state
 * le mode story @modeStory
 * le player @player
 * Created by rodesousa on 17/02/16.
 */
public class Model implements Serializable {
    private State state;
    private final ModeStory modeStory;
    private final Player player;

    public Model() {
        state = State.BEGINING;
        modeStory = new ModeStory();
        player = new Player();
    }

    public ModeStory getModeStory() {
        return modeStory;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Player getPlayer() {
        return player;
    }
}


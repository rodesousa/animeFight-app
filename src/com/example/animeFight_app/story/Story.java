package com.example.animeFight_app.story;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rodesousa on 19/02/16.
 * Contient la liste des arc qu'un story contient
 */
public abstract class Story implements Serializable {
    private List<Arc> arcList;
    private String name;

    public Story(final String name) {
        this.name = name;
        this.arcList = makeStory();
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Arc> getArcList() {
        return arcList;
    }

    /**
     * Declaration de la story
     * @return
     */
    protected abstract List<Arc> makeStory();

    /**
     * En cas de déserialisation
     * @return
     */
    protected abstract Object readResolve();
}
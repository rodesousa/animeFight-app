package fr.android.animefight.controller;

import fr.android.animefight.model.Model;

import java.io.Serializable;

/**
 * Created by rodesousa on 16/04/16.
 */
public abstract class Controller implements Serializable {

    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }
}

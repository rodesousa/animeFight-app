package fr.android.animefight.controller;

import fr.android.animefight.model.Model;

import java.io.Serializable;

/**
 * Created by rodesousa on 16/04/16.
 */
public class Controller implements Serializable {

    protected Model model;

    public Controller(Model model) {
        this.model = model;
    }


    public Controller() {
        this.model = new Model();
    }

    public Model getModel() {
        return model;
    }
}

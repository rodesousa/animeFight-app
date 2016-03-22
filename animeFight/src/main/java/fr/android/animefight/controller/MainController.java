package fr.android.animefight.controller;

import fr.android.animefight.model.Model;

import java.io.Serializable;

/**
 * Created by rodesousa on 18/02/16.
 */
public class MainController implements Serializable {

    private Model model;

    public MainController() {
//        this.model = MockModel.factoryModel();
        model = new Model();
    }

    public MainController(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }
}

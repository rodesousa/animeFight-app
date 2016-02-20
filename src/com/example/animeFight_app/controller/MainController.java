package com.example.animeFight_app.controller;

import com.example.animeFight_app.mock.MockModel;
import com.example.animeFight_app.model.Model;

import java.io.Serializable;

/**
 * Created by rodesousa on 18/02/16.
 */
public class MainController implements Serializable {
    private Model model;

    public MainController() {
        this.model = MockModel.factoryModel();
    }

    public MainController(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }
}

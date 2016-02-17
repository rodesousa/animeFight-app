package com.example.animeFight_app.mock;

import com.example.animeFight_app.bean.team.Character;
import com.example.animeFight_app.model.Model;

/**
 * Created by rodesousa on 17/02/16.
 */
public class MockModel {

    public static Model factoryModel() {
        Model model = new Model();
        Character shinkawa = new Character();
        Character lowtuz = new Character();
        shinkawa.setName("Shinkawa");
        lowtuz.setName("lowtuz");

        model.getTeam().getCharacters().add(lowtuz);
        model.getTeam().getCharacters().add(shinkawa);
        return model;
    }

}

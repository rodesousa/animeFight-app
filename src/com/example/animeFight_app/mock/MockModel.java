package com.example.animeFight_app.mock;

import com.example.animeFight_app.bean.team.Character;
import com.example.animeFight_app.bean.team.*;
import com.example.animeFight_app.model.Model;

import java.util.Arrays;

/**
 * Created by rodesousa on 17/02/16.
 */
public class MockModel {

    public static Model factoryModel() {
        Model model = new Model();
        Formation formation = FormationBuilder.FormationWithCharacters(Arrays.asList(
                new Character("Shinkawa"),
                new Character("Lowtuz")));
        Tacticien tacticien = new Tacticien("Piccolo-san", 3, 2);
        Team team = new Team(formation, tacticien);
        model.setTeam(team);
        return model;
    }
}

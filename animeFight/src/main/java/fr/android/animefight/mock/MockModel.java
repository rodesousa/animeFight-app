package fr.android.animefight.mock;

import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.Tacticien;
import fr.android.animefight.bean.team.*;
import fr.android.animefight.model.Model;

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

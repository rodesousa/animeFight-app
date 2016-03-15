package fr.android.animefight.mock;

import fr.android.animefight.bean.Tacticien;
import fr.android.animefight.bean.charac.categorie.CategorieSS;
import fr.android.animefight.bean.team.Formation;
import fr.android.animefight.bean.team.FormationBuilder;
import fr.android.animefight.bean.team.Team;
import fr.android.animefight.model.Model;

import java.util.Arrays;

/**
 * Created by rodesousa on 17/02/16.
 */
public class MockModel {

    public static Model factoryModel() {
        Model model = new Model();
        Formation formation = FormationBuilder.FormationWithCharacters(Arrays.asList(
                CategorieSS.init("Shinkawa"),
                CategorieSS.init("Lowtuz")));
        Tacticien tacticien = new Tacticien("L",10);
        Team team = new Team(formation, tacticien);
        model.getPlayer().setTeam(team);
        return model;
    }
}

package fr.android.animefight.mock;

import fr.android.animefight.bean.Character;
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
        Character shinkawa = CategorieSS.init("Shinkawa");
        Character lowtuz = CategorieSS.init("Lowtuz");
        Formation formation = FormationBuilder.FormationWithCharacters(Arrays.asList(
                shinkawa, lowtuz
        ));
        Tacticien tacticien = new Tacticien("L", 10, 2, 3);
//        Team team = new Team(formation, tacticien);
        Team team = new Team(tacticien);
        model.getPlayer().setTeam(team);
        model.getPlayer().getCharacters().addAll(Arrays.asList(lowtuz, shinkawa));
        model.getPlayer().getTacticiens().add(tacticien);

        return model;
    }
}

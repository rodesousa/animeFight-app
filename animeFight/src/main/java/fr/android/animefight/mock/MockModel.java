package fr.android.animefight.mock;

import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.Tacticien;
import fr.android.animefight.bean.perso.BuilderPersoDbz;
import fr.android.animefight.bean.perso.BuilderPersoNaruto;
import fr.android.animefight.bean.team.Team;
import fr.android.animefight.model.Model;
import fr.android.animefight.utils.Some;

import java.util.Arrays;

/**
 * Created by rodesousa on 17/02/16.
 */
public class MockModel {

    public static Model factoryModel() {
        Model model = new Model();
        Character goku = BuilderPersoDbz.goku();
        Character naruto = BuilderPersoNaruto.naruto();
        Tacticien tacticien = new Tacticien("L", 10, 2, 3);
        Team team = new Team(tacticien);
        team.getFormation().getListCharacters().get(0).set(0, new Some<Character>(naruto));
        model.getPlayer().setTeam(team);
        model.getPlayer().getCharacters().addAll(Arrays.asList(naruto, goku));
        model.getPlayer().getTacticiens().add(tacticien);

        return model;
    }
}

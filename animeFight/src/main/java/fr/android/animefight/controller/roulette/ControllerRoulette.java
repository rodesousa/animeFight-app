package fr.android.animefight.controller.roulette;

import fr.android.animefight.bean.charac.Character;
import fr.android.animefight.bean.charac.Tacticien;
import fr.android.animefight.bean.inventory.CaseInventory;
import fr.android.animefight.bean.perso.BuilderPersoDbz;
import fr.android.animefight.bean.perso.Team;
import fr.android.animefight.mock.MockItem;
import fr.android.animefight.model.Model;

import java.util.Arrays;

/**
 * Created by rodesousa on 16/04/16.
 */
public class ControllerRoulette {
    private Model model;

    public ControllerRoulette(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public void finalStep(Character character, Tacticien tacticien) {
        model.getPlayer().getCharacters().addAll(Arrays.asList(character, BuilderPersoDbz.ptero()));
        model.getPlayer().getTacticiens().add(tacticien);

        if (model.getPlayer().getTeam() == null)
            model.getPlayer().setTeam(new Team(model.getPlayer().copy(), tacticien));

        model.getPlayer().getInventory().getCases().add(new CaseInventory(MockItem.orb()));
        model.getPlayer().getInventory().getCases().add(new CaseInventory(MockItem.weapon()));
        model.getPlayer().getInventory().getCases().add(new CaseInventory(MockItem.armor()));
    }
}

package fr.android.animefight.controller.inspectCharacter;

import fr.android.animefight.bean.charac.Character;
import fr.android.animefight.model.Model;

/**
 * Created by rodesousa on 27/04/16.
 */
public class ControllerInspect {
    private Model model;
    private Character character;

    public ControllerInspect(Model model, int indice) {
        this.model = model;
        character = model.getPlayer().getCharacters().get(indice);
    }

    public Character getCharacter() {
        return character;
    }

    public Model getModel() {
        return model;
    }
}

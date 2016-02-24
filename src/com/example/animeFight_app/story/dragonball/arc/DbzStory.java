package com.example.animeFight_app.story.dragonball.arc;

import com.example.animeFight_app.bean.team.Character;
import com.example.animeFight_app.bean.team.*;
import com.example.animeFight_app.fight.Fight;
import com.example.animeFight_app.story.Arc;
import com.example.animeFight_app.story.Story;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rodesousa on 19/02/16.
 */
public class DbzStory extends Story implements Serializable {

    private static DbzStory DBZ = new DbzStory();

    private DbzStory() {
        super("Dragon Ball");
    }

    public static DbzStory getDBZ() {
        return DBZ;
    }

    @Override
    protected Object readResolve() {
        return DBZ;
    }

    @Override
    protected List<Arc> makeStory() {
        List<Arc> arc = new ArrayList<>();
        Tacticien tacticien = new Tacticien("Piccolo-san", 3, 2);

        //ARC1
        String nameArc = "Le commencement !";
        Formation bulma = FormationBuilder.FormationWithCharacter(new Character("Bulma"));
        Formation ptero = FormationBuilder.FormationWithCharacter(new Character("Ptero"));

        arc.add(
                new Arc(nameArc,
                        Arrays.asList(
                                new Fight("Qui est elle ?", new Team(bulma, tacticien)),
                                new Fight("Sauvons la", new Team(ptero, tacticien))
                        )));
        return arc;
    }
}

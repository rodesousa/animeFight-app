package com.example.animeFight_app.story.naruto.arc;

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
 * Created by rodesousa on 20/02/16.
 */
public class NarutoStory extends Story implements Serializable {

    private static NarutoStory NARUTO = new NarutoStory();

    private NarutoStory() {
        super("Naruto", makeFactory());
    }

    public static NarutoStory getNARUTO() {
        return NARUTO;
    }

    private Object readResolve() {
        return NARUTO;
    }

    private static List<Arc> makeFactory() {
        List<Arc> arc = new ArrayList<>();
        Tacticien tacticien = new Tacticien("Piccolo-san", 3, 2);

        //ARC1
        String nameArc = "Le commencement !";

        Formation konoha = FormationBuilder.FormationWithCharacters(Arrays.asList(
                new Character("Ninja Konoha 1"),
                new Character("Ninja Konoha 2")));
        Formation misuki = FormationBuilder.FormationWithCharacter(new Character("Misuki"));
        Formation iruka = FormationBuilder.FormationWithCharacter(new Character("Iruka"));

        arc.add(
                new Arc(nameArc,
                        Arrays.asList(
                                new Fight("Attrapez le ?", new Team(konoha, tacticien)),
                                new Fight("Tu sera punis !", new Team(iruka, tacticien)),
                                new Fight("Rends le moi !!!!!", new Team(misuki, tacticien)))
                )
        );
        return arc;
    }
}

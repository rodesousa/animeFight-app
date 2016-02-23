package com.example.animeFight_app.story.onepiece.arc;

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
public class OnePieceStory extends Story implements Serializable {

    private static OnePieceStory ONEPIECE = new OnePieceStory();

    private OnePieceStory() {
        super("One Piece", makeFactory());
    }

    public static OnePieceStory getONEPIECE() {
        return ONEPIECE;
    }

    private Object readResolve() {
        return ONEPIECE;
    }

    private static List<Arc> makeFactory() {
        List<Arc> arc = new ArrayList<>();
        Tacticien tacticien = new Tacticien("Piccolo-san", 3, 2);

        //ARC1
        String nameArc = "Morgan !";
        Formation first = FormationBuilder.FormationWithCharacters(Arrays.asList(
                new Character("Coby"),
                new Character("Nami")));
        Formation alvida = FormationBuilder.FormationWithCharacter(new Character("Alvida"));
        Formation zorro = FormationBuilder.FormationWithCharacter(new Character("Zorro"));
        Formation hermep = FormationBuilder.FormationWithCharacter(new Character("Hermep"));
        Formation last = FormationBuilder.FormationWithCharacter(new Character("Morgan"));

        arc.add(
                new Arc(nameArc,
                        Arrays.asList(
                                new Fight("Ou je suis ?!?", new Team(first, tacticien)),
                                new Fight("Je suis découvert !", new Team(alvida, tacticien)),
                                new Fight("...", new Team(hermep, tacticien)),
                                new Fight("Tu feras parti de mon équipage", new Team(zorro, tacticien)),
                                new Fight("Vous allez le payer !", new Team(last, tacticien)))
                )
        );
        return arc;
    }
}

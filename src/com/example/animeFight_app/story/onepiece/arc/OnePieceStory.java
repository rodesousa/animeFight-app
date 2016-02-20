package com.example.animeFight_app.story.onepiece.arc;

import com.example.animeFight_app.bean.team.Character;
import com.example.animeFight_app.fight.Fight;
import com.example.animeFight_app.story.Arc;
import com.example.animeFight_app.story.Story;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        //ARC1
        String nameArc = "Morgan !";

        Character Coby = new Character("Coby");
        Character Nami = new Character("Nami");
        Character Alvida = new Character("Alvida");
        Character Morgan = new Character("Morgan");
        Character Zorro = new Character("Zorro");
        Character Hermep = new Character("Hermep");

        arc.add(
                new Arc(nameArc,
                        Arrays.asList(
                                new Fight("Ou je suis ?!?", Arrays.asList(Coby, Nami)),
                                new Fight("Je suis découvert !", Collections.singletonList(Alvida)),
                                new Fight("...", Collections.singletonList(Hermep)),
                                new Fight("Tu feras parti de mon équipage", Collections.singletonList(Zorro)),
                                new Fight("Vous allez le payer !", Arrays.asList(Hermep, Morgan))
                        )
                )
        );
        return arc;
    }
}

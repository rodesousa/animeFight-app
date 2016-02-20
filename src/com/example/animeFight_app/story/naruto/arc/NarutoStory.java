package com.example.animeFight_app.story.naruto.arc;

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

        //ARC1
        String nameArc = "Le commencement !";

        Character NinjaKonoha1 = new Character("Ninja Konoha 1");
        Character NinjaKonoha2 = new Character("Ninja Konoha 2");
        Character Misuki = new Character("Misuki");
        Character Iruka = new Character("Iruka");

        arc.add(
                new Arc(nameArc,
                        Arrays.asList(
                                new Fight("Attrapez le ?", Arrays.asList(NinjaKonoha1, NinjaKonoha2)),
                                new Fight("Tu sera punis !", Collections.singletonList(Iruka)),
                                new Fight("Rends le moi !!!!!", Collections.singletonList(Misuki))
                        )
                )
        );
        return arc;
    }
}

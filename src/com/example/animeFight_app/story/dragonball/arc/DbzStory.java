package com.example.animeFight_app.story.dragonball.arc;

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
 * Created by rodesousa on 19/02/16.
 */
public class DbzStory extends Story implements Serializable {

    private static DbzStory DBZ = new DbzStory();

    private DbzStory() {
        super("Dragon Ball", makeFactory());
    }

    public static DbzStory getDBZ() {
        return DBZ;
    }

    private Object readResolve() {
        return DBZ;
    }

    private static List<Arc> makeFactory() {
        List<Arc> arc = new ArrayList<>();

        //ARC1
        String nameArc = "Le commencement !";

        Character bulma = new Character("Bulma");
        Character ptero = new Character("Ptero");
        arc.add(
                new Arc(nameArc,
                        Arrays.asList(
                                new Fight("Qui est elle ?", Collections.singletonList(bulma)),
                                new Fight("Sauvons la !", Collections.singletonList(ptero)))
                ));
        return arc;
    }
}

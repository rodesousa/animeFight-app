package fr.android.animefight.model.story.naruto.arc;

import fr.android.animefight.bean.charac.Character;
import fr.android.animefight.bean.charac.Tacticien;
import fr.android.animefight.bean.perso.BuilderPersoNaruto;
import fr.android.animefight.bean.perso.Team;
import fr.android.animefight.fight.Fight;
import fr.android.animefight.model.story.Arc;
import fr.android.animefight.model.story.Story;

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
        super("Naruto");

//        //création des starters
//        Character naruto = BuilderPersoNaruto.naruto();
//        Character sasuke = BuilderPersoNaruto.sasuke();
//        Tacticien ramen = new Tacticien("Ramen", 1, 1, 2);
//        Tacticien ninja = new Tacticien("Ninja", 1, 1, 2);
//
//        starterWarrior = Arrays.asList(naruto, sasuke);
//        starterTacticien = Arrays.asList(ramen, ninja);
    }

    public static NarutoStory getNARUTO() {
        return NARUTO;
    }

    @Override
    protected Object readResolve() {
        return NARUTO;
    }

    @Override
    protected List<Arc> makeStory() {
        List<Arc> arc = new ArrayList<>();
        Tacticien tacticien = new Tacticien("Piccolo-san", 10, 1, 2);

        //ARC1
        String nameArc = "Le commencement !";

        List<Character> konoha = Arrays.asList(
                new Character("Ninja Konoha 1"),
                new Character("Ninja Konoha 2"));
        List<Character> misuki = Collections.singletonList(BuilderPersoNaruto.misuki());
        List<Character> iruka = Collections.singletonList(BuilderPersoNaruto.iruka());

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

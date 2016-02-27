package fr.android.animefight.story.naruto.arc;

import fr.android.animefight.bean.team.Character;
import fr.android.animefight.bean.team.*;
import fr.android.animefight.fight.Fight;
import fr.android.animefight.story.Arc;
import fr.android.animefight.story.Story;

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
        super("Naruto");
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

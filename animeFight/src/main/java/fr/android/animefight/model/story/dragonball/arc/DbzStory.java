package fr.android.animefight.model.story.dragonball.arc;

import fr.android.animefight.bean.charac.Character;
import fr.android.animefight.bean.charac.Tacticien;
import fr.android.animefight.bean.items.Item;
import fr.android.animefight.bean.items.treasure.Treasure;
import fr.android.animefight.bean.perso.BuilderPersoDbz;
import fr.android.animefight.bean.perso.Team;
import fr.android.animefight.fight.Fight;
import fr.android.animefight.mock.MockItem;
import fr.android.animefight.model.story.Arc;
import fr.android.animefight.model.story.Story;

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
        super("Dragon Ball");

        //création des starters
        Character goku = BuilderPersoDbz.goku();
        Character krilin = BuilderPersoDbz.krilin();
        Tacticien Bulma = new Tacticien("Bulma", 5, 1, 2);
        Tacticien Chichi = new Tacticien("Chichi", 5, 1, 2);

        starterWarrior = Arrays.asList(goku, krilin);
        starterTacticien = Arrays.asList(Bulma, Chichi);
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
        List<Arc> arcs = new ArrayList<>();
        Tacticien tacticien = new Tacticien("Grand père Gohan", 2, 1, 2);

        //ARC1
        String nameArc = "Le commencement !";
        Character bulma1 = BuilderPersoDbz.bulma();
        Character ptero1 = BuilderPersoDbz.ptero();
        List<Character> bulma = Collections.singletonList(bulma1);
        List<Character> ptero = Collections.singletonList(ptero1);
        List<Item> items = new ArrayList<>();
        items.add(MockItem.orb());

        Arc arc = new Arc(nameArc,
                Arrays.asList(
                        new Fight("Qui est elle ?", new Team(bulma, tacticien), new Treasure(5,items)),
                        new Fight("Sauvons la", new Team(ptero, tacticien), new Treasure(5,items))
                ));

        arcs.add(arc);
        return arcs;
    }
}

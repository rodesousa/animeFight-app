package fr.android.animefight.story.dragonball.arc;

import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.Tacticien;
import fr.android.animefight.bean.charac.categorie.CategorieB;
import fr.android.animefight.bean.charac.categorie.CategorieSS;
import fr.android.animefight.bean.team.Formation;
import fr.android.animefight.bean.team.FormationBuilder;
import fr.android.animefight.bean.team.Team;
import fr.android.animefight.fight.Fight;
import fr.android.animefight.story.Arc;
import fr.android.animefight.story.Story;

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

        //création des starters
        Character goku = CategorieSS.init("Goku");
        Character krilin = CategorieB.init("Krilin");
        Tacticien Bulma = new Tacticien("Bulma", 5,1,2);
        Tacticien Chichi = new Tacticien("Chichi", 5,1,2);

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
        List<Arc> arc = new ArrayList<>();
        Tacticien tacticien = new Tacticien("Grand père Gohan", 2,1,2);

        //ARC1
        String nameArc = "Le commencement !";
        Formation bulma = FormationBuilder.FormationWithCharacter(CategorieB.init("Bulma"));
        Formation ptero = FormationBuilder.FormationWithCharacter(CategorieB.init("Ptero"));

        arc.add(
                new Arc(nameArc,
                        Arrays.asList(
                                new Fight("Qui est elle ?", new Team(bulma, tacticien)),
                                new Fight("Sauvons la", new Team(ptero, tacticien))
                        )));
        return arc;
    }
}

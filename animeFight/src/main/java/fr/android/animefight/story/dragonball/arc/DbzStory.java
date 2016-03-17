package fr.android.animefight.story.dragonball.arc;

import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.Tacticien;
import fr.android.animefight.bean.perso.BuilderPersoDbz;
import fr.android.animefight.bean.team.Formation;
import fr.android.animefight.bean.team.FormationBuilder;
import fr.android.animefight.bean.team.Team;
import fr.android.animefight.fight.Fight;
import fr.android.animefight.story.Arc;
import fr.android.animefight.story.Story;
import fr.android.animefight.utils.Some;

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
        List<Arc> arc = new ArrayList<>();
        Tacticien tacticien = new Tacticien("Grand père Gohan", 2, 1, 2);

        //ARC1
        String nameArc = "Le commencement !";
        Character bulma1 = BuilderPersoDbz.bulma();
        Character ptero1 = BuilderPersoDbz.ptero();
        Formation bulma = FormationBuilder.FormationWithCharacter(bulma1);
        Formation ptero = FormationBuilder.FormationWithCharacter(ptero1);

        Team team1 = new Team(bulma, tacticien);
        team1.getFormation().getListCharacters().get(0).set(0, new Some<Character>(bulma1));
        arc.add(
                new Arc(nameArc,
                        Arrays.asList(
                                new Fight("Qui est elle ?", team1),
                                new Fight("Sauvons la", new Team(ptero, tacticien))
                        )));
        return arc;
    }
}

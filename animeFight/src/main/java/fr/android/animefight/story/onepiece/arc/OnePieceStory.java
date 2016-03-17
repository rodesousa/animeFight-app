package fr.android.animefight.story.onepiece.arc;

import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.Tacticien;
import fr.android.animefight.bean.perso.BuilderPersoOnePiece;
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
 * Created by rodesousa on 20/02/16.
 */
public class OnePieceStory extends Story implements Serializable {

    private static OnePieceStory ONEPIECE = new OnePieceStory();

    private OnePieceStory() {
        super("One Piece");

        //création des starters
        Character luffy = BuilderPersoOnePiece.luffy();
        Character Baggy = BuilderPersoOnePiece.baggy();

        Tacticien nami = new Tacticien("Nami", 5, 1, 2);
        Tacticien robin = new Tacticien("Robin", 5, 1, 2);

        starterWarrior = Arrays.asList(luffy, Baggy);
        starterTacticien = Arrays.asList(nami, robin);
    }

    public static OnePieceStory getONEPIECE() {
        return ONEPIECE;
    }

    @Override
    protected Object readResolve() {
        return ONEPIECE;
    }

    @Override
    protected List<Arc> makeStory() {
        List<Arc> arc = new ArrayList<>();
        Tacticien tacticien = new Tacticien("Inconnu", 5, 1, 2);

        //ARC1
        String nameArc = "Morgan !";
        Formation first = FormationBuilder.FormationWithCharacters(Arrays.asList(
                new Character("Coby"),
                new Character("Nami")));
        Formation alvida = FormationBuilder.FormationWithCharacter(BuilderPersoOnePiece.alvida());
        Formation zorro = FormationBuilder.FormationWithCharacter(BuilderPersoOnePiece.zorro());
        Formation hermep = FormationBuilder.FormationWithCharacter(BuilderPersoOnePiece.hermep());
        Formation last = FormationBuilder.FormationWithCharacter(BuilderPersoOnePiece.morgan());

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

package fr.android.animefight.fight;

import fr.android.animefight.bean.team.Character;
import fr.android.animefight.bean.team.Team;
import fr.android.animefight.utils.Option;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rodesousa on 19/02/16.
 * C'est objet Fight qui determine ce qu'est un fight.
 * Du coup cela veut dire que tout les fights embarque la résolution de son combat, un choix judicieux si on souhaite
 * que certains combat ont d'autre règles
 */
public class Fight implements Serializable {
    private Team teamEnnemis;
    private String name;

    public Fight(Team characterList) {
        this.teamEnnemis = characterList;
    }

    public Fight(String s, Team characters) {
        this.teamEnnemis = characters;
        name = s;
    }

    @Override
    public String toString() {
        return name;
    }

    public Team getTeamEnnemis() {
        return teamEnnemis;
    }

    /**
     * todo
     * pour l'instant c'est joueur vs ennemis mais à extends pour team vs team
     * @param player
     */
    public void initFight(final Team player) {
        Team playerLocal = player;
        List<Option<Character>> teamEnnemi = teamEnnemis.getFormation().getCharacters().get(0);
        List<Option<Character>> tmp = playerLocal.getFormation().getCharacters().get(0);
        if (tmp.size() > teamEnnemi.size())
            resolveFight(playerLocal, teamEnnemis);
        else
            resolveFight(teamEnnemis, playerLocal);

    }

    private void resolveFight(final Team teamA, final Team teamB) {
        List<Option<Character>> A = teamA.getFormation().getCharacters().get(0);
        List<Option<Character>> B = teamB.getFormation().getCharacters().get(0);

        for (int i = 0; i < A.size(); i++) {
            if (!A.get(i).isEmpty) {
                if (!B.get(i).isEmpty) {
                    if (moreSpeed(A.get(i).get(), B.get(i).get())) {
                        dammage(A.get(i).get(), B.get(i).get());
                    } else {
                        dammage(B.get(i).get(), A.get(i).get());
                    }
                } else {
                    touch(teamB);
                }
            } else if (!B.get(i).isEmpty)
                touch(teamA);
        }
    }

    private void dammage(Character character, Character character1) {
        System.out.println("DAMMAGE");
    }

    private void touch(Team A) {
        System.out.println("TOUCHE");
    }

    private boolean moreSpeed(Character a, Character b) {
        return a.getVitesse() > b.getVitesse();
    }

    /**
     * pour que les combats soit moins compliquer on inverse les object pour qu'on retrouve les characteres au front
     * dès le début de la liste
     * méthode trop longue... si y'avait ce putain de map ...
     *
     * @param player
     * @return
     */
//    private Team reverse(final Team player) {
//        List<List<Option<Character>>> list = player.getFormation().getCharacters();
//        for (List<Option<Character>> options : list) {
//            Collections.reverse(options);
//        }
//        return new Team(list, player.getTacticien());
//    }
}

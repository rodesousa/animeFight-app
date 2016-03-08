package fr.android.animefight.fight;

import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.team.Formation;
import fr.android.animefight.bean.team.Team;
import fr.android.animefight.utils.None;
import fr.android.animefight.utils.Option;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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
    private Formation versus;

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

//    /**
//     * todo
//     * pour l'instant c'est joueur vs ennemis mais à extends pour team vs team
//     */
//    public void initFight(final Team b) {
//        List<List<Option<Character>>> characters = teamEnnemis.getFormation().getCharacters();
//        List<List<Option<Character>>> characters1 = b.getFormation().getCharacters();
//        versus = new ArrayList<List<Option<Character>>>();
//        if (characters.size() > characters1.size()) {
//            initList(characters, characters1);
//        } else {
//
//            initList(characters1, characters);
//        }
//    }

    public void initList(List<List<Option<Character>>> characs) {
        List<Option<Character>> options = characs.get(0);
        List<Option<Character>> options2 = teamEnnemis.getFormation().getListCharacters().get(0);
        if (options.size() > options2.size()) {
            versus = new Formation(new ArrayList<List<Option<Character>>>());
            initVersus(options, options2);
        } else {
            versus = new Formation(new ArrayList<List<Option<Character>>>());
            initVersus(options2, options);
        }
    }

    private void initVersus(List<Option<Character>> A, List<Option<Character>> B) {
        for (int i = 0; i < A.size(); i++) {
            if (!A.get(i).isEmpty) {
                if (B.size() > i && !B.get(i).isEmpty) {
                    versus.getListCharacters().add(Arrays.asList(B.get(i), A.get(i)));
                } else {
                    System.out.println(A.get(i));
                    versus.getListCharacters().add(Arrays.asList(A.get(i), new None<Character>()));
                }
            }
        }
    }

    private void resolveFight(final Team teamA, final Team teamB) {
        List<Option<Character>> A = teamA.getFormation().getListCharacters().get(0);
        List<Option<Character>> B = teamB.getFormation().getListCharacters().get(0);

        for (int i = 0; i < A.size(); i++) {
            if (!A.get(i).isEmpty) {
                if (B.size() > i && !B.get(i).isEmpty) {
                    if (moreSpeed(A.get(i).get(), B.get(i).get())) {
                        dammage(A.get(i).get(), B.get(i).get());
                    } else {
                        dammage(B.get(i).get(), A.get(i).get());
                    }
                } else {
                    touch(teamB, A.get(i).get());
                }
            } else if (!B.get(i).isEmpty)
                touch(teamA, B.get(i).get());
        }
    }

    private void dammage(Character atacker, Character defenser) {
        if (defenser.getDefense() > atacker.getAttack()) {
            defenser.setLifeCurrent(defenser.getLifeCurrent() - 1);
        } else {
            defenser.setLifeCurrent(defenser.getLifeCurrent() - (atacker.getAttack() - defenser.getDefense()));
        }
    }

    private void touch(Team A, Character b) {
        A.getTacticien().setLifeCurrent(A.getTacticien().getLifeCurrent() - 1);
    }

    private boolean moreSpeed(Character a, Character b) {
        return a.getVitesse() > b.getVitesse();
    }

    public Formation getVersus() {
        return versus;
    }

    public void setVersus(Formation versus) {
        this.versus = versus;
    }
}

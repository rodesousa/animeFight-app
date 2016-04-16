package fr.android.animefight.fight;

import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.items.Treasure;
import fr.android.animefight.bean.perso.Team;

import java.io.Serializable;

/**
 * Created by rodesousa on 19/02/16.
 * C'est objet Fight qui determine ce qu'est un fight.
 * Du coup cela veut dire que tout les fights embarque la résolution de son combat, un choix judicieux si on souhaite
 * que certains combat ont d'autre règles
 */
public class Fight implements Serializable {
    private Team teamEnnemis;
    private String name;
    private boolean state;
    private int lvl;
    private Treasure treasure;

    public Fight(String s, Team characters) {
        this.teamEnnemis = characters;
        name = s;
    }

    public Fight(String s, Team characters, Treasure t) {
        this.teamEnnemis = characters;
        name = s;
        treasure = t;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeamEnnemis() {
        return teamEnnemis;
    }

//    /***
//     * on initialise le combat en choisisant qui a la ligne la plus longue pour ne pas avoir un NoSuchElement
//     *
//     * @param team
//     */
//    public void initList(Team team) {
//        List<Character> characters1 = team.getCharacters();
//        List<Character> characters2 = teamEnnemis.getCharacters();
//        if (characters1.size() > characters2.size()) {
//            resolveFight(team, teamEnnemis);
//        } else {
//            resolveFight(teamEnnemis, team);
//        }
//    }

//    private void resolveFight(final Team teamA, final Team teamB) {
//        List<Character> A = teamA.getCharacters();
//        List<Character> B = teamB.getCharacters();
//
//        for (int i = 0; i < A.size(); i++) {
//            if (!A.get(i).isEmpty) {
//                if (B.size() > i) {
//                    if (moreSpeed(A.get(i), B.get(i))) {
//                        dammage(A.get(i)., B.get(i).);
//                    } else {
//                        dammage(B.get(i)., A.get(i).);
//                    }
//                } else {
//                    touch(teamB, A.get(i).);
//                }
//            } else if (B.size() > i)
//                touch(teamA, B.get(i));
//        }
//    }

    public void dammage(Character atacker, Character defenser) {
        if (defenser.getDefense() >= atacker.getAttack()) {
            defenser.setLifeCurrent(defenser.getLifeCurrent() - 1);
        } else {
            defenser.setLifeCurrent(defenser.getLifeCurrent() - (atacker.getAttack() - defenser.getDefense()));
        }
    }

    private void touch(Team A, Character b) {
        A.getTacticien().setLifeCurrent(A.getTacticien().getLifeCurrent() - 1);
    }

    public boolean moreSpeed(Character a, Character b) {
        return a.getVitesse() > b.getVitesse();
    }

    public boolean isState() {
        return state;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}


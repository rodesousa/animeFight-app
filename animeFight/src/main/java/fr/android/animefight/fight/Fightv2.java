//package fr.android.animefight.fight;
//
//import fr.android.animefight.bean.Character;
//import fr.android.animefight.bean.team.Team;
//import fr.android.animefight.utils.Option;
//
//import java.io.Serializable;
//import java.util.List;
//
///**
// * Created by rodesousa on 19/02/16.
// * C'est objet Fight qui determine ce qu'est un fight.
// * Du coup cela veut dire que tout les fights embarque la résolution de son combat, un choix judicieux si on souhaite
// * que certains combat ont d'autre règles
// */
//public class Fightv3 implements Serializable {
//    private Team teamEnnemis;
//    private String name;
//    private boolean state;
//
//    public Fightv2(String s, Team characters) {
//        this.teamEnnemis = characters;
//        name = s;
//    }
//
//    @Override
//    public String toString() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Team getTeamEnnemis() {
//        return teamEnnemis;
//    }
//
//    /***
//     * on initialise le combat en choisisant qui a la ligne la plus longue pour ne pas avoir un NoSuchElement
//     *
//     * @param team
//     */
//    public void initList(Team team) {
//        List<Option<Character>> options = team.getFormation().getListCharacters().get(0);
//        List<Option<Character>> options2 = teamEnnemis.getFormation().getListCharacters().get(0);
//        if (options.size() > options2.size()) {
//            resolveFight(team, teamEnnemis);
//        } else {
//            resolveFight(teamEnnemis, team);
//        }
//    }
//
//    private void resolveFight(final Team teamA, final Team teamB) {
//        List<Option<Character>> A = teamA.getFormation().getListCharacters().get(0);
//        List<Option<Character>> B = teamB.getFormation().getListCharacters().get(0);
//
//        for (int i = 0; i < A.size(); i++) {
//            if (!A.get(i).isEmpty) {
//                if (B.size() > i && !B.get(i).isEmpty) {
//                    if (moreSpeed(A.get(i).get(), B.get(i).get())) {
//                        dammage(A.get(i).get(), B.get(i).get());
//                    } else {
//                        dammage(B.get(i).get(), A.get(i).get());
//                    }
//                } else {
//                    touch(teamB, A.get(i).get());
//                }
//            } else if (B.size() > i && !B.get(i).isEmpty)
//                touch(teamA, B.get(i).get());
//        }
//    }
//
//    private void dammage(Character atacker, Character defenser) {
//        if (defenser.getDefense() > atacker.getAttack()) {
//            defenser.setLifeCurrent(defenser.getLifeCurrent() - 1);
//        } else {
//            defenser.setLifeCurrent(defenser.getLifeCurrent() - (atacker.getAttack() - defenser.getDefense()));
//        }
//    }
//
//    private void touch(Team A, Character b) {
//        A.getTacticien().setLifeCurrent(A.getTacticien().getLifeCurrent() - 1);
//    }
//
//    private boolean moreSpeed(Character a, Character b) {
//        return a.getVitesse() > b.getVitesse();
//    }
//
//    public boolean isState() {
//        return state;
//    }
//
//    public void setState(boolean state) {
//        this.state = state;
//    }
//}


package fr.android.animefight.controller.fight;

import android.os.Handler;
import fr.android.animefight.Activity.fight.SimpleFightActivity;
import fr.android.animefight.bean.charac.Character;
import fr.android.animefight.bean.inventory.CaseInventory;
import fr.android.animefight.bean.perso.Team;
import fr.android.animefight.fight.Fight;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodesousa on 15/04/16.
 */
public class ControllerFight implements Runnable {
    private int indiceListMin = 0;
    private final Handler handler = new Handler();
    private List<Character> listTeamFight;
    private Team playerTeam;
    private List<Character> listAllie;
    private int sizeListMin;
    private int state = 0;
    private int round = 1;
    private Fight fight;
    private List<Character> mover = new ArrayList<>();
    private SimpleFightActivity view;

    public ControllerFight(SimpleFightActivity view) {
        this.playerTeam = view.getModel().getPlayer().getTeam();
        this.fight = view.getFight();
        this.view = view;
        listAllie = view.getModel().getPlayer().copy();
        listTeamFight = fight.getTeamEnnemis().copy();

        if (playerTeam.getCharacters().size() > fight.getTeamEnnemis().getCharacters().size())
            sizeListMin = fight.getTeamEnnemis().getCharacters().size();
        else
            sizeListMin = playerTeam.getCharacters().size();
    }

    //state O
    private void dammageTime(Character a, Character b) {
        System.out.println("dmg");
        if (fight.moreSpeed(a, b)) {
            fight.dammage(a, b);
            moveCharacter(30, a);
            mover.add(a);
        } else {
            fight.dammage(b, a);
            moveCharacter(-30, b);
            mover.add(b);
        }
        state++;
        handler.postDelayed(this, 750);
    }

    //state 1
    private void refreshTime(Character a, Character b) {
        System.out.println("refresh");
        state = 0;
        if (!a.isAlive() || !b.isAlive()) {
            state = 2;
        }
        moveCharacter(0, mover.get(0));
        refreshCharacter(a);
        refreshCharacter(b);
        handler.postDelayed(this, 750);
    }

    //state 2
    private void nextFighterTime(Character a, Character b) {
        System.out.println("next");
        indiceListMin++;
        if (!a.isAlive())
            deleteCharacter(a, b);
        if (!b.isAlive())
            deleteCharacter(b, a);
        mover.removeAll(mover);
        state = 0;
        handler.postDelayed(this, 750);
    }

    private void nextRound() {
        System.out.println("next");
        round++;
        indiceListMin = 0;

        System.out.println("REMOVE BITCHES");
        listTeamFight = remove(listTeamFight);
        listAllie = remove(listAllie);

        System.out.println(listTeamFight.size() + "taille team");
        System.out.println(listAllie.size() + "taille allie");

        if (listTeamFight.size() > listAllie.size())
            sizeListMin = listAllie.size();
        else
            sizeListMin = listTeamFight.size();

        view.addAllCharacters(true);
        handler.postDelayed(this, 750);
    }

    @Override
    public void run() {
        if ((listAllie.size() != 0) && (listTeamFight.size() != 0) && round != 3
                && indiceListMin == sizeListMin) {
            nextRound();
            System.out.println(1);
        }
        else if (round != 3 && (listAllie.size() != 0) && (listTeamFight.size() != 0)) {
            System.out.println(2);
            System.out.println(state + "" + round + "state + round");
            Character allieMember = listAllie.get(indiceListMin);
            Character fightMember = listTeamFight.get(indiceListMin);
            if (state == 0)
                dammageTime(allieMember, fightMember);
            else if (state == 1)
                refreshTime(allieMember, fightMember);
            else
                nextFighterTime(allieMember, fightMember);
        } else {
            System.out.println(3);
            fightDone();
        }
    }

    private List<Character> remove(List<Character> characters) {
        List<Character> list = new ArrayList<>();
        for (Character character : characters) {
            System.out.println(character + " => " + character.getLifeCurrent());
            if(character.isAlive())
                list.add(character);
        }
        return  list;
    }

    private void deleteCharacter(final Character loser, final Character winner) {
        winner.setXpToShare(winner.getXpToShare() + 100);
        view.deleteCharacter(loser, winner);
    }

    private void moveCharacter(final float rotate, final Character character) {
        view.moveCharacter(rotate, character);
    }

    private void refreshCharacter(final Character character) {
        view.refreshCharacter(character);
    }

    private void fightDone() {
        int state = 1;
        if (listAllie.size() < listTeamFight.size()) {
            fight.setState(true);
            state = 0;
        } else if (listAllie.size() > listTeamFight.size()) {
            if (!fight.getTreasure().isOpenned()) {
                view.getModel().getPlayer().getInventory().getCases().add(new CaseInventory(fight.getTreasure().getItemList().get(0)));
                fight.getTreasure().setOpenned(true);
            }
        } else
            state = 2;

        for (Character character : listAllie) {
            if (character.getLifeCurrent() < 1) {
                character.setLife(1);
            }
        }
        for (Character character : listTeamFight) {
            character.setLife(character.getLife());
        }

        view.fightDone(state);
    }

    public List<Character> getListTeamFight() {
        return listTeamFight;
    }

    public List<Character> getListAllie() {
        return listAllie;
    }

    public void setListAllie(List<Character> listAllie) {
        this.listAllie = listAllie;
    }

    public Handler getHandler() {
        return handler;
    }
}

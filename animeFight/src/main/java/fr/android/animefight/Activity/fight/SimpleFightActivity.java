package fr.android.animefight.Activity.fight;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import fr.android.animefight.Activity.tools.Duo;
import fr.android.animefight.R;
import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.Tacticien;
import fr.android.animefight.bean.perso.Team;
import fr.android.animefight.controller.fight.ControllerFight;
import fr.android.animefight.fight.Fight;
import fr.android.animefight.model.Model;

import java.util.HashMap;
import java.util.List;

/**
 * Created by rodesousa on 06/04/16.
 */
public class SimpleFightActivity extends Activity {

    private Fight fight;
    private Team playerTeam;
    private HashMap<Character, Duo> listBattleView;
    private HashMap<Character, Duo> listTacticienView;
    private Model model;
    private ControllerFight resolveFight;

    public void fightDone(int state) {
        Button viewById = (Button) this.findViewById(R.id.finalState);
        viewById.setEnabled(true);
        viewById.setTextColor(Color.RED);
        viewById.requestLayout();

        if (state == 0)
            viewById.setText("YOU \n LOOSE");
        else if (state == 1)
            viewById.setText("YOU \n WIN");
        else
            viewById.setText("DRAW");
    }

    public void refreshCharacter(final Character character) {
        Duo duo = listBattleView.get(character);
        TextView tx = (TextView) duo.getViewGroup().findViewById(duo.getIndice());
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) tx.getLayoutParams();
        layoutParams.setMargins(10, 0, 50, 30);
        tx.setText(character.toString() + "\n" +
                character.getLifeCurrent() + "/" + character.getLife());
        duo.getViewGroup().requestLayout();
    }

    public void moveCharacter(final float rotate, final Character character) {
        Duo duo = listBattleView.get(character);
        TextView viewById = (TextView) duo.getViewGroup().findViewById(duo.getIndice());
        viewById.setRotation(rotate);
        duo.getViewGroup().requestLayout();
    }

    public void deleteCharacter(final Character loser, final Character winner) {
        Duo duo = listBattleView.get(loser);
        TextView viewById = (TextView) duo.getViewGroup().findViewById(duo.getIndice());
        viewById.setBackgroundColor(Color.BLACK);
        duo.getViewGroup().requestLayout();
    }

    public void goToArcActiviy(final View view) {
        Intent intent = new Intent(this, ChooseFightsActivity.class);
        intent.putExtra("ArcId", (int) getIntent().getSerializableExtra("ArcId"));
        intent.putExtra("Model", model);
        finish();
        startActivity(intent);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight);
        listBattleView = new HashMap<>();
        listTacticienView = new HashMap<>();

        model = (Model) getIntent().getSerializableExtra("Model");
        fight = model.getModeStory().getStory().getArcList().get((int) getIntent().getSerializableExtra("ArcId")).
                getFightList().get((int) getIntent().getSerializableExtra("FightId"));
        playerTeam = model.getPlayer().getTeam();

        resolveFight = new ControllerFight(this);

        addAllCharacters(false);

        resolveFight.getHandler().postDelayed(resolveFight, 2000);
    }

    public void addAllCharacters(boolean remove) {
        TableLayout layoutTeam = (TableLayout) findViewById(R.id.team);
        TableLayout layoutEnnemis = (TableLayout) findViewById(R.id.ennemi);
        LinearLayout layoutTacticienTeam = (LinearLayout) findViewById(R.id.tacticienTeam);
        LinearLayout layoutTacticienEnnemis = (LinearLayout) findViewById(R.id.tacticiEnennemi);


        if (remove) {
            removeAndAdd(layoutTeam, resolveFight.getListAllie(), 100);
            removeAndAdd(layoutEnnemis, resolveFight.getListTeamFight(), 200);
        } else {
            addTacticien(layoutTacticienTeam, playerTeam.getTacticien(), 0);
            addTacticien(layoutTacticienEnnemis, fight.getTeamEnnemis().getTacticien(), 10);
            addCharacters(layoutTeam, resolveFight.getListAllie(), 100);
            addCharacters(layoutEnnemis, resolveFight.getListTeamFight(), 200);
        }
    }

    private void addTacticien(final LinearLayout layout, Tacticien tacticien, int i) {
        TextView tx = new TextView(this);
        tx.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        tx.setText(tacticien.toString() + "\n" + tacticien.getLifeCurrent() + "/" + tacticien.getLife());
        tx.setBackgroundColor(Color.GREEN);
        ViewGroup.MarginLayoutParams test = (ViewGroup.MarginLayoutParams) tx.getLayoutParams();
        test.setMargins(10, 0, 50, 30);
        tx.setId(i);
        listTacticienView.put(tacticien, new Duo(layout, i));
        layout.addView(tx);
    }

    private void removeAndAdd(final TableLayout layout, final List<Character> characters, final int indice) {
        layout.removeAllViews();
        addCharacters(layout, characters, indice);
        layout.requestLayout();
    }

    private void addCharacters(final TableLayout layout, final List<Character> characters, final int indice) {
        TableRow tableRow = new TableRow(this);
        tableRow.setId(indice + 3112);
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.MATCH_PARENT);
        tableRow.setLayoutParams(layoutParams);
        int i = indice;
        for (Character character : characters) {
            TextView tx = new TextView(this);
            tx.setLayoutParams(layoutParams);
            tx.setText(character.toString() + "\n" +
                    character.getLifeCurrent() + "/" + character.getLife());
            tx.setBackgroundColor(Color.RED);
            tx.setId(i);
            listBattleView.put(character, new Duo(layout, i));
            i++;
            ViewGroup.MarginLayoutParams test = (ViewGroup.MarginLayoutParams) tx.getLayoutParams();
            test.setMargins(10, 0, 50, 30);
            tableRow.addView(tx);
        }
        layout.addView(tableRow);
    }

    public Fight getFight() {
        return fight;
    }

    public Model getModel() {
        return model;
    }
}
package fr.android.animefight.Activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import fr.android.animefight.R;
import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.Tacticien;
import fr.android.animefight.bean.team.Team;
import fr.android.animefight.fight.Fight;
import fr.android.animefight.utils.Option;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity des combats. On recupère l'objet Formation pour le print sur la view
 * Created by rodesousa on 16/02/16.
 */
public class FightActivity extends Activity {
    private Fight fight;
    private Team team;
    private LinearLayout layoutTeam;
    private LinearLayout layoutEnnemis;
    private LinearLayout layoutTacticienTeam;
    private LinearLayout layoutTacticienEnnemis;
    private Handler handler;
    private List<View> views;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            fight.initFight(team);
            addAll();
            handler.postDelayed(runnable, 5000);
        }
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight);
        fight = (Fight) getIntent().getSerializableExtra("Fight");
        team = (Team) getIntent().getSerializableExtra("Team");
        layoutTeam = (LinearLayout) findViewById(R.id.team);
        layoutEnnemis = (LinearLayout) findViewById(R.id.ennemi);
        layoutTacticienTeam = (LinearLayout) findViewById(R.id.tacticienTeam);
        layoutTacticienEnnemis = (LinearLayout) findViewById(R.id.tacticiEnennemi);
        views = new ArrayList<>();
        addAll();
        this.handler = new Handler();
        handler.postDelayed(runnable, 5000);
    }

    public void addAll() {
        layoutEnnemis.removeAllViews();
        layoutTacticienEnnemis.removeAllViews();
        layoutTacticienTeam.removeAllViews();
        layoutTeam.removeAllViews();

        addTacticien(layoutTacticienEnnemis, fight.getTeamEnnemis().getTacticien(), 10);
        addTacticien(layoutTacticienTeam, team.getTacticien(), 11);
        addButton(layoutTeam, team.getFormation().getCharacters());
        addButton(layoutEnnemis, fight.getTeamEnnemis().getFormation().getCharacters());
    }

    private void addTacticien(final LinearLayout layout, Tacticien tacticien, int id) {
        TextView tx = new TextView(this);
        tx.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        tx.setText(tacticien.toString() + " : " + tacticien.getLifeCurrent() + "/" + tacticien.getLife());
        tx.setBackgroundColor(Color.GREEN);
        ViewGroup.MarginLayoutParams test = (ViewGroup.MarginLayoutParams) tx.getLayoutParams();
        test.setMargins(0, 0, 50, 0);
        layout.addView(tx);
        views.add(tx);
    }

    private void addButton(final LinearLayout layout, final List<List<Option<Character>>> ch) {
        for (List<Option<Character>> options : ch) {
            for (Option<Character> option : options) {
                TextView tx = new TextView(this);
                tx.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
                if (!option.isEmpty) {
                    tx.setText(option.get().toString() + "\n" +
                            option.get().getLifeCurrent() + "/" + option.get().getLife());
                    tx.setBackgroundColor(Color.RED);
                } else {
                    tx.setText("        ");
                    tx.setBackgroundColor(Color.BLUE);
                }
                ViewGroup.MarginLayoutParams test = (ViewGroup.MarginLayoutParams) tx.getLayoutParams();
                test.setMargins(0, 0, 50, 0);
                layout.addView(tx);
                views.add(tx);
            }
        }
    }

    public Fight getFight() {
        return fight;
    }

    public void setFight(Fight fight) {
        this.fight = fight;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public LinearLayout getLayoutTeam() {
        return layoutTeam;
    }

    public void setLayoutTeam(LinearLayout layoutTeam) {
        this.layoutTeam = layoutTeam;
    }

    public LinearLayout getLayoutEnnemis() {
        return layoutEnnemis;
    }

    public void setLayoutEnnemis(LinearLayout layoutEnnemis) {
        this.layoutEnnemis = layoutEnnemis;
    }

    public LinearLayout getLayoutTacticienTeam() {
        return layoutTacticienTeam;
    }

    public void setLayoutTacticienTeam(LinearLayout layoutTacticienTeam) {
        this.layoutTacticienTeam = layoutTacticienTeam;
    }

    public LinearLayout getLayoutTacticienEnnemis() {
        return layoutTacticienEnnemis;
    }

    public void setLayoutTacticienEnnemis(LinearLayout layoutTacticienEnnemis) {
        this.layoutTacticienEnnemis = layoutTacticienEnnemis;
    }
}


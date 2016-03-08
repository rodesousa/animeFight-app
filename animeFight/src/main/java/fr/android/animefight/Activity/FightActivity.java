package fr.android.animefight.Activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import fr.android.animefight.R;
import fr.android.animefight.bean.Character;
import fr.android.animefight.bean.Tacticien;
import fr.android.animefight.bean.team.Team;
import fr.android.animefight.fight.Fight;
import fr.android.animefight.utils.Option;

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
    private int state = 0;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (state == 0) {
                moveView(20);
                state = 1;
                handler.postDelayed(runnable, 750);
            } else if (state == 1) {
                moveView(-20);
                state = 2;
                handler.postDelayed(runnable, 750);
            } else if (state == 2) {
            } else {
                if (fightIsDone()) {
                    handler.postDelayed(runnable, 2000);
                }
            }
        }
    };

    private void moveView(int modif) {
        System.out.println(fight.getVersus().getListCharacters().size());
        for (Option<Character> characterOption : fight.getVersus().flat()) {
            if (!characterOption.isEmpty) {
                System.out.println(characterOption.get().toString());
                TextView viewById = null;
                try {
                    viewById = (TextView) this.layoutTeam.findViewById(characterOption.get().getId());
                } catch (NullPointerException e) {
                    try {
                        viewById = (TextView) this.layoutEnnemis.findViewById(characterOption.get().getId());
                    } catch (NullPointerException ee) {
                    }
                }
                if (viewById != null) {
                    ViewGroup.MarginLayoutParams test = (ViewGroup.MarginLayoutParams) viewById.getLayoutParams();
                    System.out.println(viewById.getLayoutParams());
                    viewById.setBackgroundColor(Color.YELLOW);
                    test.topMargin += modif;
                    viewById.requestLayout();
                    System.out.println("MARCHE");
                } else {
                    System.out.println("PAS MARCHE");
                }
            }
        }
    }

    private boolean fightIsDone() {
        return team.getTacticien().getLifeCurrent() <= 0 ||
                fight.getTeamEnnemis().getTacticien().getLifeCurrent() <= 0;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight);

        fight = (Fight) getIntent().getSerializableExtra("Fight");
        team = (Team) getIntent().getSerializableExtra("Team");

        layoutTeam = (LinearLayout) findViewById(R.id.team);
        layoutEnnemis = (LinearLayout) findViewById(R.id.ennemi);
        layoutTacticienTeam = (LinearLayout) findViewById(R.id.tacticienTeam);
        layoutTacticienEnnemis = (LinearLayout) findViewById(R.id.tacticiEnennemi);

        addAll();

        fight.initList(team.getFormation().getListCharacters());

        this.handler = new Handler();
        handler.postDelayed(runnable, 2000);
    }

    private void addAll() {
        layoutEnnemis.removeAllViews();
        layoutTacticienEnnemis.removeAllViews();
        layoutTacticienTeam.removeAllViews();
        layoutTeam.removeAllViews();

        int teamA = 100;
        int teamB = 200;
        addTacticien(layoutTacticienEnnemis, team.getTacticien(), 0);
        addTacticien(layoutTacticienTeam, fight.getTeamEnnemis().getTacticien(), 0);
        addButton(layoutTeam, team.getFormation().getListCharacters(), teamA);
        addButton(layoutEnnemis, fight.getTeamEnnemis().getFormation().getListCharacters(), teamB);
    }

    private void addTacticien(final LinearLayout layout, Tacticien tacticien, int i) {
        TextView tx = new TextView(this);
        tx.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        tx.setText(tacticien.toString() + " : " + tacticien.getLifeCurrent() + "/" + tacticien.getLife());
        tx.setBackgroundColor(Color.GREEN);
        ViewGroup.MarginLayoutParams test = (ViewGroup.MarginLayoutParams) tx.getLayoutParams();
        test.setMargins(0, 0, 50, 0);
        layout.addView(tx);
    }

    private void addButton(final LinearLayout layout, final List<List<Option<Character>>> ch, int teamB) {
        int i = teamB;
        for (List<Option<Character>> options : ch) {
            for (Option<Character> option : options) {
                TextView tx = new TextView(this);
                tx.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
                if (!option.isEmpty) {
                    tx.setText(option.get().toString() + "\n" +
                            option.get().getLifeCurrent() + "/" + option.get().getLife());
                    tx.setBackgroundColor(Color.RED);
                    option.get().setId(i);
                } else {
                    tx.setText("        ");
                    tx.setBackgroundColor(Color.BLUE);
                }
                ViewGroup.MarginLayoutParams test = (ViewGroup.MarginLayoutParams) tx.getLayoutParams();
                test.setMargins(0, 0, 50, 0);
                tx.setId(i);
                layout.addView(tx);
            }
            i++;
        }
    }
}

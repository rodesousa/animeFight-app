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

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Activity des combats. On recupère l'objet Formation pour le print sur la view
 * Created by rodesousa on 16/02/16.
 */
public class FightActivity extends Activity {
    public class Duo implements Serializable {
        ViewGroup viewGroup;
        Character character;

        public Duo(ViewGroup viewGroup, Character character) {
            this.viewGroup = viewGroup;
            this.character = character;
        }
    }

    private Fight fight;
    private Team team;
    private Handler handler;
    private int state = 0;
    private HashMap<Integer, Duo> listBattleView;
    private HashMap<Integer, Duo> listTacticienView;
    private Runnable runnable = new Runnable() {

        @Override
        public void run() {
            if (state == 0) {
                state = 1;
                moveView(30, listBattleView);
                handler.postDelayed(runnable, 750);
            } else if (state == 1) {
                state = 2;
                moveView(-30, listBattleView);
                handler.postDelayed(runnable, 100);
            } else if (state == 2) {
                fight.initList(team);
                refreshAll(listBattleView);
                refreshAll(listTacticienView);
                state = 0;
                if (!fightIsDone()) {
                    handler.postDelayed(runnable, 750);
                }
            }
        }
    };

    private void moveView(int i, HashMap<Integer, Duo> hash) {
        Set<Integer> integers = hash.keySet();
        for (Integer integer : integers) {
            Duo duo = hash.get(integer);
            TextView viewById = (TextView) duo.viewGroup.findViewById(integer);
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) viewById.getLayoutParams();
            layoutParams.setMargins(0, 0, 50, 0);
            layoutParams.topMargin += i;
            duo.viewGroup.requestLayout();
        }
    }

    private void refreshAll(HashMap<Integer, Duo> hash) {
        Set<Integer> integers = hash.keySet();
        for (Integer integer : integers) {
            Duo duo = hash.get(integer);
            TextView tx = (TextView) duo.viewGroup.findViewById(integer);
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) tx.getLayoutParams();
            layoutParams.setMargins(0, 0, 50, 0);
            tx.setText(duo.character.toString() + "\n" +
                    duo.character.getLifeCurrent() + "/" + duo.character.getLife());
        }
    }

    private boolean fightIsDone() {
        return team.getTacticien().getLifeCurrent() <= 0 ||
                fight.getTeamEnnemis().getTacticien().getLifeCurrent() <= 0;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight);
        listBattleView = new HashMap<>();
        listTacticienView = new HashMap<>();

        fight = (Fight) getIntent().getSerializableExtra("Fight");
        team = (Team) getIntent().getSerializableExtra("Team");

        LinearLayout layoutTeam = (LinearLayout) findViewById(R.id.team);
        LinearLayout layoutEnnemis = (LinearLayout) findViewById(R.id.ennemi);
        LinearLayout layoutTacticienTeam = (LinearLayout) findViewById(R.id.tacticienTeam);
        LinearLayout layoutTacticienEnnemis = (LinearLayout) findViewById(R.id.tacticiEnennemi);


        addTacticien(layoutTacticienTeam, team.getTacticien(), 0);
        addTacticien(layoutTacticienEnnemis, fight.getTeamEnnemis().getTacticien(), 10);
        addButton(layoutTeam, team.getFormation().getListCharacters(), 100);
        addButton(layoutEnnemis, fight.getTeamEnnemis().getFormation().getListCharacters(), 200);

        fight.initList(team);

        this.handler = new Handler();
        handler.postDelayed(runnable, 2000);
    }

    private void addTacticien(final LinearLayout layout, Tacticien tacticien, int i) {
        TextView tx = new TextView(this);
        tx.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        tx.setText(tacticien.toString() + "\n" + tacticien.getLifeCurrent() + "/" + tacticien.getLife());
        tx.setBackgroundColor(Color.GREEN);
        ViewGroup.MarginLayoutParams test = (ViewGroup.MarginLayoutParams) tx.getLayoutParams();
        test.setMargins(0, 0, 50, 0);
        tx.setId(i);
        listTacticienView.put(i, new Duo(layout, tacticien));
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
                    tx.setId(i);
                    listBattleView.put(i, new Duo(layout, option.get()));
                    i++;
                } else {
                    tx.setText("        ");
                    tx.setBackgroundColor(Color.BLUE);
                }
                ViewGroup.MarginLayoutParams test = (ViewGroup.MarginLayoutParams) tx.getLayoutParams();
                test.setMargins(0, 0, 50, 0);
                layout.addView(tx);
            }
        }
    }
}

package fr.android.animefight.Activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import fr.android.animefight.R;
import fr.android.animefight.bean.team.Character;
import fr.android.animefight.model.Model;
import fr.android.animefight.utils.Option;

import java.util.List;

/**
 * Activity des combats. On recupère l'objet Formation pour le print sur la view
 * Created by rodesousa on 16/02/16.
 */
public class FightActivity extends Activity {

    private Model model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight);

        model = (Model) getIntent().getSerializableExtra("Model");
        int indice = (int) getIntent().getSerializableExtra("ArcId");
        int indiceFight = (int) getIntent().getSerializableExtra("FigtId");

        LinearLayout layoutTeam = (LinearLayout) findViewById(R.id.test);
        LinearLayout layoutEnnemis = (LinearLayout) findViewById(R.id.ennemi);

        addButton(layoutTeam, model.getTeam().getFormation().getCharacters());
        addButton(layoutEnnemis, model.getWorld().getStory().getArcList().get(indice).getFightList().get(indiceFight).
                getTeamEnnemis().getFormation().getCharacters());
    }

    private void addButton(final LinearLayout layout, final List<List<Option<Character>>> ch) {
        for (List<Option<Character>> options : ch) {
            for (Option<Character> option : options) {
                TextView tx = new TextView(this);
                tx.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
                if (!option.isEmpty) {
                    tx.setText(option.get().toString());
                    tx.setBackgroundColor(Color.RED);
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

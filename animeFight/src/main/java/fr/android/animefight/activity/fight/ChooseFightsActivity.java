package fr.android.animefight.activity.fight;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import fr.android.animefight.R;
import fr.android.animefight.fight.Fight;
import fr.android.animefight.model.Model;
import fr.android.animefight.model.story.Arc;

import java.util.List;

/**
 * C'est l'activity des différents arc. On voit l'ensemble des combats d'un arc !
 * Created by rodesousa on 15/02/16.
 */
public class ChooseFightsActivity extends Activity {

    private Model model;
    private Arc arc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_arc);

        model = (Model) getIntent().getSerializableExtra("Model");
        arc = model.getModeStory().getStory().getArcList().get((int) getIntent().getSerializableExtra("ArcId"));

        //Recup le textView pour y mettre le Titre de la story
        TextView tv = (TextView) findViewById(R.id.titre);
        tv.setTextSize(20);
        tv.setTextColor(Color.RED);
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        tv.setText("Arc : \n" + arc);

        //add buttons
        addButtons(arc.getFightList());
    }

    private void arcActivity(final View view) {
        if (model.getPlayer().getTeam().isFightable()) {
            Intent intent = new Intent(this, SimpleFightActivity.class);
            intent.putExtra("FightId", view.getId());
            intent.putExtra("ArcId", (int) getIntent().getSerializableExtra("ArcId"));
            intent.putExtra("Model", model);
            this.finish();
            startActivity(intent);
        }
    }

    /**
     * Ajout des button dynamiquement
     */
    private void addButtons(List<Fight> arcOrStory) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.story_arc);
        int i = 0;
        boolean enable = false;
        for (Fight arc : arcOrStory) {
            Button button = new Button(this);
            if (enable) {
                button.setEnabled(false);
            }
            if (!arc.isState()) {
                System.out.println(arc);
                System.out.println(arc.isState());
                enable = true;
            }
            button.setText(arc.toString());
            button.setId(i);
            button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams) button.getLayoutParams();
            margin.setMargins(70, 0, 70, 0);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    arcActivity(view);
                }
            });
            layout.addView(button);
            i++;
        }
    }


}

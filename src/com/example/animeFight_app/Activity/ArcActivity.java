package com.example.animeFight_app.Activity;

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
import com.example.animeFight_app.R;
import com.example.animeFight_app.fight.Fight;
import com.example.animeFight_app.model.Model;

import java.util.List;

/**
 * C'est l'activity des différents arc. On voit l'ensemble des combats d'un arc !
 * Created by rodesousa on 15/02/16.
 */
public class ArcActivity extends Activity {

    private Model model;
    private int indiceArc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_arc);

        model = (Model) getIntent().getSerializableExtra("Model");
        indiceArc = (int) getIntent().getSerializableExtra("ArcId");

        //Recup le textView pour y mettre le Titre de la story
        TextView tv = (TextView) findViewById(R.id.titre);
        tv.setTextSize(20);
        tv.setTextColor(Color.RED);
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        tv.setText("Arc : \n" + model.getWorld().getStory().getArcList().get(indiceArc).toString());

        //add buttons
        addButtons(model.getWorld().getStory().getArcList().get(indiceArc).getFightList());
    }

    private void arcActivity(final View view) {
        Intent intent = new Intent(this, FightActivity.class);
        intent.putExtra("FigtId", view.getId());
        intent.putExtra("Model", model);
        intent.putExtra("ArcId", indiceArc);
        startActivity(intent);
    }

    /**
     * Ajout des button dynamiquement
     */
    private void addButtons(List<Fight> arcOrStory) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.story_arc);
        int i = 0;
        for (Object arc : arcOrStory) {
            Button button = new Button(this);
            button.setText(arc.toString());
            button.setId(i);
            button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams) button.getLayoutParams();
            margin.setMargins(70, 0, 70, 0);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(final View v) {
                    arcActivity(v);
                }
            });
            layout.addView(button);
            i++;
        }
    }

}

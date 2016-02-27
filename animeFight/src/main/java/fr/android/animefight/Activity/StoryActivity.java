package fr.android.animefight.Activity;

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
import fr.android.animefight.model.Model;
import fr.android.animefight.story.Arc;

import java.util.List;

/**
 * Activity du mode story. On a l'ensemble des arcs d'une story
 * Created by rodesousa on 15/02/16.
 */
public class StoryActivity extends Activity {

    private Model model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_arc);
        model = (Model) getIntent().getSerializableExtra("Model");

        //Recup le textView pour y mettre le Titre de la story
        TextView tv = (TextView) findViewById(R.id.titre);
        tv.setTextSize(20);
        tv.setTextColor(Color.RED);
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        tv.setText("Bienvenue dans le monde de \n" + model.getWorld().getStory().toString());

        //add buttons
        addButtons(model.getWorld().getStory().getArcList());
    }

    private void storyActivity(View view) {
        Intent intent = new Intent(this, ArcActivity.class);
        model.getState().setStep(model.getState().ARCS);
        intent.putExtra("Model", model);
        intent.putExtra("ArcId", view.getId());
        startActivity(intent);
    }

    /**
     * Ajout des button dynamiquement
     */
    private void addButtons(List<Arc> arcOrStory) {
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
                    storyActivity(v);
                }
            });
            layout.addView(button);
            i++;
        }
    }

}

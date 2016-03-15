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
 * ensemble des arcs d'une story
 *
 * Created by rodesousa on 15/02/16.
 */
public class ArcsActivity extends Activity {

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
        tv.setText("Bienvenue dans le monde de \n" + model.getModeStory().getStory().toString());

        //add buttons
        addButtons(model.getModeStory().getStory().getArcList());
    }

    private void storyActivity(View view) {
        Intent intent = new Intent(this, FightsActivity.class);
        intent.putExtra("Model", model);
        intent.putExtra("ArcId", view.getId());
        startActivity(intent);
    }

    /**
     * Ajout des arcs
     */
    private void addButtons(List<Arc> arcs) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.story_arc);
        int i = 0;
        boolean enable = false;
        for (Arc arc : arcs) {
            Button button = new Button(this);
            if (enable) {
                button.setEnabled(false);
            }
            if (!arc.isState()) {
                enable = true;
            }
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

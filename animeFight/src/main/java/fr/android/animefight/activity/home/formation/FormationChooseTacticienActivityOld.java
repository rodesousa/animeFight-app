package fr.android.animefight.activity.home.formation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import fr.android.animefight.R;
import fr.android.animefight.bean.charac.Tacticien;
import fr.android.animefight.model.Model;

/**
 * Created by rodesousa on 18/03/16.
 */
public class FormationChooseTacticienActivityOld extends Activity {
    private Model model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosefighter);

        model = (Model) getIntent().getSerializableExtra("Model");

        LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.chooseFighter);

        int i = 0;
        for (Tacticien tacticien : model.getPlayer().getTacticiens()) {
            Button button = new Button(this);
            if (model.getPlayer().fintTacticien(tacticien)) {
                button.setEnabled(false);
            }
            button.setText("" + tacticien);
            button.setId(i);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(final View v) {
                    selectCharcter(v);
                }
            });
            linearLayout.addView(button);
            i++;
        }

        Button back = new Button(this);
        back.setText("back");
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                backFormation(v);
            }
        });
        linearLayout.addView(back);
    }

    private void backFormation(View view) {
        Intent intent = new Intent(this, FormationActivity.class);
        intent.putExtra("Model", model);
        this.finish();
        startActivity(intent);
    }

    private void selectCharcter(View view) {
        Intent intent = new Intent(this, FormationActivity.class);
        intent.putExtra("Model", model);
        intent.putExtra("indiceTacticien", view.getId());
        this.finish();
        startActivity(intent);
    }
}

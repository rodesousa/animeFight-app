package com.example.animeFight_app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.animeFight_app.R;
import com.example.animeFight_app.bean.team.Character;
import com.example.animeFight_app.model.Model;

import java.util.List;

/**
 * Created by rodesousa on 16/02/16.
 */
public class FightActivity extends Activity {

    private Model model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight);
        Intent intent = getIntent();

        model = (Model) getIntent().getSerializableExtra("Model");
        int indice = (int) getIntent().getSerializableExtra("ArcId");
        int indiceFight = (int) getIntent().getSerializableExtra("FigtId");

        System.out.println("indiceFight");
        System.out.println(indiceFight);
        System.out.println("indice");
        System.out.println(indice);
        LinearLayout layoutTeam = (LinearLayout) findViewById(R.id.test);
        LinearLayout layoutEnnemis = (LinearLayout) findViewById(R.id.ennemi);

        addButton(layoutTeam, model.getTeam().getCharacters());
        addButton(layoutEnnemis, model.getWorld().getStory().getArcList().get(indice).getFightList().get(indiceFight).getEnnemiList());
    }

    private void addButton(final LinearLayout layout, final List<Character> ch) {

        for (Character charac : ch) {
            TextView tx = new TextView(this);
            tx.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
            tx.setBackgroundColor(Color.parseColor("#0099cc"));
            tx.setText(charac.getName());
            ViewGroup.MarginLayoutParams test = (ViewGroup.MarginLayoutParams) tx.getLayoutParams();
            test.setMargins(0, 0, 50, 0);
            layout.addView(tx);
        }
    }

}

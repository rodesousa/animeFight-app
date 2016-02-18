package com.example.animeFight_app.Activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.animeFight_app.R;
import com.example.animeFight_app.bean.team.Character;
import com.example.animeFight_app.model.Model;

/**
 * Created by rodesousa on 16/02/16.
 */
public class FightActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight);

        Model model = (Model) getIntent().getSerializableExtra("Model");

        LinearLayout layout = (LinearLayout) findViewById(R.id.test);

        for (Character charac : model.getTeam().getCharacters()
                ) {
            TextView tx = new TextView(this);
            tx.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
            tx.setBackgroundColor(Color.parseColor("#0099cc"));
            tx.setText(charac.getName());
            ViewGroup.MarginLayoutParams test = (ViewGroup.MarginLayoutParams) tx.getLayoutParams();
            test.setMargins(0, 0, 50, 0);
            layout.addView(tx);
        }

    }

    public void returnFightToStory(View view) {
        this.finish();
    }
}

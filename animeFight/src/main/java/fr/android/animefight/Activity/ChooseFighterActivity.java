package fr.android.animefight.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import fr.android.animefight.R;
import fr.android.animefight.bean.Character;
import fr.android.animefight.model.Model;

/**
 * Created by rodesousa on 15/03/16.
 */
public class ChooseFighterActivity extends Activity {

    private Model model;
    private int indice;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosefighter);

        model = (Model) getIntent().getSerializableExtra("Model");
        indice = (int) getIntent().getSerializableExtra("placeId");

        LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.chooseFighter);

        int i = 0;
        for (Character character : model.getPlayer().getCharacters()) {
            Button button = new Button(this);
            button.setText("" + character);
            button.setId(i);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(final View v) {
                    selectCharcter(v);
                }
            });
            linearLayout.addView(button);
            i++;
        }

    }

    private void selectCharcter(View view) {
        Intent intent = new Intent(this, FormationActivity.class);
        intent.putExtra("Model", model);
        intent.putExtra("placeId", indice);
        intent.putExtra("characterId", view.getId());
        this.finish();
        startActivity(intent);
    }
}

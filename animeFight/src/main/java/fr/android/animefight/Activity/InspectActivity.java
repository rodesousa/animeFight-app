package fr.android.animefight.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import fr.android.animefight.R;
import fr.android.animefight.bean.charac.Character;
import fr.android.animefight.model.Model;

/**
 * Liste des personnages qui permet de voir en detail un personnage
 * Created by rodesousa on 16/03/16.
 */
public class InspectActivity extends Activity {
    private Model model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inspect);

        model = (Model) getIntent().getSerializableExtra("Model");

        LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.inspect);
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
        Intent intent = new Intent(this, InspectCharacterActivity.class);
        intent.putExtra("Model", model);
        intent.putExtra("characterId", view.getId());
        this.finish();
        startActivity(intent);
    }
}

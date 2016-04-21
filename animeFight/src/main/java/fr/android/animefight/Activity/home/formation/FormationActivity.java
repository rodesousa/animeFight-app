package fr.android.animefight.Activity.home.formation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import fr.android.animefight.Activity.home.CoreActivity;
import fr.android.animefight.R;
import fr.android.animefight.bean.charac.Character;
import fr.android.animefight.bean.charac.Tacticien;
import fr.android.animefight.model.Model;

import java.util.List;

/**
 * Created by rodesousa on 09/04/16.
 */
public class FormationActivity extends Activity {
    private Model model;
    private List<Character> characters;
    private Tacticien tacticien;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formation);

        model = (Model) getIntent().getSerializableExtra("Model");
        characters = model.getPlayer().getTeam().getCharacters();
        tacticien = model.getPlayer().getTeam().getTacticien();

        TableLayout tableLayout = (TableLayout) findViewById(R.id.formationTeam);
        TableRow tableRow = new TableRow(this);
        tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.MATCH_PARENT));

        // print tacticien
        Button formationTacticien = (Button) findViewById(R.id.formationTacticien);
        formationTacticien.setText("Tacticien:  " + model.getPlayer().getTeam().getTacticien());

        for (int i = 0; i < tacticien.getSizeCharacters(); i++) {
            Button button = new Button(this);
            button.setId(i);
            if (characters.size() > i)
                button.setText(characters.get(i).toString());
            if (characters.size() < i)
                button.setEnabled(false);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(final View v) {
                    chooseCharacter(v);
                }
            });
            tableRow.addView(button);
        }
        tableLayout.addView(tableRow);
    }

    private void chooseCharacter(View view) {
        Intent intent = new Intent(this, FormationChooseCharacterActivity.class);
        intent.putExtra("Model", model);
        intent.putExtra("IdSlot", view.getId());
        intent.putExtra("Type", "Character");
        this.finish();
        startActivity(intent);
    }

    public void chooseTacticien(View view) {
        Intent intent = new Intent(this, FormationChooseCharacterActivity.class);
        intent.putExtra("Model", model);
        intent.putExtra("IdSlot", view.getId());
        intent.putExtra("Type", "Tacticien");
        this.finish();
        startActivity(intent);
    }

    public void validate(View view) {
        Intent intent = new Intent(this, CoreActivity.class);
        intent.putExtra("Model", model);
        this.finish();
        startActivity(intent);
    }

}

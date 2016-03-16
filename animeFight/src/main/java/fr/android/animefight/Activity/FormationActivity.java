package fr.android.animefight.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import fr.android.animefight.R;
import fr.android.animefight.bean.Character;
import fr.android.animefight.model.Model;
import fr.android.animefight.utils.None;
import fr.android.animefight.utils.Option;
import fr.android.animefight.utils.Some;

import java.util.Collections;
import java.util.List;

/**
 * Created by rodesousa on 15/03/16.
 */
public class FormationActivity extends Activity {

    private Model model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formation);

        int placeId = -999;
        int characterId = -999;
        int removeId = -999;

        model = (Model) getIntent().getSerializableExtra("Model");
        try {
            placeId = (int) getIntent().getSerializableExtra("placeId");
            characterId = (int) getIntent().getSerializableExtra("characterId");
        } catch (NullPointerException e) {
            try {
                removeId = (int) getIntent().getSerializableExtra("removeId");
            } catch (NullPointerException ee) {
            }
        }

        // print tacticien
        TextView formationTacticien = (TextView) findViewById(R.id.formationTacticien);
        formationTacticien.setText("Tacticien:  " + model.getPlayer().getTeam().getTacticien());

        //print formation
        TableLayout tableLayout = (TableLayout) findViewById(R.id.formationTeam);

        List<List<Option<Character>>> listCharacters = model.getPlayer().getTeam().getFormation().getListCharacters();

        // on reverse le tableau !
        Collections.reverse(listCharacters);

        int idi = 0;
        int idj = 0;
        for (List<Option<Character>> characters : listCharacters) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));
            for (Option<Character> character : characters) {
                Button button = new Button(this);
                button.setId(idi + idj);
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(final View v) {
                        chooseCharacter(v);
                    }
                });
                if (!character.isEmpty) {
                    if (removeId == 999) {
                        button.setText("    ");
                        characters.set(idi, new None<Character>());
                    } else {
                        button.setText(character.get() + "");
                    }
                } else if ((idi + idj) == placeId) {
                    // La case est vide et on a selectionner un perso ! On regarde si le placeId est égal a la somme
                    // des 2 indices... vu que les indices des slots sont la sommes de ces 2 indices
                    button.setText(model.getPlayer().getCharacters().get(characterId) + "");
                    characters.set(idi, new Some<Character>(model.getPlayer().getCharacters().get(characterId)));
                }
                tableRow.addView(button);
                idi++;
            }
            idj += 100;
            idi = 0;
            tableLayout.addView(tableRow);
        }

        //et on le remet !
        Collections.reverse(listCharacters);
    }

    private void chooseCharacter(View view) {
        Intent intent = new Intent(this, FormationChooseActivity.class);
        intent.putExtra("Model", model);
        intent.putExtra("placeId", view.getId());
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

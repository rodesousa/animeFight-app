package fr.android.animefight.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
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

        int idAB = -999;
        int characterId = -999;
        int removeId = -999;
        int indiceTacticien = -999;

        model = (Model) getIntent().getSerializableExtra("Model");

        try {
            idAB = (int) getIntent().getSerializableExtra("placeId");
            characterId = (int) getIntent().getSerializableExtra("characterId");
        } catch (NullPointerException e) {
            try {
                removeId = (int) getIntent().getSerializableExtra("removeId");
            } catch (NullPointerException ee) {
            }
        }

        try {
            indiceTacticien = (int) getIntent().getSerializableExtra("indiceTacticien");
        } catch (NullPointerException e) {
        }

        // si on change de tacticien
        if (indiceTacticien != -999) {
            model.getPlayer().getTeam().setTacticien(model.getPlayer().getTacticiens().get(indiceTacticien));
        }

        // print tacticien
        Button formationTacticien = (Button) findViewById(R.id.formationTacticien);
        formationTacticien.setText("Tacticien:  " + model.getPlayer().getTeam().getTacticien());

        //print formation
        TableLayout tableLayout = (TableLayout) findViewById(R.id.formationTeam);

        List<List<Option<Character>>> listCharacters = model.getPlayer().getTeam().getFormation().getListCharacters();

        // on reverse le tableau !
        Collections.reverse(listCharacters);

        int partA = 0;
        int partB = 0;
        for (List<Option<Character>> characters : listCharacters) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));
            for (Option<Character> character : characters) {
                Button button = new Button(this);
                button.setId(partA + partB);
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(final View v) {
                        chooseCharacter(v);
                    }
                });
                if (!character.isEmpty) {
                    if (removeId == 999 && (partA + partB) == idAB) {
                        button.setText("");
                        characters.set(partA, new None<Character>());
                    } else {
                        button.setText(character.get() + "");
                    }
                } else if ((partA + partB) == idAB) {
                    // La case est vide et on a selectionner un perso ! On regarde si le idAB est égal a la somme
                    // des 2 indices... vu que les indices des slots sont la sommes de ces 2 indices
                    button.setText(model.getPlayer().getCharacters().get(characterId) + "");
                    characters.set(partA, new Some<Character>(model.getPlayer().getCharacters().get(characterId)));
                }
                tableRow.addView(button);
                partA++;
            }
            partB += 100;
            partA = 0;
            tableLayout.addView(tableRow);
        }

        //et on le remet !
        Collections.reverse(listCharacters);
    }

    private void chooseCharacter(View view) {
        Intent intent = new Intent(this, FormationChooseCharacterActivity.class);
        intent.putExtra("Model", model);
        intent.putExtra("placeId", view.getId());

        // on regarde si la case est vide ou pas
        // on peut seulement avoir l'info par rapport au text
        boolean empty = true;
        if (((Button) findViewById(view.getId())).getText() != "")
            empty = false;
        intent.putExtra("empty", empty);

        this.finish();
        startActivity(intent);
    }

    public void validate(View view) {
        Intent intent = new Intent(this, CoreActivity.class);
        intent.putExtra("Model", model);
        this.finish();
        startActivity(intent);
    }

    public void chooseTacticien(View view) {
        Intent intent = new Intent(this, FormationChooseTacticienActivity.class);
        intent.putExtra("Model", model);
        this.finish();
        startActivity(intent);
    }

}

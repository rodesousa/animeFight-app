package fr.android.animefight.Activity.home.formation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import fr.android.animefight.R;
import fr.android.animefight.bean.charac.Character;
import fr.android.animefight.model.Model;

import java.util.List;

/**
 * Created by rodesousa on 15/03/16.
 */
public class FormationChooseCharacterActivity extends Activity {

    private Model model;
    private int idSLot;
    private String type;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosefighter);

        model = (Model) getIntent().getSerializableExtra("Model");
        idSLot = (int) getIntent().getSerializableExtra("IdSlot");
        type = (String) getIntent().getSerializableExtra("Type");

        //Character ou tacticien
        List<? extends Character> characters;
        if ("Character".equals(type))
            characters = model.getPlayer().getCharacters();
        else {
            characters = model.getPlayer().getTacticiens();
        }

        LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.chooseFighter);

        int i = 0;
        for (Character character : characters) {
            Button button = new Button(this);
            if (model.getPlayer().getTeam().getCharacters().contains(character)) {
                button.setEnabled(false);
            }
            button.setText(character.toString());
            button.setId(i);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(final View v) {
                    selectCharacter(v);
                }
            });
            linearLayout.addView(button);
            i++;
        }

        Button remove = new Button(this);
        remove.setText("Remove");
        remove.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                removeCharcter(v);
            }
        });
        remove.setEnabled(false);
        if ( "Character".equals(type) && model.getPlayer().getTeam().getCharacters().size() > idSLot)
            remove.setEnabled(true);
        linearLayout.addView(remove);

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

    private void removeCharcter(View view) {
        model.getPlayer().getTeam().getCharacters().remove(idSLot);

        Intent intent = new Intent(this, FormationActivity.class);
        intent.putExtra("Model", model);
        this.finish();
        startActivity(intent);
    }

    private void selectCharacter(View view) {
        if ("Character".equals(type)) {
            List<Character> charactersTeam = model.getPlayer().getTeam().getCharacters();
            if (charactersTeam.size() == idSLot)
                charactersTeam.add(model.getPlayer().getCharacters().get(view.getId()));
            else
                charactersTeam.set(idSLot, model.getPlayer().getCharacters().get(view.getId()));
        } else
            model.getPlayer().getTeam().setTacticien(model.getPlayer().getTacticiens().get(view.getId()));

        Intent intent = new Intent(this, FormationActivity.class);
        intent.putExtra("Model", model);
        this.finish();
        startActivity(intent);
    }
}

package fr.android.animefight.Activity.home.character;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import fr.android.animefight.R;
import fr.android.animefight.bean.items.equipable.Armor;
import fr.android.animefight.model.Model;
import fr.android.animefight.utils.Option;

/**
 * L'activity qui permet de voir les stats et de pouvoir equiper un perso
 * Created by rodesousa on 16/03/16.
 */
public class InspectCharacterActivity extends Activity {

    private Model model;
    private int indice;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.charaselect);

        model = (Model) getIntent().getSerializableExtra("Model");
        indice = (int) getIntent().getSerializableExtra("characterId");

        TableLayout linearLayout = (TableLayout) this.findViewById(R.id.stuffCharacter);
        linearLayout.setBackgroundResource(model.getPlayer().getCharacters().get(indice).getImagePath());
        Button buttonBody = (Button) linearLayout.findViewById(R.id.stuffBody);
        Button buttonHead = (Button) linearLayout.findViewById(R.id.stuffHead);

        Option<Armor> armor = model.getPlayer().getCharacters().get(indice).getArmor();
        Option<Armor> head = model.getPlayer().getCharacters().get(indice).getHead();

        if (!armor.isEmpty) {
            buttonBody.setText(armor.get() + "");
        }

        if (!head.isEmpty) {
            buttonHead.setText(head.get() + "");
        }

    }
}

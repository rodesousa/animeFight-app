package fr.android.animefight.Activity.home.character;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import fr.android.animefight.R;
import fr.android.animefight.bean.items.equipable.Armor;
import fr.android.animefight.controller.inspectCharacter.ControllerInspect;
import fr.android.animefight.model.Model;
import fr.android.animefight.utils.Option;

/**
 * L'activity qui permet de voir les stats et de pouvoir equiper un perso
 * Created by rodesousa on 16/03/16.
 */
public class InspectCharacterActivity extends Activity {

    private ControllerInspect controller;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.charaselect);

        int indice = (int) getIntent().getSerializableExtra("characterId");
        controller =  new ControllerInspect((Model) getIntent().getSerializableExtra("Model"), indice);

        TableLayout linearLayout = (TableLayout) this.findViewById(R.id.stuffCharacter);
        linearLayout.setBackgroundResource(controller.getCharacter().getImagePath());

        //print slot
        Button buttonBody = (Button) linearLayout.findViewById(R.id.stuffBody);
        Button buttonHead = (Button) linearLayout.findViewById(R.id.stuffHead);
        Option<Armor> armor = controller.getCharacter().getArmor();
        Option<Armor> head = controller.getCharacter().getHead();

        if (!armor.isEmpty)
            buttonBody.setBackgroundResource(armor.get().getImagePath());
        if (!head.isEmpty)
            buttonHead.setBackgroundResource(head.get().getImagePath());

        //print descriptif
        TextView textView = (TextView) findViewById(R.id.descriptifCharacter);
        textView.setText("\n" +
                "name :" + controller.getCharacter() + "\n" +
                "Atk :" + controller.getCharacter().getAttack() + "\n" +
                "Def :" + controller.getCharacter().getDefense() + "\n" +
                "Life :" + controller.getCharacter().getLifeCurrent() + "/" +
                controller.getCharacter().getLifeCurrent() +"\n" +
                "");

    }
}

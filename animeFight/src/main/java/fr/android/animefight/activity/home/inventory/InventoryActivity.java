package fr.android.animefight.activity.home.inventory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import fr.android.animefight.R;
import fr.android.animefight.bean.inventory.CaseInventory;
import fr.android.animefight.controller.Controller;
import fr.android.animefight.controller.inventory.InventoryController;

/**
 * Created by rodesousa on 15/03/16.
 */
public class InventoryActivity extends Activity {

    private InventoryController controller;
    private int characterId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);
        //init controller
        Controller con = (Controller) getIntent().getSerializableExtra("Controller");
        controller = new InventoryController(con.getModel());

        try {
            characterId = (int) getIntent().getSerializableExtra("CharacterId");
            if (getIntent().getSerializableExtra("Type") != "")
                controller.setType(InventoryController.Type.Choose);
        } catch (Exception ignored) {
        }

        LinearLayout view = (LinearLayout) findViewById(R.id.inventoryScrollView);
        int id = 0;

        for (CaseInventory caseInventory : this.controller.getModel().getPlayer().getInventory().getCases()) {
            if (this.controller.sortBy(caseInventory)) {
                ImageButton imageButton = new ImageButton(this);
                //add layout
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                imageButton.setLayoutParams(layoutParams);
                //add background
                imageButton.setBackgroundResource(caseInventory.getItem().getImagePath());
                //add id
                imageButton.setId(id);
                //add view
                view.addView(imageButton);
                //add event
                imageButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(final View v) {
                        if (InventoryActivity.this.controller.isDescriptif())
                            descriptItem(v);
                        else
                            chooseItem(v);
                    }
                });
            }
            // pour avoir une logique id afficher et id ds la list d'objet du joueur
            id++;
        }
    }

    private void descriptItem(View view) {
        ImageView viewById = (ImageView) findViewById(R.id.descri_item);
        viewById.setBackgroundResource(R.drawable.naru);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearInventory);
        linearLayout.setVisibility(0);
    }

    public void backInventory(View view) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearInventory);
        linearLayout.setVisibility(4);
    }

    public void chooseItem(View view) {
        controller.chooseItem(view, characterId);
        this.finish();
    }

}

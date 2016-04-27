package fr.android.animefight.Activity.home.inventory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import fr.android.animefight.R;
import fr.android.animefight.bean.inventory.CaseInventory;
import fr.android.animefight.controller.inventory.ControllerInventory;
import fr.android.animefight.model.Model;

/**
 * Created by rodesousa on 15/03/16.
 */
public class InventoryActivity extends Activity {

    private ControllerInventory controllerInventory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);

        controllerInventory = new ControllerInventory((Model) getIntent().getSerializableExtra("Model"));
        ScrollView view = (ScrollView) findViewById(R.id.scrollView);

        for (CaseInventory caseInventory : controllerInventory.getModel().getPlayer().getInventory().getCases()) {
            ImageButton imageButton = new ImageButton(this);
            ScrollView.LayoutParams layoutParams = new ScrollView.LayoutParams(ScrollView.LayoutParams.WRAP_CONTENT,
                    ScrollView.LayoutParams.WRAP_CONTENT);
            imageButton.setLayoutParams(layoutParams);
            imageButton.setBackgroundResource(caseInventory.getItem().getImagePath());
            view.addView(imageButton);
            imageButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(final View v) {
                    descript_item(v);
                }
            });
        }
    }

    private void descript_item(View view) {
        ImageView viewById = (ImageView) findViewById(R.id.descri_item);
        viewById.setBackgroundResource(R.drawable.naru);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearInventory);
        linearLayout.setVisibility(0);
    }

    public void backInventory(View view){
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearInventory);
        linearLayout.setVisibility(4);
    }


}

package fr.android.animefight.Activity.home.inventory;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
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
            ImageView imageView = new ImageView(this);
            ScrollView.LayoutParams layoutParams = new ScrollView.LayoutParams(ScrollView.LayoutParams.WRAP_CONTENT,
                    ScrollView.LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(layoutParams);
            imageView.setBackgroundResource(caseInventory.getItem().getImagePath());
            view.addView(imageView);
        }
    }

}

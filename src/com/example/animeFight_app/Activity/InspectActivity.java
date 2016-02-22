package com.example.animeFight_app.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.animeFight_app.R;
import com.example.animeFight_app.bean.Item;
import com.example.animeFight_app.bean.Items.Equipable;
import com.example.animeFight_app.mock.MockEquipable;
import com.example.animeFight_app.mock.MyTeam;

/**
 * Created by rohamdi on 22/02/2016.
 */
public class InspectActivity extends Activity {
    private Equipable mainEquipable;
    private ImageView mainImage;
    private TextView mainText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inspect);

        mainEquipable= MockEquipable.getArmor();

        mainImage = (ImageView) findViewById(R.id.inspectImage);
        mainText = (TextView) findViewById(R.id.inspectDescription);
        displaySelectedItem();

    }

    public void displaySelectedItem(){
        String variableValue = mainEquipable.getImagePath();
        int drawableID = this.getBaseContext().getResources().getIdentifier(variableValue, "drawable", getPackageName());
        this.mainImage.setImageResource(drawableID);
        //this.mainText.setText(mainEquipable.getDescription());
    }

    public void returnInspectToTeam(View view){
        this.finish();
    }
}

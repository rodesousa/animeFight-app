package com.example.animeFight_app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.animeFight_app.R;
import com.example.animeFight_app.model.Model;

/**
 * Created by rodesousa on 15/02/16.
 */
public class StoryActivity extends Activity {

    private Model model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);
        model = (Model) getIntent().getSerializableExtra("Model");

        //Recup le textView pour y mettre le nom de la story
        TextView tv = (TextView) findViewById(R.id.titreStory);
        tv.setTextSize(20);
        tv.setTextColor(Color.RED);
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);

        tv.setText("Bienvenue dans le monde de \n" + model.getState().getWorld().toString());
    }

    public void returnStoryToCore(View view) {
        this.finish();
    }

    public void fight(View view) {
        Intent intent = new Intent(this, FightActivity.class);
        intent.putExtra("Model", model);
        startActivity(intent);
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}

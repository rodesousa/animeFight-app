package com.example.animeFight_app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

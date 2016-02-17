package com.example.animeFight_app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.animeFight_app.R;
import com.example.animeFight_app.mock.MockModel;
import com.example.animeFight_app.model.Model;

/**
 * Created by rodesousa on 13/02/16.
 */
public class CoreActivity extends Activity {

    private Model model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        model = MockModel.factoryModel();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.core);
    }

    public void returnCoreToMain(View view) {
        this.finish();
    }

    public void callStory(View view) {
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra("Model", model);
        startActivity(intent);
    }

    public void callEventAct(View view) {
        Intent intent = new Intent(this, EventActivity.class);
        startActivity(intent);
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}

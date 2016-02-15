package com.example.animeFight_app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.animeFight_app.R;

/**
 * Created by rodesousa on 15/02/16.
 */
public class StoryActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);
    }

    public void returnStoryToCore(View view) {
        Intent intent = new Intent(this, CoreActivity.class);
        startActivity(intent);
    }
}

package com.example.animeFight_app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.animeFight_app.R;

/**
 * Created by rodesousa on 16/02/16.
 */
public class FightActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight);
    }

    public void returnFightToStory(View view) {
        Intent intent = new Intent(this, StoryActivity.class);
        startActivity(intent);
    }
}

package com.example.animeFight_app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.animeFight_app.R;

/**
 * Created by rodesousa on 13/02/16.
 */
public class CoreActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.core);
    }

    public void returnCoreToMain(View view) {
        Intent intent = new Intent(this, MyActivity.class);
        startActivity(intent);
    }

    public void callStory(View view) {
        Intent intent = new Intent(this, StoryActivity.class);
        startActivity(intent);
    }

    public void callEventAct(View view) {
        Intent intent = new Intent(this, EventActivity.class);
        startActivity(intent);
    }
}

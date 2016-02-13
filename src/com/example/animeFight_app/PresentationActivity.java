package com.example.animeFight_app;

import android.app.Activity;
import android.os.Bundle;
import com.example.animeFight_app.view.*;

/**
 *
 * Created by rodesousa on 13/02/16.
 */
public class PresentationActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GifView(this));
    }

}

package fr.android.animefight.activity.event;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import fr.android.animefight.R;


/**
 * Activity des events
 * Created by rodesousa on 15/02/16.
 */
public class EventActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);
    }

    public void returnEventToCore(View view) {
        this.finish();
    }
}

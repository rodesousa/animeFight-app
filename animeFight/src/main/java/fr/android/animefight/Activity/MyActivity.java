package fr.android.animefight.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import fr.android.animefight.R;

/**
 * La toute premièere activity. C'est celle ou on se log
 */
public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void callCoreAct(View view) {
        Intent intent = new Intent(this, CoreActivity.class);
        startActivity(intent);
    }
}

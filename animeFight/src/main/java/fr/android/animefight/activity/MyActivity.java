package fr.android.animefight.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import fr.android.animefight.R;
import fr.android.animefight.ws.AsyncResponse;
import fr.android.animefight.ws.WsClient;

/**
 * La toute premièere activity. C'est celle ou on se log
 */
public class MyActivity extends Activity implements AsyncResponse{
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void callCoreAct(View view) {
        invokeWS(view);
//        Intent intent = new Intent(this, CoreActivity.class);
//        startActivity(intent);
    }

    public void invokeWS(View view) {
        WsClient.get("https://sleepy-everglades-20389.herokuapp.com/db", this);
    }

    @Override
    public void processFinish(boolean state) {
        System.out.println(state);

    }
}

package fr.android.animefight.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import fr.android.animefight.R;
import fr.android.animefight.ws.AsyncResponse;
import fr.android.animefight.ws.WsClient;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;

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

    public void callCoreAct(View view) throws UnsupportedEncodingException, JSONException {
        invokeWS();
//        Intent intent = new Intent(this, CoreActivity.class);
//        startActivity(intent);
    }

    public void invokeWS() throws UnsupportedEncodingException, JSONException {
        WsClient.login("https://sleepy-everglades-20389.herokuapp.com/signin", this, this.getApplicationContext());
    }

    @Override
    public void processFinish(boolean state) {

        if (state){
            Toast.makeText(getApplicationContext(), "true", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "false", Toast.LENGTH_LONG).show();
        }
    }
}

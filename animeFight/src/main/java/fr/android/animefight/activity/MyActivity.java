package fr.android.animefight.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import fr.android.animefight.R;
import fr.android.animefight.activity.home.CoreActivity;
import fr.android.animefight.ws.AsyncResponse;
import fr.android.animefight.ws.WsClient;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;

/**
 * La toute premièere activity. C'est celle ou on se log
 */
public class MyActivity extends Activity implements AsyncResponse {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void callCoreAct(View view) throws UnsupportedEncodingException, JSONException {
        String login = ((EditText) findViewById(R.id.login)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();
        if (!login.isEmpty() && !password.isEmpty())
            invokeWS(login, password);
        else {
            Toast.makeText(getApplicationContext(), "Il manque des champs Mother Fucker", Toast.LENGTH_LONG).show();
        }
    }

    public void invokeWS(String login, String password) throws UnsupportedEncodingException, JSONException {
        WsClient.login(this, this.getApplicationContext(), login, password);
    }

    @Override
    public void processFinish(boolean state) {
        if (state) {
            Intent intent = new Intent(this, CoreActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "false", Toast.LENGTH_LONG).show();
        }
    }
}

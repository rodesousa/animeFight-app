package fr.android.animefight.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import fr.android.animefight.R;
import fr.android.animefight.activity.home.CoreActivity;
import fr.android.animefight.ws.WsClient;

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
        invokeWS();
    }

    public void callCoreAct(View view) {
        Intent intent = new Intent(this, CoreActivity.class);
        startActivity(intent);
    }

    public void invokeWS() {
        WsClient.get("https://sleepy-everglades-20389.herokuapp.com/db");
//        // Make RESTful webservice call using AsyncHttpClient object
//        AsyncHttpClient client = new AsyncHttpClient();
//        client.get("https://sleepy-everglades-20389.herokuapp.com/db", new AsyncHttpResponseHandler() {
//                    @Override
//                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                        System.out.println("\n RDS SUCCES \n");
//                    }
//
//                    @Override
//                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                        System.out.println("\n RDS FAIL \n");
//                    }
//                }
//
//        );
    }

}

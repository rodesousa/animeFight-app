package fr.android.animefight.ws;

import com.loopj.android.http.AsyncHttpResponseHandler;
import cz.msebera.android.httpclient.Header;

/**
 * Created by rodesousa on 25/05/16.
 */
public class HttpResponse extends AsyncHttpResponseHandler {
    private boolean succes;

    public HttpResponse() {
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        System.out.println("\n RDS SUCCES \n");
        succes = true;
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        System.out.println("\n RDS FAIL \n");
        succes = false;
    }

    public boolean isSucces() {
        return succes;
    }
}

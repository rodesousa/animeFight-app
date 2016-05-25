package fr.android.animefight.ws;

import com.loopj.android.http.AsyncHttpClient;

/**
 * Created by rodesousa on 25/05/16.
 */
public class WsClient {

    public static boolean get(String url) {
        AsyncHttpClient client = new AsyncHttpClient();
        HttpResponse responseHandler = new HttpResponse();
        client.get(url, responseHandler);
        return responseHandler.isSucces();
    }

}

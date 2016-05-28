package fr.android.animefight.ws;

import com.loopj.android.http.AsyncHttpClient;

/**
 * Created by rodesousa on 25/05/16.
 */
public class WsClient {

    public static void get(String url, AsyncResponse asyncResponse) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.setMaxConnections(5);

        HttpResponse responseHandler = new HttpResponse(asyncResponse);
        client.get(url, responseHandler);
    }

}

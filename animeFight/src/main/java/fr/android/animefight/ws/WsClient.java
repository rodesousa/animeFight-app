package fr.android.animefight.ws;

import android.content.Context;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import cz.msebera.android.httpclient.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Created by rodesousa on 25/05/16.
 */
public class WsClient {

    public static void get(String url, AsyncResponse asyncResponse, Context applicationContext) {
        //curl --header "Content-type: application/json" --request POST --data '{"name": "Toto", "password": "aa"}' https://sleepy-everglades-20389.herokuapp.com/signin
        AsyncHttpClient client = init();

        HttpResponse responseHandler = new HttpResponse(asyncResponse);
        client.get(url, responseHandler);
    }


    public static void login(String url, AsyncResponse asyncResponse, Context applicationContext) throws JSONException, UnsupportedEncodingException {
        AsyncHttpClient client = init();
        RequestParams requestParams = new RequestParams();

        HttpResponse responseHandler = new HttpResponse(asyncResponse);

        JSONObject jsonParams = new JSONObject();
        jsonParams.put("name", "Toto");
        jsonParams.put("password", "aa");
        StringEntity entity = new StringEntity(jsonParams.toString());
        client.post(applicationContext,url, entity, "application/json", responseHandler);

//        client.addHeader(AsyncHttpClient.HEADER_CONTENT_TYPE, "application/json");

//        client.post(url, requestParams, responseHandler);
    }

    public static AsyncHttpClient init() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.setMaxConnections(5);
        return client;
    }

}

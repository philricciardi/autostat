package philricciardi.pace.com.autostat.webservice;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

/**
 * Author: Phil Ricciardi
 * Description: Call Web Services and get the return Java Objects
 *
 */
public class WebServiceHandler extends AsyncTask<String, Integer, Object> {

    private String returnObjectName = null;
    private Object x = null;
    public AsyncResult delegate=null;

    public WebServiceHandler(String returnObjectName, AsyncResult asyncResult) {
        this.returnObjectName = returnObjectName;
        this.delegate = asyncResult;
        try{
            Class resolvedClass = (Class.forName(returnObjectName));
            x = Array.newInstance(resolvedClass, 1);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected Object doInBackground(String... params) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(params[0]));
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
            JsonReader jsonReader = new JsonReader(reader);
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create();
            Object jsonMapperReturnObject = gson.fromJson(jsonReader, x.getClass());
            return jsonMapperReturnObject;
        } catch (Exception e) {
            Log.e("WEB SERVICE ERROR", "Could not retrieve " );
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        delegate.processFinish(o);
    }
}

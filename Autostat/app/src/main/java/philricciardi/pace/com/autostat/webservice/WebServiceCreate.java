package philricciardi.pace.com.autostat.webservice;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.List;

/**
 * Created by phil on 11/30/14.
 */
public class WebServiceCreate extends AsyncTask<String, Void, Void> {

    private List<NameValuePair> parms;

    public WebServiceCreate(List<NameValuePair> parms){
        this.parms = parms;
    }

    @Override
    protected Void doInBackground(String... params) {
        try{
            HttpPost post = new HttpPost(params[0]);
            post.setEntity(new UrlEncodedFormEntity(parms));
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(post);
            HttpEntity entity = response.getEntity();
            String htmlResponse = EntityUtils.toString(entity);
            Log.i("Web Service Output", htmlResponse);
        }
        catch(Exception e){
            Log.e("Web Service Failed", e.getMessage());
        }
        return null;
    }
}

package philricciardi.pace.com.autostat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import philricciardi.pace.com.autostat.entity.Location;
import philricciardi.pace.com.autostat.webservice.AsyncResult;
import philricciardi.pace.com.autostat.webservice.WebServiceCreate;
import philricciardi.pace.com.autostat.webservice.WebServiceHandler;


public class Mechanic_login_activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic_login_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mechanic_login_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void createMechanicAccount(View v){
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        EditText nameEditText = (EditText) findViewById(R.id.input_name_signup);
        String name = nameEditText.getText().toString();
        EditText emailEditText = (EditText) findViewById(R.id.input_email_signup);
        String email = emailEditText.getText().toString();
        EditText passwordEditText = (EditText) findViewById(R.id.input_password_signup);
        String password = passwordEditText.getText().toString();
        Spinner shopSpinner = (Spinner) findViewById(R.id.shop_dropdown);
        String shop = shopSpinner.getSelectedItem().toString();
        nameValuePairs.add(new BasicNameValuePair("name", name));
        nameValuePairs.add(new BasicNameValuePair("email", email));
        nameValuePairs.add(new BasicNameValuePair("password", password));
        nameValuePairs.add(new BasicNameValuePair("shop", shop));
        WebServiceCreate create = new WebServiceCreate(nameValuePairs);
        create.execute(getString(R.string.insert_mechanic_web_service));
    }

    public void mechanicSignIn(View v){
        Intent intent = new Intent(this, Mechanic_Home_Activity.class);
        startActivity(intent);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements AsyncResult{

        public PlaceholderFragment() {
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            WebServiceHandler webServiceHandler = new WebServiceHandler("philricciardi.pace.com.autostat.entity.Location", this);
            try {
                webServiceHandler.execute(getString(R.string.retrieve_location_web_service));
            }
            catch(Exception e){
                Log.e("Web Service Error: populate shop dropdown", e.getMessage());
            }
        }

        public void populateDropDown(Location [] locations){
            try{
                ArrayList<String> locationNames = new ArrayList<String>();
                for(Location location: locations){
                    locationNames.add(location.getLocation_name());
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getActivity().getApplicationContext(), R.layout.layout_spinner, locationNames);
                arrayAdapter.setDropDownViewResource(R.layout.layout_spinner_item);
                Spinner spinner = (Spinner) getView().findViewById(R.id.shop_dropdown);

                spinner.setAdapter(arrayAdapter);
            }
            catch(Exception e){
                Log.e("populate shop dropdown error", e.getMessage());
            }
        }

        @Override
        public void processFinish(Object result) {
            Location[] locations = (Location[]) result;
            populateDropDown(locations);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_mechanic_login_activity, container, false);
            return rootView;
        }
    }
}

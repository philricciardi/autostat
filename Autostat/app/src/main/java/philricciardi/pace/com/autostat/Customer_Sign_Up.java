package philricciardi.pace.com.autostat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import philricciardi.pace.com.autostat.webservice.WebServiceCreate;


public class Customer_Sign_Up extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer__sign__up);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_customer__sign__up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Create a customer service record
    public void createCustomerServiceRecord(View v){
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        EditText nameEditText = (EditText) findViewById(R.id.cs_input_name);
        String name = nameEditText.getText().toString();
        EditText emailEditText = (EditText) findViewById(R.id.cs_input_email);
        String email = emailEditText.getText().toString();
        EditText vehicleYearText = (EditText) findViewById(R.id.cs_input_vehicle_year);
        String vehicleYear = vehicleYearText.getText().toString();
        EditText vehicleMakeText = (EditText) findViewById(R.id.cs_input_vehicle_make);
        String vehicleMake = vehicleMakeText.getText().toString();
        EditText vehicleModelText = (EditText) findViewById(R.id.cs_input_vehicle_model);
        String vehicleModel = vehicleModelText.getText().toString();

        nameValuePairs.add(new BasicNameValuePair("name", name));
        nameValuePairs.add(new BasicNameValuePair("email", email));
        nameValuePairs.add(new BasicNameValuePair("year", vehicleYear));
        nameValuePairs.add(new BasicNameValuePair("make", vehicleMake));
        nameValuePairs.add(new BasicNameValuePair("model", vehicleModel));
        WebServiceCreate create = new WebServiceCreate(nameValuePairs);
        create.execute(getString(R.string.insert_customer_web_service));
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_customer__sign__up, container, false);
            return rootView;
        }
    }
}

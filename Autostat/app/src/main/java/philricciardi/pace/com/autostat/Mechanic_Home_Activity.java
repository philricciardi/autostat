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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import philricciardi.pace.com.autostat.entity.Customer;
import philricciardi.pace.com.autostat.webservice.AsyncResult;
import philricciardi.pace.com.autostat.webservice.WebServiceHandler;


public class Mechanic_Home_Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic__home_);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mechanic__home_, menu);
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

    // Sign up a new customer for a service
    public void signUpCustomer(View v){
        Intent intent = new Intent(this, Customer_Sign_Up.class);
        startActivity(intent);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements AsyncResult {

        public PlaceholderFragment() {
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            WebServiceHandler webServiceHandler = new WebServiceHandler("philricciardi.pace.com.autostat.entity.Customer", this);
            try {
                webServiceHandler.execute(getString(R.string.retrieve_customer_list_web_service));
            }
            catch(Exception e){
                Log.e("Web Service Error: populate customer list", e.getMessage());
            }
        }

        @Override
        public void processFinish(Object result) {
            Customer [] customers = (Customer []) result;
            populateCustomerAdapter(customers);
        }

        private void populateCustomerAdapter(Customer [] customers) {
            final ListView customerListView = (ListView) getActivity().findViewById(R.id.customer_list);
            customerListView.setAdapter(new MyCustomerArrayAdapter(this.getActivity().getApplicationContext(), customers));
            customerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                    Object o = customerListView.getItemAtPosition(position);
                    Customer fullObject = (Customer)o;
                    Toast.makeText(getActivity().getApplicationContext(), "You have chosen: " + " " + fullObject.getCustomer_name(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_mechanic__home_, container, false);
            return rootView;
        }
    }
}

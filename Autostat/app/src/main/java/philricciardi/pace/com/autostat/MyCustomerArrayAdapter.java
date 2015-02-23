package philricciardi.pace.com.autostat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import philricciardi.pace.com.autostat.entity.Customer;

/**
 * Created by phil on 12/16/14.
 */
public class MyCustomerArrayAdapter extends BaseAdapter {
    private static Customer[] customerArrayList;

    private LayoutInflater mInflater;

    public MyCustomerArrayAdapter(Context context, Customer[] results) {
        customerArrayList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return customerArrayList.length;
    }

    public Object getItem(int position) {
        return customerArrayList[position];
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.layout_list_view_item, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.customer_name);
            holder.txtEmail = (TextView) convertView.findViewById(R.id.customer_email);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(customerArrayList[position].getCustomer_name());
        holder.txtEmail.setText(customerArrayList[position].getCustomer_email());

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtEmail;
    }
}

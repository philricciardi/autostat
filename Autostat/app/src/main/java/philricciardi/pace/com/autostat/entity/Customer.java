package philricciardi.pace.com.autostat.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by phil on 11/22/14.
 */
public class Customer implements Serializable{
    Integer customer_id;
    String customer_name;
    String customer_email;

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    Timestamp create_date;

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

}

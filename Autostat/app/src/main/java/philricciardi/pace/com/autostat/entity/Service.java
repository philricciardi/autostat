package philricciardi.pace.com.autostat.entity;

import java.sql.Timestamp;

/**
 * Created by phil on 11/25/14.
 */
public class Service {

    private Integer service_id;
    private Integer service_location;
    private Integer assigned_mechanic;
    private Integer customer;
    private Integer service_type;
    private Timestamp service_date;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public Integer getService_location() {
        return service_location;
    }

    public void setService_location(Integer service_location) {
        this.service_location = service_location;
    }

    public Integer getAssigned_mechanic() {
        return assigned_mechanic;
    }

    public void setAssigned_mechanic(Integer assigned_mechanic) {
        this.assigned_mechanic = assigned_mechanic;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public Integer getService_type() {
        return service_type;
    }

    public void setService_type(Integer service_type) {
        this.service_type = service_type;
    }

    public Timestamp getService_date() {
        return service_date;
    }

    public void setService_date(Timestamp service_date) {
        this.service_date = service_date;
    }
}

package philricciardi.pace.com.autostat.entity;

/**
 * Created by phil on 11/25/14.
 */
public class ServiceType {
    private Integer service_id;
    private String service_name;

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }
}

package philricciardi.pace.com.autostat.entity;

/**
 * Created by phil on 11/25/14.
 */
public class ServiceStatus {
    private Integer service_status_id;
    private Integer service_id;
    private Integer service_type_item;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getService_status_id() {
        return service_status_id;
    }

    public void setService_status_id(Integer service_status_id) {
        this.service_status_id = service_status_id;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public Integer getService_type_item() {
        return service_type_item;
    }

    public void setService_type_item(Integer service_type_item) {
        this.service_type_item = service_type_item;
    }
}

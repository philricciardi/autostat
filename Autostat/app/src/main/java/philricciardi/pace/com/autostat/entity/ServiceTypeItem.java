package philricciardi.pace.com.autostat.entity;

/**
 * Created by phil on 11/25/14.
 */
public class ServiceTypeItem {
    private Integer service_type_item_id;
    private Integer service_id;
    private String service_type_item_code;
    private String service_type_item_name;

    public Integer getService_type_item_id() {
        return service_type_item_id;
    }

    public void setService_type_item_id(Integer service_type_item_id) {
        this.service_type_item_id = service_type_item_id;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public String getService_type_item_code() {
        return service_type_item_code;
    }

    public void setService_type_item_code(String service_type_item_code) {
        this.service_type_item_code = service_type_item_code;
    }

    public String getService_type_item_name() {
        return service_type_item_name;
    }

    public void setService_type_item_name(String service_type_item_name) {
        this.service_type_item_name = service_type_item_name;
    }
}

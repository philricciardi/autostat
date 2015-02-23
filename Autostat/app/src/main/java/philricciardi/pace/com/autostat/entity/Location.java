package philricciardi.pace.com.autostat.entity;

/**
 * Created by phil on 11/25/14.
 */
public class Location {

    private Integer location_id;
    private String location_name;
    private String location_city;
    private String location_state;
    private String location_street;

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getLocation_city() {
        return location_city;
    }

    public void setLocation_city(String location_city) {
        this.location_city = location_city;
    }

    public String getLocation_state() {
        return location_state;
    }

    public void setLocation_state(String location_state) {
        this.location_state = location_state;
    }

    public String getLocation_street() {
        return location_street;
    }

    public void setLocation_street(String location_street) {
        this.location_street = location_street;
    }
}

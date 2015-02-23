package philricciardi.pace.com.autostat.entity;

/**
 * Created by phil on 11/25/14.
 */
public class Mechanic {
    private Integer mechanic_id;
    private String mechanic_name;
    private String mechanic_email;
    private String mechanic_pw;

    public Integer getMechanic_id() {
        return mechanic_id;
    }

    public void setMechanic_id(Integer mechanic_id) {
        this.mechanic_id = mechanic_id;
    }

    public String getMechanic_name() {
        return mechanic_name;
    }

    public void setMechanic_name(String mechanic_name) {
        this.mechanic_name = mechanic_name;
    }

    public String getMechanic_email() {
        return mechanic_email;
    }

    public void setMechanic_email(String mechanic_email) {
        this.mechanic_email = mechanic_email;
    }

    public String getMechanic_pw() {
        return mechanic_pw;
    }

    public void setMechanic_pw(String mechanic_pw) {
        this.mechanic_pw = mechanic_pw;
    }
}

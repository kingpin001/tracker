package io.egen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.Date;
import java.util.UUID;


@Entity
@NamedQueries({
        @NamedQuery(name = "Alerts.findAll",
                query = "Select alerts From Alerts alerts Order By alerts.timeStamp DESC"),
        @NamedQuery(name = "Alerts.findByVin",
                query = "Select alerts FROM Alerts alerts WHERE alerts.vin = :pvin")
})
public class Alerts {

    @Id
    private String id;

    public Alerts() {
        this.id = UUID.randomUUID()
                .toString();
    }

    private String vin;
    private String message;
    private Date timeStamp;
    private String priority;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}

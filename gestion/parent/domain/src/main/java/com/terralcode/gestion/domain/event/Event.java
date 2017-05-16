package com.terralcode.gestion.domain.event;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ezequiel
 */
@Entity
public class Event implements Serializable {

    @Id
    public Long id;

    public String customer;

    @Temporal(TemporalType.TIMESTAMP)
    public Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    public Date endTime;

    public String reason;

    public String notes;

    public String complaints;

    public String status;

    public String statusNotes;

}

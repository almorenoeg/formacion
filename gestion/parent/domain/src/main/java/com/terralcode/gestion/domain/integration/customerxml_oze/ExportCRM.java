/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.integration.customerxml_oze;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmsuarez
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "ExportCRM")
public class ExportCRM {
    
    protected String version = "1.0";
    protected String dateTime;
    protected List<ExportAppointment> appointments;

    public ExportCRM() {
        Calendar cal = Calendar.getInstance(new Locale("es", "ES"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = cal.getTime();
        this.dateTime = formatter.format(d);
        this.appointments = new ArrayList<ExportAppointment>();
    }
    
    @XmlAttribute(name = "Version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    @XmlAttribute(name = "Date")
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    
    @XmlElementWrapper(name="Appointments")
    @XmlElement(name = "Appointment")
    public List<ExportAppointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<ExportAppointment> appointments) {
        this.appointments = appointments;
    }
    
}
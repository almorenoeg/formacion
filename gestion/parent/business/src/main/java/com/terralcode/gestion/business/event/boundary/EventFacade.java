package com.terralcode.gestion.business.event.boundary;

import com.terralcode.gestion.domain.event.Event;
import com.naoset.framework.business.commons.crud.CRUD;
import com.naoset.framework.domain.company.employee.Employee;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author Ezequiel
 */
@Stateless
public class EventFacade extends CRUD<Event> {

    EntityManager em;
            
    public List<Event> findEventsByEmployee(Employee employee, Date startDate, Date endDate)
    {
        List<Event> events = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {

            Event event = new Event();
            event.id = Long.valueOf(i);
            event.customer = "customer" + i;
            event.reason = "reason" + i;
            event.status = "status" + i;
            event.statusNotes = "StatusNotes" + i;
            event.notes = "notes" + i;
            event.complaints = "complaints" + i;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.DAY_OF_MONTH, i);
            event.startTime = calendar.getTime();
            calendar.add(Calendar.HOUR_OF_DAY, random.nextInt(3));
            event.endTime = calendar.getTime();
            events.add(event);
        }
        return events;

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

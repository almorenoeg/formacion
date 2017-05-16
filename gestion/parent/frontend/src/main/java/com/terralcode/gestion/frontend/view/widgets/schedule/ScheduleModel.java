package com.terralcode.gestion.frontend.view.widgets.schedule;

import com.terralcode.gestion.domain.event.Event;
import com.vaadin.cdi.UIScoped;
import java.util.List;

/**
 *
 * @author Ezequiel
 */
@UIScoped
public class ScheduleModel {
    List<Event> events;
}

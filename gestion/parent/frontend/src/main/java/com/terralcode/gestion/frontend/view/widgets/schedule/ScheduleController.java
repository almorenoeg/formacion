package com.terralcode.gestion.frontend.view.widgets.schedule;

import com.terralcode.gestion.business.event.boundary.EventFacade;
import com.naoset.framework.domain.company.employee.Employee;
import com.vaadin.cdi.UIScoped;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author Ezequiel
 */
@UIScoped
public class ScheduleController {
    @Inject
    ScheduleModel model;
    @Inject
    EventFacade eventFacade;
    
    @PostConstruct
    public void init(){
    }
            
}

package com.naoset.framework.frontend;


import com.vaadin.cdi.server.VaadinCDIServlet;
import javax.servlet.ServletException;


@SuppressWarnings("serial")
public class DashboardServlet extends VaadinCDIServlet {

    @Override
    protected final void servletInitialized() throws ServletException {
        super.servletInitialized();
        getService().addSessionInitListener(new DashboardSessionInitListener());
    }
}
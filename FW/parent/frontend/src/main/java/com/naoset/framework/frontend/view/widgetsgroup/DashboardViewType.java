package com.naoset.framework.frontend.view.widgetsgroup;

import com.vaadin.server.Resource;

public class DashboardViewType {

    String title;
    String viewName;
    Resource icon;
    boolean stateful;

    public DashboardViewType(final String title,
                             final String viewName,
                             final Resource icon,
                             final boolean stateful)
    {
        this.title = title;
        this.viewName = viewName;
        this.icon = icon;
        this.stateful = stateful;
    }

    public boolean isStateful()
    {
        return stateful;
    }

    public String getViewName()
    {
        return viewName;
    }  

    public Resource getIcon()
    {
        return icon;
    } 

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

}

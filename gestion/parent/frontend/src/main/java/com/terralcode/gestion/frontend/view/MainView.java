package com.terralcode.gestion.frontend.view;

import com.naoset.framework.frontend.DashboardNavigator;
import com.naoset.framework.frontend.view.widgetsgroup.DashboardMenu;
import com.vaadin.cdi.CDIView;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/*
 * Dashboard MainView is a simple HorizontalLayout that wraps the menu on the
 * left and creates a simple container for the navigator on the right.
 */
@SuppressWarnings("serial")
@CDIView
public class MainView extends HorizontalLayout implements View {

    @Inject
    private CDIViewProvider viewProvider;
    @Inject
    DashboardMenu dashboardMenu;
    DashboardNavigator dashboardNavigator;

    @PostConstruct
    void init()
    {

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event)
    {
        setSizeFull();
        addStyleName("mainview");
        dashboardMenu.logo.setValue("<strong>Gestión Alumnos</strong>");
        addComponent(dashboardMenu);

        ComponentContainer content = new CssLayout();
        content.addStyleName("view-content");
        content.setSizeFull();
        addComponent(content);
        setExpandRatio(content, 1.0f);
        dashboardNavigator = new DashboardNavigator(content);
        dashboardNavigator.addProvider(viewProvider);
        dashboardNavigator.navigateTo("dashboard");
    }

}

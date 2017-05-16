package com.naoset.framework.frontend.view.widgets;

import com.naoset.framework.frontend.event.WidgetsEventBus;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author Ezequiel
 */
@CDIView(supportsParameters = true)
public abstract class Widget extends VerticalLayout implements View {

    @Inject
    protected WidgetsEventBus eventBus;
    protected String parameters;
    HorizontalLayout header;
    Component body;

    MenuBar tools;

    @PostConstruct
    protected void init()
    {
        setCaption(caption());

        header = buildHeader();
        addComponent(header);
        header.setSizeUndefined();

        body = buildContent();
        addComponent(body);
        setExpandRatio(body, 1);

        eventBus.register(this);
    }

    @Override
    public void detach()
    {
        super.detach();
        // A new instance of TransactionsView is created every time it's
        // navigated to so we'll need to clean up references to it on detach.
        //        eventBus.unregister(this);
    }

    @Override
    public void enter(final ViewChangeListener.ViewChangeEvent event)
    {
        parameters = event.getParameters();
    }

    protected abstract Component buildContent();

    protected abstract String caption();
    
    public Boolean isModified(){
        return false;
    }

    protected void addMenuItems(MenuBar.MenuItem... menuItems)
    {
        header.setVisible(true);

        for (MenuBar.MenuItem menuItem : menuItems) {
            MenuBar.MenuItem mi = tools.addItem(menuItem.getText(), menuItem.getIcon(), menuItem.getCommand());
            if (menuItem.isCheckable()) {
                mi.setCheckable(true);
                mi.setChecked(menuItem.isChecked());
            }
        }
    }

    ;
    
     private HorizontalLayout buildHeader()
    {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(true);
        Responsive.makeResponsive(layout);

        HorizontalLayout toolbar = new HorizontalLayout();
        toolbar.setWidth("100%");
        tools = new MenuBar();
        tools.addStyleName(ValoTheme.MENUBAR_BORDERLESS);
        toolbar.addComponents(tools);

        layout.addComponents(toolbar);
        layout.setExpandRatio(toolbar, 1);
        layout.setVisible(false);

        return layout;
    }

    public HorizontalLayout getHeader()
    {
        return header;
    }

}

package com.naoset.framework.frontend;

import java.util.Locale;

import com.google.common.eventbus.Subscribe;
import com.naoset.framework.business.service.user.UserService;
import com.naoset.framework.domain.config.ConfigProvider;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.terralcode.framework.domain.profile.User;
import com.naoset.framework.frontend.event.DashboardEvent.BrowserResizeEvent;
import com.naoset.framework.frontend.event.DashboardEvent.CloseOpenWindowsEvent;
import com.naoset.framework.frontend.event.DashboardEvent.UserLoggedOutEvent;
import com.naoset.framework.frontend.event.DashboardEvent.UserLoginRequestedEvent;
import com.naoset.framework.frontend.event.WidgetsEventBus;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.Page.BrowserWindowResizeEvent;
import com.vaadin.server.Page.BrowserWindowResizeListener;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

@Theme("dashboard")
//@Widgetset("com.terralcode.trace.frontend.DashboardWidgetSet")
@Title("Gestion Alumnos")
@SuppressWarnings("serial")
@CDIUI("")
public final class DashboardUI extends UI {

    @Inject
    UserService userService;
    @Inject
    WidgetsEventBus eventBus;
    @Inject
    CDIViewProvider viewProvider;
    @Inject
    ConfigProvider configProvider;
    Navigator navigator;

    @Override
    protected void init(final VaadinRequest request)
    {
        Page.getCurrent().setTitle(configProvider.getProductName());
        setLocale(Locale.US);
        eventBus.register(this);
        Responsive.makeResponsive(this);
        updateContent();

        // Some views need to be aware of browser resize events so a
        // BrowserResizeEvent gets fired to the event but on every occasion.
        Page.getCurrent().addBrowserWindowResizeListener(new BrowserWindowResizeListener() {
            @Override
            public void browserWindowResized(
                    final BrowserWindowResizeEvent event)
            {
                eventBus.post(new BrowserResizeEvent());
            }
        });
    }

    /**
     * Updates the correct content for this UI based on the current user status.
     * If the user is logged in with appropriate privileges, main view is shown.
     * Otherwise login view is shown.
     */
    private void updateContent()
    {
        if (navigator == null) {
            navigator = new Navigator(this, this);
            navigator.addProvider(viewProvider);
        }
        User user = (User) VaadinSession.getCurrent().getAttribute(
                User.class.getName());
        if (user != null) {
            // Authenticated user           
            removeStyleName("loginview");
            navigator.navigateTo("main");
        } else {
            navigator.navigateTo("login");
            addStyleName("loginview");
        }
    }

    @Subscribe
    public void userLoginRequested(final UserLoginRequestedEvent event)
    {
        try {
            User user = userService.authenticate(
                    event.getUserName(),
                    event.getPassword());

            if (user != null) {
                VaadinSession.getCurrent().setAttribute(
                        User.class.getName(),
                        user);
                updateContent();
            } else {
                Notification.show("No se ha podido conectar con la BD", Notification.Type.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            Notification.show("No se ha podido conectar con ese usuario y contraseña", Notification.Type.ERROR_MESSAGE);
        }

    }

    @Subscribe
    public void userLoggedOut(final UserLoggedOutEvent event)
    {
        // When the user logs out, current VaadinSession gets closed and the
        // page gets reloaded on the login screen. Do notice the this doesn't
        // invalidate the current HttpSession.
        VaadinSession.getCurrent().close();
        Page.getCurrent().reload();
    }

    @Subscribe
    public void closeOpenWindows(final CloseOpenWindowsEvent event)
    {
        for (Window window : getWindows()) {
            window.close();
        }
    }
}

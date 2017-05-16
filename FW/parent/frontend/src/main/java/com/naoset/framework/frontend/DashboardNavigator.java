package com.naoset.framework.frontend;

import org.vaadin.googleanalytics.tracking.GoogleAnalyticsTracker;

import com.naoset.framework.frontend.event.DashboardEvent.BrowserResizeEvent;
import com.naoset.framework.frontend.event.DashboardEvent.CloseOpenWindowsEvent;
import com.naoset.framework.frontend.event.DashboardEvent.PostViewChangeEvent;
import com.naoset.framework.frontend.event.WidgetsEventBus;
import com.vaadin.cdi.UIScoped;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@UIScoped
public class DashboardNavigator extends Navigator {

    WidgetsEventBus eventBus;
    // Provide a Google Analytics tracker id here
    private static final String TRACKER_ID = null;// "UA-658457-6";
    private GoogleAnalyticsTracker tracker;
   
    public DashboardNavigator(final ComponentContainer container)
    {
        super(UI.getCurrent(), container);
        eventBus = ((DashboardUI) UI.getCurrent()).eventBus;
        if (TRACKER_ID != null) {
            initGATracker(TRACKER_ID);
        }
        initViewChangeListener();
//        initViewProviders();

    }

    private void initGATracker(final String trackerId)
    {
        tracker = new GoogleAnalyticsTracker(trackerId, "none");

        // GoogleAnalyticsTracker is an extension add-on for UI so it is
        // initialized by calling .extend(UI)
        tracker.extend(UI.getCurrent());
    }

    private void initViewChangeListener()
    {
        addViewChangeListener(new ViewChangeListener() {

            @Override
            public boolean beforeViewChange(final ViewChangeEvent event)
            {
                // Since there's no conditions in switching between the views
                // we can always return true.
                return true;
            }

            @Override
            public void afterViewChange(final ViewChangeEvent event)
            {
                // Appropriate events get fired after the view is changed.
                eventBus.post(new PostViewChangeEvent(event.getNewView()));
                eventBus.post(new BrowserResizeEvent());
                eventBus.post(new CloseOpenWindowsEvent());

                if (tracker != null) {
                    // The view change is submitted as a pageview for GA tracker
                    tracker.trackPageview("/dashboard/" + event.getViewName());
                }
            }
        });
    }   
}

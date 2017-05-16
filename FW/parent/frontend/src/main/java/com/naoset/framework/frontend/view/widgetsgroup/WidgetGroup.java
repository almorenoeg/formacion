package com.naoset.framework.frontend.view.widgetsgroup;

import java.util.Collection;
import java.util.Iterator;

import com.google.common.eventbus.Subscribe;
import com.naoset.framework.business.notification.NotificationService;
import com.naoset.framework.business.notification.email.EmailService;
import com.naoset.framework.frontend.data.DataProvider;
import com.terralcode.framework.domain.notification.Notification;
import com.terralcode.framework.domain.profile.User;
import com.naoset.framework.frontend.event.DashboardEvent.CloseOpenWindowsEvent;
import com.naoset.framework.frontend.event.DashboardEvent.NotificationsCountUpdatedEvent;
import com.naoset.framework.frontend.event.WidgetsEventBus;
import com.vaadin.cdi.CDIUIProvider;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@SuppressWarnings("serial")
public class WidgetGroup extends Panel implements View,
                                                  WidgetsEdit.WidgetsEditListener {

    public static final String EDIT_ID = "dashboard-edit";
    public static final String TITLE_ID = "dashboard-title";

    @Inject
    NotificationService notificationService;
    @Inject
    WidgetsEventBus eventBus;
    @Inject
    DataProvider dataProvider;
//    @Inject
//    EmailService emailService;

    private Label titleLabel;
    private NotificationsButton notificationsButton;
    private CssLayout widgetsPanels;
    private VerticalLayout root;
    private Window notificationsWindow;

    @PostConstruct
    void init()
    {
        addStyleName(ValoTheme.PANEL_BORDERLESS);
        setSizeFull();
        eventBus.register(this);

        root = new VerticalLayout();
        root.setSizeFull();
        root.setMargin(true);
        root.addStyleName("dashboard-view");
        setContent(root);
        Responsive.makeResponsive(root);

        root.addComponent(buildHeader());

        Component content = buildContent();
        root.addComponent(content);
        root.setExpandRatio(content, 1);

        // All the open sub-windows should be closed whenever the root layout
        // gets clicked.
        root.addLayoutClickListener(new LayoutClickListener() {
            @Override
            public void layoutClick(final LayoutClickEvent event)
            {
                eventBus.post(new CloseOpenWindowsEvent());
            }
        });
    }

    public void setTitle(String title)
    {
        titleLabel.setValue(title);
    }

    public void addWidgetPanel(Component component)
    {
        widgetsPanels.addComponent(createContentWrapper(component));
    }

    public void addWidgetPanel(Component component, String styleName)
    {
        widgetsPanels.addComponent(createContentWrapper(component, styleName));
    }

    private Component buildHeader()
    {
        HorizontalLayout header = new HorizontalLayout();
        header.addStyleName("viewheader");
        header.setSpacing(true);

        titleLabel = new Label("Título");
        titleLabel.setId(TITLE_ID);
        titleLabel.setSizeUndefined();
        titleLabel.addStyleName(ValoTheme.LABEL_H1);
        titleLabel.addStyleName(ValoTheme.LABEL_NO_MARGIN);
        header.addComponent(titleLabel);

        notificationsButton = buildNotificationsButton();
        Component edit = buildEditButton();
        HorizontalLayout tools = new HorizontalLayout(notificationsButton);
        tools.setSpacing(true);
        tools.addStyleName("toolbar");
        header.addComponent(tools);

        return header;
    }

    private NotificationsButton buildNotificationsButton()
    {
        NotificationsButton result = new NotificationsButton();
        result.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(final ClickEvent event)
            {
                openNotificationsPopup(event);
            }
        });
        return result;
    }

    private Component buildEditButton()
    {
        Button result = new Button();
        result.setId(EDIT_ID);
        result.setIcon(FontAwesome.EDIT);
        result.addStyleName("icon-edit");
        result.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        result.setDescription("Editar Panel de Control");
        result.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(final ClickEvent event)
            {
                getUI().addWindow(new WidgetsEdit(WidgetGroup.this, titleLabel
                                                  .getValue()));
            }
        });
        return result;
    }

    private Component buildContent()
    {
        widgetsPanels = new CssLayout();
        widgetsPanels.addStyleName("dashboard-panels");
        Responsive.makeResponsive(widgetsPanels);

        return widgetsPanels;
    }

    private Component createContentWrapper(final Component content)
    {
        return createContentWrapper(content, "dashboard-panel-slot");
    }

    private Component createContentWrapper(final Component content, String styleName)
    {
        final CssLayout slot = new CssLayout();
        slot.setWidth("100%");
        slot.addStyleName(styleName);

        CssLayout card = new CssLayout();
        card.setWidth("100%");
        card.addStyleName(ValoTheme.LAYOUT_CARD);

        HorizontalLayout toolbar = new HorizontalLayout();
        toolbar.addStyleName("dashboard-panel-toolbar");
        toolbar.setWidth("100%");

        Label caption = new Label(content.getCaption());
        caption.addStyleName(ValoTheme.LABEL_H4);
        caption.addStyleName(ValoTheme.LABEL_COLORED);
        caption.addStyleName(ValoTheme.LABEL_NO_MARGIN);
        content.setCaption(null);

        MenuBar tools = new MenuBar();
        tools.addStyleName(ValoTheme.MENUBAR_BORDERLESS);
        MenuItem max = tools.addItem("", FontAwesome.EXPAND, new Command() {

            @Override
            public void menuSelected(final MenuItem selectedItem)
            {
                if (!slot.getStyleName().contains("max")) {
                    selectedItem.setIcon(FontAwesome.COMPRESS);
                    toggleMaximized(slot, true);
                } else {
                    slot.removeStyleName("max");
                    selectedItem.setIcon(FontAwesome.EXPAND);
                    toggleMaximized(slot, false);
                }
            }
        });
        max.setStyleName("icon-only");
        MenuItem root = tools.addItem("", FontAwesome.BARS, null);
        root.setStyleName("icon-only");
        root.addItem("Configurar", new Command() {
            @Override
            public void menuSelected(final MenuItem selectedItem)
            {
                com.vaadin.ui.Notification.show("No implementado en esta demo");
            }
        });
        root.addSeparator();
        root.addItem("Cerrar", new Command() {
            @Override
            public void menuSelected(final MenuItem selectedItem)
            {
                com.vaadin.ui.Notification.show("No implementado en esta demo");
            }
        });

        toolbar.addComponents(caption, tools);
        toolbar.setExpandRatio(caption, 1);
        toolbar.setComponentAlignment(caption, Alignment.MIDDLE_LEFT);
        content.setSizeFull();
        card.addComponents(toolbar, content);
        slot.addComponent(card);
        return slot;
    }

    private void openNotificationsPopup(final ClickEvent event)
    {
        VerticalLayout notificationsLayout = new VerticalLayout();
        notificationsLayout.setMargin(true);
        notificationsLayout.setSpacing(true);

        Label title = new Label("Notificaciones");
        title.addStyleName(ValoTheme.LABEL_H3);
        title.addStyleName(ValoTheme.LABEL_NO_MARGIN);
        notificationsLayout.addComponent(title);

        Collection<Notification> notifications = notificationService.getNotifications((User) VaadinSession.getCurrent().getAttribute(User.class.getName()));
        eventBus.post(new NotificationsCountUpdatedEvent());
        VerticalLayout body = new VerticalLayout();
        for (Notification notification : notifications) {
            VerticalLayout notificationLayout = new VerticalLayout();
            notificationLayout.addStyleName("notification-item");
             Label titleLabel = new Label(Optional.ofNullable(notification.getFirstName()).orElse("") + " "
                                         + Optional.ofNullable(notification.getLastName()).orElse("") + " "
                                         + notification.getAction());
            titleLabel.addStyleName("notification-title");

            Label timeLabel = new Label(notification.getPrettyTime());
            timeLabel.addStyleName("notification-time");

            Label contentLabel = new Label(notification.getContent());
            contentLabel.addStyleName("notification-content");

            Button goTo = new Button("Ir a la cita", new ClickListener() {
                @Override
                public void buttonClick(ClickEvent event)
                {
                    getUI().getNavigator().navigateTo(notification.getUrl());
                    notificationsWindow.close();
                }
            });
            Button discardButton = new Button("Descartar", new ClickListener() {
                @Override
                public void buttonClick(ClickEvent event)
                {
                    notification.setRead(Boolean.TRUE);
                    notificationService.edit(notification);
                    body.removeComponent(notificationLayout);
                    eventBus.post(new NotificationsCountUpdatedEvent());
                }
            });
            notificationLayout.addComponents(new Label("<hr />",ContentMode.HTML),titleLabel, timeLabel,
                                             contentLabel, goTo, discardButton);
            body.addComponent(notificationLayout);
        }
        notificationsLayout.addComponent(body);

        HorizontalLayout footer = new HorizontalLayout();
        footer.addStyleName(ValoTheme.WINDOW_BOTTOM_TOOLBAR);
        footer.setWidth("100%");
        Button showAll = new Button("Descartar todas las notificaciones",
                                    new ClickListener() {
                                        @Override
                                        public void buttonClick(final ClickEvent event)
                                        {
                                            for (Notification notification : notifications) {
                                                notification.setRead(Boolean.TRUE);
                                                notificationService.edit(notification);
                                            }
                                            body.removeAllComponents();
                                            eventBus.post(new NotificationsCountUpdatedEvent());
                                            notificationsWindow.close();
                                        }
                                    });
        showAll.addStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        showAll.addStyleName(ValoTheme.BUTTON_SMALL);
        footer.addComponent(showAll);
        footer.setComponentAlignment(showAll, Alignment.TOP_CENTER);
        notificationsLayout.addComponent(footer);

        if (notificationsWindow == null) {
            notificationsWindow = new Window();
            notificationsWindow.setWidth(300.0f, Unit.PIXELS);
            notificationsWindow.addStyleName("notifications");
            notificationsWindow.setClosable(false);
            notificationsWindow.setResizable(false);
            notificationsWindow.setDraggable(false);
            notificationsWindow.setCloseShortcut(KeyCode.ESCAPE, null);
        }
        notificationsWindow.setContent(notificationsLayout);

        if (!notificationsWindow.isAttached()) {
            notificationsWindow.setPositionY(event.getClientY()
                                             - event.getRelativeY() + 40);
            getUI().addWindow(notificationsWindow);
            notificationsWindow.focus();
        } else {
            notificationsWindow.close();
        }
    }

    @Override
    public void enter(final ViewChangeEvent event)
    {
        notificationsButton.updateNotificationsCount(null);
    }

    @Override
    public void widgetNameEdited(final String name)
    {
        titleLabel.setValue(name);
    }

    protected void toggleMaximized(final Component panel, final boolean maximized)
    {
        for (Iterator<Component> it = root.iterator(); it.hasNext();) {
            it.next().setVisible(!maximized);
        }
        widgetsPanels.setVisible(true);

        for (Iterator<Component> it = widgetsPanels.iterator(); it.hasNext();) {
            Component c = it.next();
            c.setVisible(!maximized);
        }

        if (maximized) {
            panel.setVisible(true);
            panel.addStyleName("max");
        } else {
            panel.removeStyleName("max");
        }
        
        //Este sería el sitio correcto para poner/quitar el margen a root,
        //de forma que un widget maximizado ocupe todo el espacio posible.
        //root.setMargin(!maximized);
        //Lamentablemente hay que hacerlo mediante estilos...
        //¿Quizá aislar los márgenes del estilo 'dashboard-view' en un estilo 
        //nuevo y aquí añadirlo o quitarlo?
    }

    public final class NotificationsButton extends Button {

        private static final String STYLE_UNREAD = "unread";
        public static final String ID = "dashboard-notifications";

        public NotificationsButton()
        {
            setIcon(FontAwesome.BELL);
            setId(ID);
            addStyleName("notifications");
            addStyleName(ValoTheme.BUTTON_ICON_ONLY);
            eventBus.register(this);
        }

        @Subscribe
        public void updateNotificationsCount(
                final NotificationsCountUpdatedEvent event)
        {
            setUnreadCount(notificationService.getUnreadNotifications((User) VaadinSession.getCurrent().getAttribute(User.class.getName())).size());
        }

        public void setUnreadCount(final int count)
        {
            setCaption(String.valueOf(count));

            String description = "Notificaciones";
            if (count > 0) {
                addStyleName(STYLE_UNREAD);
                description += " (" + count + " sin leer)";
            } else {
                removeStyleName(STYLE_UNREAD);
            }
            setDescription(description);
        }
    }

}

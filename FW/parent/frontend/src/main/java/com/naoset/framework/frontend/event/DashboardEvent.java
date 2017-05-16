package com.naoset.framework.frontend.event;


import com.naoset.framework.domain.company.relationship.customer.Customer;
import com.vaadin.navigator.View;

/*
 * Event bus events used in Dashboard are listed here as inner classes.
 */
public abstract class DashboardEvent {

    public static final class UserLoginRequestedEvent {
        private final String userName, password;

        public UserLoginRequestedEvent(final String userName,
                final String password) {
            this.userName = userName;
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class BrowserResizeEvent {

    }

    public static class UserLoggedOutEvent {

    }

    public static class NotificationsCountUpdatedEvent {
    }

    public static final class ReportsCountUpdatedEvent {
        private final int count;

        public ReportsCountUpdatedEvent(final int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

    }

    public static final class PostViewChangeEvent {
        private final View view;

        public PostViewChangeEvent(final View view) {
            this.view = view;
        }

        public View getView() {
            return view;
        }
    }

    public static class CloseOpenWindowsEvent {
    }

    public static class ProfileUpdatedEvent {
    }

    
    public static final class CustomerEvent {
        private Object customer;
        private Boolean reload;
        
        public CustomerEvent(Object customer) {
            this.customer = customer;
        }
        
        public CustomerEvent(Boolean reload) {
            this.reload = reload;
        }

        public Object getCustomer() {
            return customer;
        }
        
        public Boolean reloadCustomersTable() {
            return reload;
        }
    }
    
    
}

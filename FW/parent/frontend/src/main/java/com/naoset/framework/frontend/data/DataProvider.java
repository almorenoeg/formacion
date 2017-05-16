package com.naoset.framework.frontend.data;

import com.naoset.framework.domain.company.relationship.customer.Customer;
import java.util.Collection;
import java.util.Date;

import com.terralcode.framework.domain.notification.Notification;
import com.terralcode.framework.domain.profile.User;

/**
 * QuickTickets Dashboard backend API.
 */
public interface DataProvider {

    /**
     * @param userName
     * @param password
     * @return Authenticated used.
     */
    User authenticate(String userName, String password);

    /**
     * @return The number of unread notifications for the current user.
     */
    int getUnreadNotificationsCount();

    /**
     * @return Notifications for the current user.
     */
    Collection<Notification> getNotifications();

    Collection<Customer> getCustomers();

}

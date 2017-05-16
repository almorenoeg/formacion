package com.naoset.framework.frontend.data.dummy;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Multimap;
import com.terralcode.framework.domain.commons.contactinfo.ContactInfo;
import com.terralcode.framework.domain.commons.contactinfo.ContactType;
import com.terralcode.framework.domain.commons.contactinfo.address.PlainAddress;
import com.naoset.framework.domain.company.relationship.customer.Customer;
import com.naoset.framework.frontend.data.DataProvider;
import com.terralcode.framework.domain.notification.Notification;
import com.terralcode.framework.domain.profile.User;
import javax.enterprise.inject.Default;

/**
 * A dummy implementation for the backend API.
 */
@Default
public class DummyDataProvider implements DataProvider {

    private static Date lastDataUpdate;

    private static Random rand = new Random();

    private final Collection<Notification> notifications = DummyDataGenerator
            .randomNotifications();

    /**
     * Initialize the data for this application.
     */
    public DummyDataProvider()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);
        if (lastDataUpdate == null || lastDataUpdate.before(cal.getTime())) {
            lastDataUpdate = new Date();
        }
    }


    @Override
    public User authenticate(String userName, String password)
    {
        User user = new User();
        user.setFirstName(DummyDataGenerator.randomFirstName());
        user.setLastName(DummyDataGenerator.randomLastName());
//        user.setRole("admin");
        String email = user.getFirstName().toLowerCase() + "."
                       + user.getLastName().toLowerCase() + "@"
                       + DummyDataGenerator.randomCompanyName().toLowerCase() + ".com";
        user.setEmail(email.replaceAll(" ", ""));
//        user.setLocation(DummyDataGenerator.randomWord(5, true));
//        user.setBio("Quis aute iure reprehenderit in voluptate velit esse."
//                    + "Cras mattis iudicium purus sit amet fermentum.");
        return user;
    }


    @Override
    public int getUnreadNotificationsCount()
    {
        Predicate<Notification> unreadPredicate = new Predicate<Notification>() {
            @Override
            public boolean apply(Notification input)
            {
                return !input.getRead();
            }
        };
        return Collections2.filter(notifications, unreadPredicate).size();
    }

    @Override
    public Collection<Notification> getNotifications()
    {
        for (Notification notification : notifications) {
            notification.setRead(true);
        }
        return Collections.unmodifiableCollection(notifications);
    }

    @Override
    public Collection<Customer> getCustomers()
    {
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Customer customer = new Customer();
            customer.setId(Long.valueOf(i));
            customer.setName(DummyDataGenerator.randomCompanyName());
            PlainAddress address = new PlainAddress();
            address.setAddressLine1(DummyDataGenerator.randomText(4));
            List<PlainAddress> addressList = new ArrayList<>();
            addressList.add(address);
            //customer.setAddressList(addressList);//.setAddress(address);
            ContactInfo contactInfo = new ContactInfo();
            contactInfo.setContactType(ContactType.Telephone);
            contactInfo.setInfo(DummyDataGenerator.randomName());
            customers.add(customer);
        }
        return customers;
    }

}

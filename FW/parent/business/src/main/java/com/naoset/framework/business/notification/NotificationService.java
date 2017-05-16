package com.naoset.framework.business.notification;

import com.naoset.framework.business.commons.crud.CRUD;
import com.terralcode.framework.domain.notification.Notification;
import com.terralcode.framework.domain.profile.User;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author Ezequiel
 */
@Stateless
public class NotificationService extends CRUD<Notification> {

    public List<Notification> getNotifications(User user)
    {
        String sentece = "SELECT notification FROM Notification notification WHERE notification.user = :user AND notification.internal = :internal AND notification.read = :read AND notification.sentTime <= :now";
        Query query = getEntityManager().createQuery(sentece);
        query.setParameter("user", user);
        query.setParameter("internal", true);
        query.setParameter("read", false);
        query.setParameter("now", Calendar.getInstance(), TemporalType.TIMESTAMP);
        return query.getResultList();
    }

    public List<Notification> getUnreadNotifications(User user)
    {
        String sentece = "SELECT notification FROM Notification notification WHERE notification.user = :user AND notification.internal = :internal AND notification.read = :read AND notification.sentTime <= :now";
        Query query = getEntityManager().createQuery(sentece);
        query.setParameter("user", user);
        query.setParameter("internal", true);
        query.setParameter("read", false);
        query.setParameter("now", Calendar.getInstance(), TemporalType.TIMESTAMP);
        return query.getResultList();
    }

    public List<Notification> getUnsentEmailNotifications()
    {
        String sentece = "SELECT notification FROM Notification notification "
                + "WHERE notification.sendEmail = :sendEmail AND notification.emailSent = :emailSent "
                + "AND notification.sentTime <= :now";
        Query query = getEntityManager().createQuery(sentece);
        query.setParameter("sendEmail", true);
        query.setParameter("emailSent", false);
        query.setParameter("now", Calendar.getInstance(), TemporalType.TIMESTAMP);
        return query.getResultList();

    }
    
}

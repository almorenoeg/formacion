package com.terralcode.framework.domain.notification;

import com.terralcode.framework.domain.DomainEntity;
import com.terralcode.framework.domain.profile.User;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Notification extends DomainEntity {

    private String content;
    private String firstName;
    private String lastName;
    private String prettyTime;
    private String action;
    private User user;
    private Boolean internal;
    private Boolean read;
    private Boolean sendEmail;
    private Boolean emailSent;
    private Calendar sentTime;
    private String url;

    public Notification()
    {
        super();
        this.sentTime = Calendar.getInstance();
        this.internal = true;
        this.read = false;
        this.sendEmail = false;
        this.emailSent = false;
    }

    @Column(length = 10240)
    public String getContent()
    {
        return content;
    }

    public void setContent(final String content)
    {
        this.content = content;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(final String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(final String lastName)
    {
        this.lastName = lastName;
    }

    public String getPrettyTime()
    {
        return prettyTime;
    }

    public void setPrettyTime(final String prettyTime)
    {
        this.prettyTime = prettyTime;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(final String action)
    {
        this.action = action;
    }

    @ManyToOne
    @Column(name = "User")
    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    /**
     * @return the internal
     */
    public Boolean getInternal()
    {
        return internal;
    }

    /**
     * @param internal the internal to set
     */
    public void setInternal(Boolean internal)
    {
        this.internal = internal;
    }

    /**
     * @return the read
     */
    public Boolean getRead()
    {
        return read;
    }

    /**
     * @param read the read to set
     */
    public void setRead(Boolean read)
    {
        this.read = read;
    }

    /**
     * @return the emailSent
     */
    public Boolean getEmailSent()
    {
        return emailSent;
    }

    /**
     * @param emailSent the emailSent to set
     */
    public void setEmailSent(Boolean emailSent)
    {
        this.emailSent = emailSent;
    }

    /**
     * @return the sentTime
     */
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar getSentTime()
    {
        return sentTime;
    }

    /**
     * @param sentTime the sentTime to set
     */
    public void setSentTime(Calendar sentTime)
    {
        this.sentTime = sentTime;
    }

    /**
     * @return the sendEmail
     */
    public Boolean getSendEmail()
    {
        return sendEmail;
    }

    /**
     * @param sendEmail the sendEmail to set
     */
    public void setSendEmail(Boolean sendEmail)
    {
        this.sendEmail = sendEmail;
    }

    /**
     * @return the url
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url)
    {
        this.url = url;
    }

}

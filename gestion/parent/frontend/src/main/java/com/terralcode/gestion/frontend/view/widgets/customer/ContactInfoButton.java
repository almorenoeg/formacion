package com.terralcode.gestion.frontend.view.widgets.customer;

import com.terralcode.framework.domain.commons.contactinfo.ContactInfo;
import com.terralcode.framework.domain.commons.contactinfo.address.PlainAddress;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author jmsuarez
 */
public class ContactInfoButton extends Button{
    protected ContactInfo contact;
    
    public ContactInfoButton() {
        super();
        this.addStyleName(ValoTheme.BUTTON_LINK);
    }

    public ContactInfoButton(ContactInfo contact) {
        super(contact.toString());
        addStyleName(ValoTheme.BUTTON_LINK);
        this.contact = contact;
    }

    public ContactInfo getContact() {
        return contact;
    }

    public void setContact(ContactInfo contact) {
        this.contact = contact;
    }
}

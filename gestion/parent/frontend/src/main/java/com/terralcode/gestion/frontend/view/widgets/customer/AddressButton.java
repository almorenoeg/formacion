package com.terralcode.gestion.frontend.view.widgets.customer;

import com.terralcode.framework.domain.commons.contactinfo.address.PlainAddress;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author jmsuarez
 */
public class AddressButton extends Button{
    protected PlainAddress address;
    
    public AddressButton() {
        super();
        this.addStyleName(ValoTheme.BUTTON_LINK);
    }

    public AddressButton(PlainAddress address) {
        super(address.toString());
        addStyleName(ValoTheme.BUTTON_LINK);
        this.address = address;
    }

    public PlainAddress getAddress() {
        return address;
    }

    public void setAddress(PlainAddress address) {
        this.address = address;
    }
}

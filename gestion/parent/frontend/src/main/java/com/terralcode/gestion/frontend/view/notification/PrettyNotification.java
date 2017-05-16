/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.frontend.view.notification;

import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;

/**
 *
 * @author jmsuarez
 */
public class PrettyNotification extends Notification{

    public PrettyNotification(String caption) {
        super(caption);
        
        setDelayMsec(2000);
        setStyleName("bar success small");
        setPosition(Position.BOTTOM_CENTER);
    }
    
}

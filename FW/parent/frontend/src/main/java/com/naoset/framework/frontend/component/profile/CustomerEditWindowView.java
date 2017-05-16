/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naoset.framework.frontend.component.profile;

import com.naoset.framework.domain.company.relationship.customer.Customer;
import static com.naoset.framework.frontend.component.profile.ProfilePreferencesWindow.ID;
import com.naoset.framework.frontend.view.widgets.Widget;
import com.vaadin.cdi.CDIUI;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
/**
 *
 * @author almoreno
 */

@CDIUI
public class CustomerEditWindowView extends Widget {
    
//    @Inject
//    WidgetsEventBus eventBus;
  
    public CustomerEditWindowView() {
    }
    
    public CustomerEditWindowView(Customer customer) {
    }
    
   
    @Override
    protected Component buildContent() {
        addMenuItems(new MenuBar().new MenuItem("", FontAwesome.EDIT, edit()));
        return new Panel();
        
    }

    @Override
    protected String caption() {
        return "Llamada a la ventana de Customer";
    }
    
     private MenuBar.Command edit() {
        return new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem)
            {
                openWindow();
            }
        };
    }
     
     
     private void openWindow() {
         Window myWindow = new Window("Cliente");
           myWindow.addStyleName("profile-window");
           myWindow.setId(ID);
           Responsive.makeResponsive(this);

           myWindow.setModal(true);
           myWindow.setCloseShortcut(ShortcutAction.KeyCode.ESCAPE, null);
           myWindow.setResizable(false);
           myWindow.setClosable(false);
           myWindow.setHeight(90.0f, Unit.PERCENTAGE);
           VerticalLayout layout = new VerticalLayout();
           CustomerPanelView customerPanelView = new CustomerPanelView();
           
           
           layout.addComponent(customerPanelView.buildCustomerPanel(null));
           layout.addComponent(builtButton());
           
           myWindow.setContent(layout);
           myWindow.setVisible(true);
           UI.getCurrent().addWindow(myWindow);
           myWindow.focus();
     }
     
     
     private Component builtButton() {
        
         HorizontalLayout hLayout = new HorizontalLayout();
         
         Button bSave = new Button("Guardar");
         Button bCancel = new Button("Cancelar");
         
         bSave.addStyleName(ValoTheme.BUTTON_PRIMARY);
         bSave.addClickListener(new Button.ClickListener() {

             @Override
             public void buttonClick(Button.ClickEvent event) {
                 
             }
         });
         
         hLayout.addComponent(bSave);
         hLayout.addComponent(bCancel);
         
        return hLayout;
     }
}

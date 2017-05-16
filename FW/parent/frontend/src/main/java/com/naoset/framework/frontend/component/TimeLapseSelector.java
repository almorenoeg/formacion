/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naoset.framework.frontend.component;

import com.naoset.framework.domain.commons.timing.TimeLapse;
import com.naoset.framework.domain.commons.timing.TimeLapseCalculator;
import com.naoset.framework.frontend.data.converters.SetToListConverter;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author jmsuarez
 */
public class TimeLapseSelector extends TabSheet {

    private TimeLapse selectedLapse;
    BeanItem beanItem;
//    BeanFieldGroup fieldGroup;
    Tab minuteTab;
    Tab hourTab;
    Tab dayTab;
    Tab weekTab;
    Tab monthTab;
    BeanFieldGroup minuteFieldGroup;
    BeanFieldGroup hourFieldGroup;
    BeanFieldGroup dayFieldGroup;
    BeanFieldGroup weekFieldGroup;
    BeanFieldGroup monthFieldGroup;

    public TimeLapse getSelectedLapse() {
        return selectedLapse;
    }

    public void setSelectedLapse(TimeLapse selectedLapse) {
        this.selectedLapse = selectedLapse;
    }

    public TimeLapseSelector(TimeLapseCalculator tlc) {
        super();
        
        beanItem = new BeanItem<>(this);
        minuteFieldGroup = new BeanFieldGroup<>(TimeLapseSelector.class);
        minuteFieldGroup.setItemDataSource(beanItem);
        hourFieldGroup = new BeanFieldGroup<>(TimeLapseSelector.class);
        hourFieldGroup.setItemDataSource(beanItem);
        dayFieldGroup = new BeanFieldGroup<>(TimeLapseSelector.class);
        dayFieldGroup.setItemDataSource(beanItem);
        weekFieldGroup = new BeanFieldGroup<>(TimeLapseSelector.class);
        weekFieldGroup.setItemDataSource(beanItem);
        monthFieldGroup = new BeanFieldGroup<>(TimeLapseSelector.class);
        monthFieldGroup.setItemDataSource(beanItem);
        
        if (tlc.getMinuteLapses().size() > 0) {
            buildSelection(Calendar.MINUTE, tlc.getMinuteLapses());
        }
        if (tlc.getHourLapses().size() > 0) {
            buildSelection(Calendar.HOUR_OF_DAY, tlc.getHourLapses());
        }
        if (tlc.getDayLapses().size() > 0) {
            buildSelection(Calendar.DAY_OF_WEEK, tlc.getDayLapses());
        }
        if (tlc.getWeekLapses().size() > 0) {
            buildSelection(Calendar.WEEK_OF_MONTH, tlc.getWeekLapses());
        }
        if (tlc.getMonthLapses().size() > 0) {
            buildSelection(Calendar.MONTH, tlc.getMonthLapses());
        }
        
        this.addSelectedTabChangeListener(new SelectedTabChangeListener() {

            @Override
            public void selectedTabChange(SelectedTabChangeEvent event) {
               
            }
        });
    }

    private void buildSelection(int lapseType, List<TimeLapse> lapses) {
        VerticalLayout layout = new VerticalLayout();
        OptionGroup og = new OptionGroup();
        og.setConverter(new SetToListConverter());
        og.setImmediate(true);
        layout.addComponent(og);

        BeanItemContainer<TimeLapse> container = new BeanItemContainer<>(TimeLapse.class);
        container.addAll(lapses);
        og.setContainerDataSource(container);

//        BeanItem beanItem = new BeanItem<>(this);
        //BeanFieldGroup fieldGroup = new BeanFieldGroup<>(TimeLapseSelector.class);
        //fieldGroup.setItemDataSource(beanItem);
        //fieldGroup.bind(og, "selectedLapse");

        String tabName = "";
        switch (lapseType) {
            case Calendar.MINUTE:
                tabName = "Minutos";
                minuteFieldGroup.bind(og, "selectedLapse");
                minuteTab = this.addTab(layout, tabName);
                break;
            case Calendar.HOUR_OF_DAY:
                tabName = "Horas";
                hourFieldGroup.bind(og, "selectedLapse");
                hourTab = this.addTab(layout, tabName);
                break;
            case Calendar.DAY_OF_WEEK:
                tabName = "Días";
                dayFieldGroup.bind(og, "selectedLapse");
                dayTab = this.addTab(layout, tabName);
                break;
            case Calendar.WEEK_OF_MONTH:
                tabName = "Semanas";
                weekFieldGroup.bind(og, "selectedLapse");
                weekTab = this.addTab(layout, tabName);
                break;
            case Calendar.MONTH:
                tabName = "Meses";
                monthFieldGroup.bind(og, "selectedLapse");
                monthTab = this.addTab(layout, tabName);
                break;
        }
        //Tab newTab = this.addTab(layout, tabName);
        
    }

    

    
    
}

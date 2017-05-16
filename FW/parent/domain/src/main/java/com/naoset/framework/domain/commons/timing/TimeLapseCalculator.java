/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naoset.framework.domain.commons.timing;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author jmsuarez
 */
public class TimeLapseCalculator {
    protected List<TimeLapse> lapses;

    public TimeLapseCalculator() {
        lapses = new ArrayList<>();
    }

    public TimeLapseCalculator(List<TimeLapse> lapses) {
        this.lapses = lapses;
    }

    public List<TimeLapse> getLapses() {
        return lapses;
    }

    public void setLapses(List<TimeLapse> lapses) {
        this.lapses = lapses;
    }
    
    protected List<TimeLapse> getLapsesByType(int type) {
        List<TimeLapse> list = new ArrayList<>();
        for(TimeLapse tl: lapses){
            if (tl.getType() == type) {
                list.add(tl);
            }
        }
        return list;
    }
    
    public List<TimeLapse> getSecondLapses() {
        return getLapsesByType(Calendar.SECOND);
    }
    public List<TimeLapse> getMinuteLapses() {
        return getLapsesByType(Calendar.MINUTE);
    }
    public List<TimeLapse> getHourLapses() {
        return getLapsesByType(Calendar.HOUR_OF_DAY);
    }
    public List<TimeLapse> getDayLapses() {
        return getLapsesByType(Calendar.DAY_OF_WEEK);
    }
    public List<TimeLapse> getWeekLapses() {
        return getLapsesByType(Calendar.WEEK_OF_MONTH);
    }
    public List<TimeLapse> getMonthLapses() {
        return getLapsesByType(Calendar.MONTH);
    }
    
    public Calendar calculateLapse(Calendar start, TimeLapse tl){
        Calendar cal = Calendar.getInstance();
        cal.setTime(start.getTime());
        cal.add(tl.type, tl.value);
        return cal;
    }
}

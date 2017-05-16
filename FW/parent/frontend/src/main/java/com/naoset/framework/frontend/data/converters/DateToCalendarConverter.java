package com.naoset.framework.frontend.data.converters;

import com.vaadin.data.util.converter.Converter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author jmsuarez
 */
public class DateToCalendarConverter implements Converter<Date, Calendar> {

    @Override
    public Calendar convertToModel(Date value, Class<? extends Calendar> targetType, Locale locale) throws ConversionException {
        if (value == null) {
            return null;
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        Calendar cal = Calendar.getInstance(locale);
        cal.setTime(value);
        return cal;
    }

    @Override
    public Date convertToPresentation(Calendar value, Class<? extends Date> targetType, Locale locale) throws ConversionException {
        if (value == null) {
            return null;
        }
        return value.getTime();
    }

    @Override
    public Class<Calendar> getModelType() {
        return Calendar.class;
    }

    @Override
    public Class<Date> getPresentationType() {
        return Date.class;
    }
    
}

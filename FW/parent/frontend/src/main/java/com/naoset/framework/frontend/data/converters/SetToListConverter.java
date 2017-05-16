/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naoset.framework.frontend.data.converters;

import com.terralcode.framework.domain.DomainEntity;
import com.vaadin.data.util.converter.Converter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 *
 * @author jmsuarez
 */
public class SetToListConverter implements Converter<Object, List>{

    @Override
    public List convertToModel(Object value, Class<? extends List> targetType, Locale locale) throws ConversionException {
        Set<DomainEntity> pres = ((Set<DomainEntity>)value);
        List<DomainEntity> model = new ArrayList<DomainEntity>();
        pres.forEach(c -> model.add(c));
        return model;
    }

    @Override
    public Collection convertToPresentation(List value, Class<? extends Object> targetType, Locale locale) throws ConversionException {
        HashSet<DomainEntity> pres = new HashSet<DomainEntity>(value.size());
        value.forEach(c -> pres.add(((DomainEntity) c)));
        return pres;
    }

    @Override
    public Class<List> getModelType() {
        return List.class;
    }

    @Override
    public Class<Object> getPresentationType() {
        return Object.class;
    }
    
}
//public class SetToListConverter implements Converter<Set, List>{
//
//    @Override
//    public List convertToModel(Set value, Class<? extends List> targetType, Locale locale) throws ConversionException {
//        ArrayList lista;
//        lista = new ArrayList<>();
//        value.forEach(c -> lista.add(c));
//        return lista;
//    }
//
//    @Override
//    public Set convertToPresentation(List value, Class<? extends Set> targetType, Locale locale) throws ConversionException {
//        Set destino = new HashSet();
//        value.forEach(c -> destino.add(c));
//        return destino;
//    }
//
//    @Override
//    public Class<List> getModelType() {
//        return List.class;
//    }
//
//    @Override
//    public Class<Set> getPresentationType() {
//        return Set.class;
//    }
//    
//}

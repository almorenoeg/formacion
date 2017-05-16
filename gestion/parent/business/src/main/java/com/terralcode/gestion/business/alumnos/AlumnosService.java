/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.gestion.business.alumnos;

import com.naoset.framework.business.commons.crud.CRUD;
import com.terralcode.framework.domain.alumno.Alumno;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author almoreno
 */
@Stateless
public class AlumnosService extends CRUD<Alumno> {

    public List<Alumno> findByName(String nameSearch) {
        String jpql = "SELECT c "
                + "FROM Alumno c "
                + "where " 
                + "c.nombre LIKE :search "
                + "order by c.nombre";
        
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("search", "%" + nameSearch + "%");
        
        return query.getResultList();
    }
}

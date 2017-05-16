package com.terralcode.gestion.business.appointment;

import com.terralcode.gestion.domain.appointment.ComplaintType;
import com.naoset.framework.business.commons.crud.CRUD;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author almoreno
 */
@Stateless
public class ComplaintTypeService extends CRUD<ComplaintType> {
    
    /**
     * Find active ComplaintType by name 
     * @param name
     * @return 
     */
    public ComplaintType findByName(final String name) {
        String sentence = "SELECT complainttype  FROM ComplaintType complainttype "
                + "WHERE complainttype.name = :findName AND complainttype.active = 1";
        Query query = getEntityManager().createQuery(sentence);
        query.setParameter("findName", name);
        
        ComplaintType ret = (ComplaintType)query.getSingleResult();
        return ret;
    }
    
}

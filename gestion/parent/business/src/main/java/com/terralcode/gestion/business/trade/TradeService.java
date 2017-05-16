package com.terralcode.gestion.business.trade;

import com.terralcode.gestion.domain.trade.Trade;
import com.naoset.framework.business.commons.crud.CRUD;
import com.terralcode.framework.domain.profile.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author jmsuarez
 */
@Stateless
public class TradeService extends CRUD<Trade> {
    
    public Trade findTradeByUser(User user) {
        
        String sentence = "SELECT trade FROM Trade trade WHERE trade.user = :user";
        Query query = getEntityManager().createQuery(sentence);
        query.setParameter("user", user);
        
        List<Trade> trades = query.getResultList();
        if (trades.isEmpty()) {
            return null;
        } else  {
            return trades.get(0);
        }

    }
    
}

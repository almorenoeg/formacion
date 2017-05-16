package com.naoset.framework.business.commons.crud;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ezequiel
 */
public abstract class CRUD<T> {

    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    protected Class<T> getEntityClass() {
        return ((Class) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public T newEntity() {
        try {
            return getEntityClass().newInstance();
        } catch (Exception e) {
            return null;
        }
    }

//    public T create(T entity, Boolean trackLastUpdate) {
//        if (trackLastUpdate) {
//            ((DomainEntity)entity).setLastUpdate(Calendar.getInstance());
//        }
//        return getEntityManager().merge(entity);
//    }
    public T create(T entity) {
        return getEntityManager().merge(entity);
        //return this.create(entity, true);
    }

//    public T edit(T entity, Boolean trackLastUpdate) {
//        if (trackLastUpdate) {
//            ((DomainEntity)entity).setLastUpdate(Calendar.getInstance());
//        }
//        return getEntityManager().merge(entity);
//    }
    public T edit(T entity) {
        return getEntityManager().merge(entity);
        //return this.edit(entity, true);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(getEntityClass(), id);
    }
    
    protected T findBy(String field, String value){
        T returnValue = null;
        
        String hql = "from " + getEntityClass().getSimpleName() + " c where c." + field + " = :arg1";
        try {
            Query query = getEntityManager().createQuery(hql);
            query.setParameter("arg1", value);
            if (query.getResultList().size() > 0) {
                returnValue = (T)(query.getResultList().get(0));
            }
        } catch (Exception e) {
        }
        return returnValue;
    }

    public T findByCode(String code) {

        return findBy("code", code);
//        String hql = "from " + getEntityClass().getSimpleName() + " c where c.code = :arg1";
//        Query query = getEntityManager().createQuery(hql);
//        query.setParameter("arg1", code);
//        if (query.getResultList().size() > 0) {
//            return (T) (query.getResultList().get(0));
//        } else {
//            return null;
//        }
    }

    public T findByExternalId(String externalId) {

        return findBy("externalId", externalId);
//        String hql = "from " + getEntityClass().getSimpleName() + " c where c.externalId = :arg1";
//        Query query = getEntityManager().createQuery(hql);
//        query.setParameter("arg1", externalId);
//        if (query.getResultList().size() > 0) {
//            return (T) (query.getResultList().get(0));
//        } else {
//            return null;
//        }
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(getEntityClass()));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(getEntityClass()));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(getEntityClass());
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}

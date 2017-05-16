/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naoset.framework.business.service.user;

import com.naoset.framework.business.commons.crud.CRUD;
import com.terralcode.framework.domain.profile.User;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Almoreno
 */
@Stateless
public class UserService extends CRUD<User> {

    public User authenticate(String userEmail, String password) {
        User user;

        String sentece = "Select user From User user where user.email = :email AND user.password =:password";

        Query query = getEntityManager().createQuery(sentece);
        query.setParameter("email", userEmail);
        query.setParameter("password", password);
        user = (User) query.getSingleResult();

        return user;
    }

    public User findByEmail(String userEmail) {
        User user;
        String sentece = "Select user From User user where user.email = :email";

        Query query = getEntityManager().createQuery(sentece);
        query.setParameter("email", userEmail);
        user = (User) query.getSingleResult();

        return user;
    }

}

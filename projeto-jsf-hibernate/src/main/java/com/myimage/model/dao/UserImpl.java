/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myimage.model.dao;

import com.myimage.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yvonei
 */
public class UserImpl implements UserDao {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean existsValidation(String validation) {

        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("validation", validation));
        User user = (User) criteria.uniqueResult();

        if (user != null) {
            user.setActive(true);
            user.setValidation("");
            save(user);
            return true;
        }
        return false;
    }

    @Override
    public void save(User user) {
        session.saveOrUpdate(user);
    }

}

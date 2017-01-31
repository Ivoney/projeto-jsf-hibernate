/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myimage.business;
 
import com.myimage.dao.utils.DAOFactory;
 
import com.myimage.model.dao.UserDao;

/**
 *
 * @author Yvonei
 */
public final class UserBusiness {

    private UserDao userDao;

    public UserBusiness() {
        super();
        setUserDao(DAOFactory.createUser());
    }

    public boolean existsValidation(String validation) {
        return userDao.existsValidation(validation);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}

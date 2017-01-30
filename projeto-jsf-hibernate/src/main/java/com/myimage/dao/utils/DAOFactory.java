/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myimage.dao.utils;

import com.myimage.model.dao.ProfileDao;
import com.myimage.model.dao.ProfileDaoImpl;
import com.myimage.model.dao.UserDao;
import com.myimage.model.dao.UserImpl;

/**
 *
 * @author Yvonei
 */
//classe provedora de DAOS que disponibiliza métodos para cada DAO implementado
public class DAOFactory {

    //Método responsável por fornecer um objeto do ProfileDaoImpl que é retornado de forma polimórfica
    public static ProfileDao createProfile() {
        ProfileDaoImpl profileDaoImpl = new ProfileDaoImpl();
        profileDaoImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return profileDaoImpl;
    }

    public static UserDao createUser() {
        UserImpl userImpl = new UserImpl();
        userImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return userImpl;
    }
}

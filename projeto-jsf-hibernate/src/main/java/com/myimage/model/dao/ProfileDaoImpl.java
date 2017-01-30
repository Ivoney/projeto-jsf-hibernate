/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myimage.model.dao;

import com.myimage.model.Profile;
import org.hibernate.Session;

/**
 *
 * @author Yvonei
 */
public class ProfileDaoImpl implements ProfileDao{
    
    //definido um objeto referência responsável por fornecer métodos criar, alterar, remover e acessar objetos no BD
    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void save(Profile profile) {
        this.session.saveOrUpdate(profile);
     }
    
}

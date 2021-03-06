/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myimage.model.dao;

import com.myimage.model.Profile;
import com.myimage.model.User;
import java.util.List;
import java.util.Properties;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

/**
 *
 * @author Yvonei
 */
public class ProfileDaoImpl implements ProfileDao {

    //definido um objeto referência responsável por fornecer métodos criar, alterar, remover e acessar objetos no BD
    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void save(Profile profile) {
        this.session.saveOrUpdate(profile);
    }

    public boolean existsEmail(String email) {
        return session.bySimpleNaturalId(Profile.class).load(email) != null ? true : false;

    }

    public Properties profileActives() {
        List<Object> objects = null;
        Properties prop = new Properties();
        Criteria criteria = this.session.createCriteria(User.class);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.rowCount())
                .add(Projections.groupProperty("active")));

        objects = criteria.list();

        for (Object o : objects) {
            Object[] objArr = (Object[]) o;
            // chave: active, valor: quantidade
            prop.setProperty(objArr[1].toString(), objArr[0].toString());
        }
        return prop;
    }

}

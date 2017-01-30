/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myimage.business;

import com.myimage.dao.utils.DAOFactory;
import com.myimage.model.Profile;
import com.myimage.model.dao.ProfileDao;

/**
 *
 * @author Yvonei
 */
//Classe que controla as regras de negocios aplicada sobre profile.
public class ProfileBusiness {
    private ProfileDao profileDao;

    public ProfileBusiness() {
        super();
        setProfileDao(DAOFactory.createProfile());
    }

    public void setProfileDao(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }
    public void save(Profile profile){
        profileDao.save(profile);
    }
    
    
}

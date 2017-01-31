/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myimage.business;


import java.util.Properties;
 
import com.myimage.model.dao.ProfileDao;
import com.myimage.dao.utils.DAOFactory;
import com.myimage.model.Profile;
 
/**
 *
 * @author Yvonei
 */
public class ProfileBusiness {
 
    private ProfileDao ProfileDao;
     
     
    public ProfileBusiness() {
        super();
        setProfileDao(DAOFactory.createProfile());
    }    
     
    private void setProfileDao(ProfileDao profileDao) {
        ProfileDao = profileDao;
    }
 
    public void save(Profile Profile){
        ProfileDao.save(Profile);
    }
     
    public boolean existsEmail(String email){
        return ProfileDao.existsEmail(email);
    }
     
    public Properties profileActives(){
        return ProfileDao.profileActives();
    }
}
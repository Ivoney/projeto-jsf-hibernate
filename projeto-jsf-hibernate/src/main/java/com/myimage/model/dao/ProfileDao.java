/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myimage.model.dao;

import com.myimage.model.Profile;
import java.util.Properties;

/**
 *
 * @author Yvonei
 */
public interface ProfileDao {
    public void save(Profile profile);
    public boolean existsEmail(String email);
    public Properties profileActives();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myimage.controller;

/**
 *
 * @author Yvonei
 */
import com.myimage.business.UserBusiness;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
 
 
@ManagedBean(name="activation")
@RequestScoped
public class Activation {
 
    @ManagedProperty(value = "#{param.key}")
    private String key;
 
    private boolean valid = false;
 
    @PostConstruct
    public void init() {
        UserBusiness userBusiness = new UserBusiness();
        if(userBusiness.existsValidation(getKey())){
            setValid(true);
        }    
    }
 
    public String getKey() {
        return key;
    }
 
    public void setKey(String key) {
        this.key = key;
    }
 
    public boolean isValid() {
        return valid;
    }
 
    public void setValid(boolean valid) {
        this.valid = valid;
    }    
}
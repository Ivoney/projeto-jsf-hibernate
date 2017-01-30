/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myimage.utils;

/**
 *
 * @author Yvonei
 */
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
 
public class Context {
     
    public static String getContextPath() {

        HttpServletRequest req = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        return url.substring(0, url.length() - req.getRequestURI().length())
                + req.getContextPath() + "/";
    }

}

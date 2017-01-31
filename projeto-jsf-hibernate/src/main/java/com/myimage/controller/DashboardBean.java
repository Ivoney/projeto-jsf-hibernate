/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myimage.controller;


import com.myimage.business.ProfileBusiness;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
 
import javax.faces.bean.ManagedBean; 
import org.primefaces.model.chart.PieChartModel;
 
/**
 *
 * @author Yvonei
 */
@ManagedBean(name = "dashboard")
public class DashboardBean {
 
    private PieChartModel pieModel;
     
    private Properties prop = null;
 
    public DashboardBean() {
        ProfileBusiness profileBusiness = new ProfileBusiness();
        prop = profileBusiness.profileActives();
        createPieModel();
    }
 
    public PieChartModel getPieModel() {
        return pieModel;
    }
 
    private void createPieModel() {
        pieModel = new PieChartModel();
        Set actives = prop.keySet();
        Iterator itr = actives.iterator();
        while (itr.hasNext()) {
            String str = (String) itr.next();
            pieModel.set(str, Integer.parseInt((String) prop.get(str)));
        }
    }
}

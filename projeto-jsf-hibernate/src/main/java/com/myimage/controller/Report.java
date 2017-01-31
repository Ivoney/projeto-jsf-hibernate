/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myimage.controller;

import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.StreamedContent;
import com.myimage.utils.ReportUtil;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

/**
 *
 * @author Yvonei
 */
@ManagedBean(name = "report")
public class Report {

    private StreamedContent arquivoRetorno;

    public StreamedContent getArquivoRetorno() {
        FacesContext context = FacesContext.getCurrentInstance();
        ReportUtil reportUtil = new ReportUtil();
        HashMap parametrosRelatorio = new HashMap();
        try {
            this.arquivoRetorno = reportUtil.geraRelatorio(parametrosRelatorio);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
            return null;
        }
        return this.arquivoRetorno;
    }

    public void setArquivoRetorno(StreamedContent arquivoRetorno) {
        this.arquivoRetorno = arquivoRetorno;
    }
}

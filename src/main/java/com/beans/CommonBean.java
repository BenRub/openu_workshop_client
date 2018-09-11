package com.beans;

import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class CommonBean {
    
    public void Refresh() {
        Reload(null);
    }
    
    public void Reload(String url) {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        if (url == null) {
            url = ((HttpServletRequest) ec.getRequest()).getRequestURI();
        }
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            
        }
    }    
}

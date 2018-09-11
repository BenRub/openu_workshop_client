package com.filters;

import com.beans.LoginBean;
import com.mycompany.openu_workshop_client.Config;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { /* Nothing to do here! */ }

    @Override
    public void destroy() { /* Nothing to do here! */ }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LoginBean loginBean = (LoginBean)((HttpServletRequest)request).getSession().getAttribute("loginBean");
        
        if (loginBean == null) {
            String contextPath = ((HttpServletRequest)request).getContextPath();
            ((HttpServletResponse)response).sendRedirect(contextPath + "/faces/login.xhtml");
        }
        else {
            Config.Token = loginBean.getToken();
            chain.doFilter(request, response);
        }
    }
    
}

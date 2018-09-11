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
    private LoginBean loginBean;
    private String loginPath;
    
    public LoginFilter() {
        loginPath = "/faces/login.xhtml";
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { /* Nothing to do here! */ }

    @Override
    public void destroy() { /* Nothing to do here! */ }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = ((HttpServletRequest)request);
        
        GetLoginBean(httpRequest);
        
        if (!httpRequest.getRequestURI().endsWith(loginPath) && loginBean == null)
            GoToLogin(httpRequest, ((HttpServletResponse)response));
        else       
            chain.doFilter(request, response);
    }
    
    private void GetLoginBean(HttpServletRequest httpRequest) {
        loginBean = (LoginBean)(httpRequest.getSession().getAttribute("loginBean"));
        if (loginBean != null) {
            if (loginBean.isLogged())
                Config.Token = loginBean.getToken();
            else
                loginBean = null;
        }        
    }
    
    private void GoToLogin(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException {
        String contextPath = httpRequest.getContextPath();
        httpResponse.sendRedirect(contextPath + loginPath);        
    }
    
}

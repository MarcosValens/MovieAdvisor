package com.openwebinars.movieadvisor.filters;

import javax.servlet.*;
import java.io.IOException;

public class ErrorHandleFilter /*implements Filter*/ {
    //@Override
    public void destroy() {
    }

    //@Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Entrar al filter");
    }

    /*@Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doing filter");
        filterChain.doFilter(servletRequest,servletResponse);
    }*/
}

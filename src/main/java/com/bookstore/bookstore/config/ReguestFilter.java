package com.bookstore.bookstore.config;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ReguestFilter
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ReguestFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Method", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Header", "x-requested-with, x-auth-token");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        if (!(request.getMethod().equalsIgnoreCase("OPTIONS"))) {

            try {
                chain.doFilter(req, res);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("pre-flight");
            response.setHeader("Access-Control-Allow-Method", "POST, GET, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, x-auth-token, "
                    + "access-control-request-headers,access-control-request-method,accept,origin,authorization,x-requested-with");
            response.setStatus(HttpServletResponse.SC_OK);

        }

    }

    public void init(FilterConfig filterConfig) {

    }

    public void destroy() {
    }

}
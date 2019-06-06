package com.sysserve.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class LogFilter implements Filter {

    public void init (FilterConfig filterConfig) throws ServletException {
        // Get init parameter
        String testParam = filterConfig.getInitParameter("test-param");

        // Print the init parameter
        System.out.println("Test Param: " + testParam);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws java.io.IOException, ServletException {
        // Get the IP address of the remote client
        String ipAddress = request.getRemoteAddr();

        //Log the IP Address and Current Timestamp
        System.out.println("IP Address: " + ipAddress + "Time: " + new Date().toString());

        //Pass request back down the filter chain
        chain.doFilter(request, response);
    }

    public void destroy(){
        /* Called before the Filter instance is removed from service by the web container*/
    }
}

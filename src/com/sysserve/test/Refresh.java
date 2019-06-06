package com.sysserve.test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Refresh extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set refresh interval in seconds
        response.setIntHeader("Refresh", 5);
        // Set response MIME type
        response.setContentType("text/html");

        // Get current time

        Calendar calendar = new GregorianCalendar();
        String am_pm;
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        if (calendar.get(Calendar.AM_PM) == 0) {
            am_pm = "AM";
        } else {
            am_pm = "PM";
        }

        String CT = hour + ":" + minute + ":" + second + " " + am_pm;

        PrintWriter out = response.getWriter();
        String title = "Auto Refresh Header Setting";

        out.println(
                "<!doctype html>\n" +
                        "<html>\n" +
                            "<head><title>" + title + "</title></head>\n"+
                            "<body bgcolor = \"#f0f0f0\">\n" +
                                "<h1 align = \"center\">" + title + "</h1>\n"+
                                "<p> The Current Time is:" + CT + "</p>\n"+
                            "</body>" +
                        "</html>"
        );
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        doGet(request, response);
    }
}

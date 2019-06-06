package com.sysserve.test;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;
import java.net.http.HttpClient;

public class HelloForm extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set cookies for firstname and lastname
        Cookie firstName = new Cookie("first_name", request.getParameter("first_name"));
        Cookie lastName = new Cookie("last_name", request.getParameter("last_name"));

        // Set Expiry for 24hrs for both cookies
        firstName.setMaxAge(60*60*24);
        lastName.setMaxAge(60*60*24);

        // Add both cookies in the response header
        response.addCookie(firstName);
        response.addCookie(lastName);

        // Set content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Using GET Method to Read Form Data and Setting Cookies";
        out.println(
                "<!doctype html>\n" +
                        "<html>\n" +
                            "<head><title>" +title+ "</title></head>" +
                            "<body bgcolor = \"#f0f0f0\">\n" +
                            "<h1 align = \"center\">" + title + "</h1>\n" +
                            "<ul>\n" +
                                "  <li><b>First Name</b>: "
                                + request.getParameter("first_name") + "\n" +
                                "  <li><b>Last Name</b>: "
                                + request.getParameter("last_name") + "\n" +
                            "</ul>\n" +
                            "</body>" +
                        "</html>"
        );

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        doGet(request, response);
    }
}

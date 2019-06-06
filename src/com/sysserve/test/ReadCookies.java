package com.sysserve.test;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadCookies extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;

        // Get Array of cookies associated with this domain
        cookies = request.getCookies();

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Reading Cookies Example";


        out.println(
                "<!doctype html>\n"+
                    "<html>\n"+
                    "<head><title>" + title + "</title></head>"+
                    "<body bgcolor = \"#f0f0f0\">\n"
        );

        if (cookies != null){
            out.println(
                    "<h2>Found Cookies name and value</h2>"
            );
            for (int i = 0; i < cookies.length; i++){
                cookie = cookies[i];
                out.print("Name: " + cookie.getName() + ", ");
                out.print("Value: " + cookie.getValue() + "<br/>");
            }
        }else {
            out.println("<h2>No cookies Found!</h2>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}

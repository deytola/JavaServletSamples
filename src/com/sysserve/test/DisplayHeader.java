package com.sysserve.test;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class DisplayHeader extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Http Header Request Example";
        String docType = "<!doctype html>";
        out.println(
                docType +
                        "<html>\n"+
                            "<head><title>" + title + "</title></head>\n"+
                            "<body bgcolor = \"#f0f0f0\">\n"+
                                "<h1 align = \"center\">" + title + "</h1>\n" +
                                "<table width = \"100%\" border = \"1\" align = \"center\">\n" +
                                    "<tr bgcolor = \"#949494\">\n" +
                                        "<th>Header Name</th><th>Header Value(s)</th>\n"+
                                    "</tr>\n"
        );
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String paramName = (String) headerNames.nextElement();
            out.println(
                    "<tr><td>" + paramName + "</td>\n"
            );
            String paramValue = request.getHeader(paramName);
            out.println(
                    "<td>" + paramValue + "</td></tr>\n"
            );
        }
        out.println(
                "</table>\n</body></html>"
        );
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        doGet(request, response);
    }
}

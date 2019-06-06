package com.sysserve.test;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class ShowError extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendError(407, "Need Authentication!!!");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        doGet(request, response);
    }
}

package com.example.demo2;

import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "RedirectServlet", value = "/redirect-servlet")
public class RedirectServlet extends HttpServlet {

    private void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        String url = request.getParameter("redirectURL");

        response.setContentType("text/html;charset=UTF-8");

        if ("redirect".equals(action) && url != null) {
            // Message à afficher à l'utilisateur
            String message = "You will be redirected in 10 seconds. Action = " + action + ", URL = " + url;

            // Code HTML pour afficher le message et rediriger après 10 secondes
            String htmlResponse = "<html><body>" +
                    "<h1>" + message + "</h1>" +
                    "<script type='text/javascript'>" +
                    "setTimeout(function() {" +
                    "  window.location.href = '" + url + "';" +
                    "}, 10000);" + // redirige après 10 secondes
                    "</script>" +
                    "</body></html>";

            response.getWriter().println(htmlResponse);
        } else {
            String message = "Please provide a correct action and URL parameter. Action = " + action + ", URL = " + url;
            response.getWriter().println("<html><body><h1>" + message + "</h1></body></html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Appel de la méthode redirect pour gérer la redirection
        redirect(request, response);
    }

    @Override
    public void destroy() {
        // Code de nettoyage si nécessaire
    }
}

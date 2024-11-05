package com.example.exercise2;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Calcul", value = "/calcul-discriminant")
public class Calcul extends HttpServlet {

    // Méthode pour calculer le discriminant
    public double calculerDiscriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Récupération des paramètres et conversion en double
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));

        // Calcul du discriminant
        double discriminant = calculerDiscriminant(a, b, c);

        // Variables pour le texte et la couleur en fonction du discriminant
        String couleur;
        String texte;

        // Condition pour déterminer la nature des racines
        if (discriminant < 0) {
            couleur = "red";
            texte = "Le discriminant est negatif, il n'y a pas de racines reelles.";
        } else if (discriminant == 0) {
            couleur = "blue";
            double x = -b / (2 * a);
            texte = "Le discriminant est nul il  y a une racine";
        } else {
            couleur = "green";
            double x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            texte = "Le discriminant est positif, il y a deux racines reelles ";

        }
        response.sendRedirect("resultat.jsp?couleur=" + couleur + "&texte=" + texte);

    }

    public void destroy() {
        // Nettoyage si nécessaire
    }
}

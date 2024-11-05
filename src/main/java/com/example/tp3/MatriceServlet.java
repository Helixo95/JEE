package com.example.tp3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "matriceServlet", value ="/MatriceServlet")
public class MatriceServlet extends HttpServlet {
    private int[][] matrice = new int[10][10];  // Matrice 10x10 initialisée avec des zéros

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String paramX = request.getParameter("x");
        String paramY = request.getParameter("y");

        if (paramX == null && paramY == null) {
            // Affichage de la matrice complète sous forme de table HTML
            out.println("<html><body>");
            out.println("<table border='1'>");
            for (int i = 0; i < 10; i++) {
                out.println("<tr>");
                for (int j = 0; j < 10; j++) {
                    out.printf("<td>%d</td>", matrice[i][j]);
                }
                out.println("</tr>");
            }
            out.println("</table>");
            response.getWriter().println("<br><a href='matrice.jsp'>retour</a>");
            out.println("</body></html>");
        } else {
            // Affichage de la valeur d'une cellule spécifique
            try {
                int x = Integer.parseInt(paramX);
                int y = Integer.parseInt(paramY);
                if (x >= 0 && x < 10 && y >= 0 && y < 10) {
                    out.printf("Valeur de la cellule (%d, %d) : %d", x, y, matrice[x][y]);
                } else {
                    out.println("Erreur : Coordonnées (x, y) en dehors des limites de la matrice.");
                    response.getWriter().println("<br><a href='matrice.jsp'>retour</a>");
                }
            } catch (NumberFormatException e) {
                out.println("Erreur : Les coordonnées doivent être des entiers.");
                response.getWriter().println("<br><a href='matrice.jsp'>retour</a>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramX = request.getParameter("x");
        String paramY = request.getParameter("y");
        String paramVal = request.getParameter("val");

        if (paramX == null && paramY == null && paramVal == null) {
            // Réinitialisation de la matrice
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    matrice[i][j] = 0;
                }
            }
            response.getWriter().println("Matrice réinitialisée avec succès.");
            response.getWriter().println("<br><a href='matrice.jsp'>retour</a>");

        } else {
            // Mise à jour de la valeur d'une cellule spécifique
            try {
                int x = Integer.parseInt(paramX);
                int y = Integer.parseInt(paramY);
                int val = Integer.parseInt(paramVal);
                if (x >= 0 && x < 10 && y >= 0 && y < 10) {
                    matrice[x][y] = val;
                    response.getWriter().printf("Valeur de la cellule (%d, %d) mise à jour à %d.", x, y, val);
                } else {
                    response.getWriter().println("Erreur : Coordonnées (x, y) en dehors des limites de la matrice.");
                    response.getWriter().println("<br><a href='matrice.jsp'>retour</a>");
                }
            } catch (NumberFormatException e) {
                response.getWriter().println("Erreur : Les coordonnées et la valeur doivent être des entiers.");
                response.getWriter().println("<br><a href='matrice.jsp'>retour</a>");
            }
        }
    }
}

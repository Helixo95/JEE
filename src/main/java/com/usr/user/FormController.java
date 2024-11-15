package com.usr.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/FormController")
public class FormController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les paramètres
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String sexe = request.getParameter("sexe");
        String codePostal = request.getParameter("codePostal");
        String[] transports = request.getParameterValues("transports");

        // Vérification des champs obligatoires
        if (nom == null || nom.isEmpty() || prenom == null || prenom.isEmpty() ||
                sexe == null || sexe.isEmpty() || codePostal == null || codePostal.isEmpty()) {

            // Message d'erreur
            request.setAttribute("message", "Tous les champs obligatoires doivent être remplis.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("formulaire.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Créer un objet Utilisateur
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setSexe(sexe);
        utilisateur.setCodePostal(codePostal);
        utilisateur.setTransports(transports);

        // Ajouter l'utilisateur dans la session
        HttpSession session = request.getSession();
        session.setAttribute("utilisateur", utilisateur);

        // Rediriger vers la vue (resultat.jsp)
        response.sendRedirect("resultat.jsp");
    }
}

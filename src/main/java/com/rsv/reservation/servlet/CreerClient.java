package com.rsv.reservation.servlet;

import java.io.IOException;

import com.rsv.reservation.beans.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/CreerClient")
public class CreerClient extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les paramètres
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");

        // Vérification des champs vides
        if (nom.isEmpty() || prenom.isEmpty() || telephone.isEmpty() || email.isEmpty()) {
            // Ajouter un message d'erreur et retourner à la page d'inscription
            request.setAttribute("message", "Vous devez remplir tous les champs.");
            request.setAttribute("messageType", "error");

            // Conserver les données saisies
            request.setAttribute("nom", nom);
            request.setAttribute("prenom", prenom);
            request.setAttribute("telephone", telephone);
            request.setAttribute("email", email);

            RequestDispatcher dispatcher = request.getRequestDispatcher("inscription.jsp");
            dispatcher.forward(request, response);
        } else {
            // Crée un nouvel objet Client
            Client client = new Client();

            // Utilisation des setters pour initialiser les attributs
            client.setNom(nom);
            client.setPrenom(prenom);
            client.setTelephone(telephone);
            client.setEmail(email);


            // Ajouter l'objet dans la requête
            request.setAttribute("client", client);
            request.setAttribute("message", "Inscription avec succès !");
            request.setAttribute("messageType", "success");

            // Rediriger vers la page info_client.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("info_client.jsp");
            dispatcher.forward(request, response);
        }
    }
}

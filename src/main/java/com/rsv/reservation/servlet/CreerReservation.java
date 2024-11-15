package com.rsv.reservation.servlet;

import java.io.IOException;

import com.rsv.reservation.beans.Reservation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/CreerReservation")
public class CreerReservation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les paramètres
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String typeAppartement = request.getParameter("typeAppartement");
        String prixStr = request.getParameter("prix");
        String[] optionsArray = request.getParameterValues("options");

        // Concaténer les options sélectionnées
        String options = optionsArray != null ? String.join(", ", optionsArray) : "";

        // Vérification des champs vides
        if (nom.isEmpty() || prenom.isEmpty() || telephone.isEmpty() || email.isEmpty() ||
                typeAppartement.isEmpty() || prixStr.isEmpty()) {
            request.setAttribute("message", "Vous devez remplir tous les champs.");

            // Conserver les données saisies
            request.setAttribute("nom", nom);
            request.setAttribute("prenom", prenom);
            request.setAttribute("telephone", telephone);
            request.setAttribute("email", email);
            request.setAttribute("typeAppartement", typeAppartement);
            request.setAttribute("prix", prixStr);

            RequestDispatcher dispatcher = request.getRequestDispatcher("reservation.jsp");
            dispatcher.forward(request, response);
        } else {
            // Convertir le prix
            double prix = Double.parseDouble(prixStr);
            // Crée un nouvel objet Reservation
            Reservation reservation = new Reservation();

            // Utilisation des setters pour initialiser les attributs
            reservation.setNom(nom);
            reservation.setPrenom(prenom);
            reservation.setTelephone(telephone);
            reservation.setEmail(email);
            reservation.setTypeAppartement(typeAppartement);
            reservation.setPrix(prix);

            // Ajouter l'objet dans la requête
            request.setAttribute("reservation", reservation);

            // Rediriger vers la page de confirmation
            RequestDispatcher dispatcher = request.getRequestDispatcher("info_reservation.jsp");
            dispatcher.forward(request, response);
        }
    }
}

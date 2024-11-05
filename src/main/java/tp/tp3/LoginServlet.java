package tp.tp3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final String USERNAME = "J2EE";
    private static final String PASSWORD = "J2EE";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Vérification des informations de connexion
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            // Connexion réussie
            request.setAttribute("message", "Welcome to your First JSP page");
        } else {
            // Échec de la connexion
            request.setAttribute("message", "Identification Failure");
        }

        // Rediriger vers resultat.jsp
        this.getServletContext().getRequestDispatcher("/WEB-INF/resultat.jsp").forward(request, response);
    }
}

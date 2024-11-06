package tp.tp2;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final String USERNAME = "J2EE";
    private static final String PASSWORD = "J2EE";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Login Successful</h2>");
            out.println("<form action='RedirectServlet' method='post'>");
            out.println("<label for='action'>Action:</label>");
            out.println("<select id='action' name='action'>");
            out.println("<option value='GoogleSearch'>GoogleSearch</option>");
            out.println("<option value='PageRedirect'>PageRedirect</option>");
            out.println("</select><br><br>");
            out.println("<label for='page'>Page:</label>");
            out.println("<input type='text' id='page' name='page' value='http://google.fr'><br><br>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
            out.println("</body></html>");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Login Failed</h2>");
            out.println("<p>Invalid username or password</p>");
            out.println("</body></html>");
        }
    }
}

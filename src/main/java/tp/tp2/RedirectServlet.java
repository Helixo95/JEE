package tp.tp2;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "RedirectServlet", value = "/RedirectServlet")
public class RedirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        String page = request.getParameter("page");

        if ("PageRedirect".equals(action)) {
            response.sendRedirect(page);
        } else if ("GoogleSearch".equals(action)) {
            response.sendRedirect("https://www.google.com/search?q=" + page);
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Invalid Action</h2>");
            out.println("</body></html>");
        }
    }
}
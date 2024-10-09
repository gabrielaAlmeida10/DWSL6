package exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebServlet("/show-cookie-servlet")
public class ShowCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cookie[] cookies = request.getCookies();

        String nomeUsuario = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("usuario".equals(cookie.getName())) {
                    nomeUsuario = cookie.getValue();
                    break;
                }
            }
        }

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        if (nomeUsuario != null) {
            response.getWriter().println("<h2>Bem-vindo, " + nomeUsuario + "!</h2>");
            response.getWriter().println("<a href='remove-cookie-servlet'>Remover Cookie</a>");
        } else {
            response.getWriter().println("<h2>O cookie expirou ou foi removido.</h2>");
        }
        response.getWriter().println("</body></html>");
    }
}
